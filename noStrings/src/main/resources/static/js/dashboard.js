(() => {
    const session = Session.requireOrRedirect();
    if (!session) return; // redirecting to signin.html

    document.getElementById("my-id").textContent = session.userId;
    document.getElementById("my-id-mobile").textContent = session.userId;
    if (session.fullName) {
        document.getElementById("welcome-suffix").textContent = `, ${session.fullName.split(" ")[0]}`;
    }

    /* ---------------- sign out / copy id ---------------- */

    function signOut() {
        Session.clear();
        window.location.href = "index.html";
    }
    document.getElementById("signout-btn").addEventListener("click", signOut);
    document.getElementById("signout-btn-mobile").addEventListener("click", signOut);

    async function copyId() {
        try {
            await navigator.clipboard.writeText(session.userId);
            showToast("User ID copied", "success", 1800);
        } catch {
            showToast("Couldn't copy — select and copy manually", "error");
        }
    }
    document.getElementById("copy-my-id").addEventListener("click", copyId);
    document.getElementById("copy-my-id-mobile").addEventListener("click", copyId);

    /* ---------------- tabs ---------------- */

    const tabButtons = document.querySelectorAll(".tab-btn");
    const panels = {
        inbox: document.getElementById("panel-inbox"),
        send: document.getElementById("panel-send"),
        all: document.getElementById("panel-all")
    };

    function activateTab(name) {
        tabButtons.forEach(btn => btn.classList.toggle("active", btn.dataset.tab === name));
        Object.entries(panels).forEach(([key, panel]) => panel.classList.toggle("hidden", key !== name));
        if (name === "inbox") loadInbox();
        if (name === "all") loadAll();
    }

    tabButtons.forEach(btn => btn.addEventListener("click", () => activateTab(btn.dataset.tab)));

    /* ---------------- shared card rendering ---------------- */

    const template = document.getElementById("request-card-template");

    function statusClass(status) {
        if (status === "PENDING") return "pill-pending";
        if (status === "ACCEPTED") return "pill-accepted";
        if (status === "DECLINED") return "pill-declined";
        return "";
    }

    /**
     * Renders one FriendRequestResponse into a card.
     * `perspective` controls the title ("from X" vs "to X") and which
     * action buttons make sense (inbox cards get Accept/Decline; the
     * all-requests view is read-only).
     */
    function renderCard(req, { perspective, onAction }) {
        const node = template.content.cloneNode(true);
        const nameForTitle = perspective === "inbox" ? req.senderName : req.senderName;
        const el = node.querySelector("div");

        const otherName = perspective === "inbox" ? req.senderName : `${req.senderName} → ${req.receiverName}`;
        node.querySelector('[data-field="avatar"]').textContent = initials(req.senderName || req.receiverName);
        node.querySelector('[data-field="title"]').textContent =
            perspective === "inbox" ? `${req.senderName || "Someone"} sent you a request` : otherName;
        const statusEl = node.querySelector('[data-field="status"]');
        statusEl.textContent = req.status;
        statusEl.className = `text-[10px] font-semibold uppercase tracking-wide px-2 py-0.5 rounded-full ${statusClass(req.status)}`;
        node.querySelector('[data-field="message"]').textContent = req.message ? `"${req.message}"` : "No message attached";
        node.querySelector('[data-field="meta"]').textContent = formatDate(req.createdAt);

        const actions = node.querySelector('[data-field="actions"]');
        if (perspective === "inbox" && req.status === "PENDING") {
            const acceptBtn = document.createElement("button");
            acceptBtn.className = "btn-primary text-white text-xs font-semibold px-4 py-2 rounded-lg";
            acceptBtn.textContent = "Accept";
            acceptBtn.addEventListener("click", () => onAction(req.requestId, "accept", acceptBtn));

            const declineBtn = document.createElement("button");
            declineBtn.className = "bg-white/10 hover:bg-white/20 border border-white/15 text-white text-xs font-semibold px-4 py-2 rounded-lg";
            declineBtn.textContent = "Decline";
            declineBtn.addEventListener("click", () => onAction(req.requestId, "decline", declineBtn));

            actions.append(acceptBtn, declineBtn);
        }
        return node;
    }

    /* ---------------- inbox ---------------- */

    const inboxList = document.getElementById("inbox-list");
    const inboxEmpty = document.getElementById("inbox-empty");
    const inboxLoading = document.getElementById("inbox-loading");
    const inboxCount = document.getElementById("inbox-count");

    async function loadInbox() {
        inboxLoading.classList.remove("hidden");
        inboxEmpty.classList.add("hidden");
        inboxList.innerHTML = "";
        try {
            const requests = await Api.findInbox(session.userId);
            const pendingCount = requests.filter(r => r.status === "PENDING").length;
            inboxCount.textContent = pendingCount > 0 ? `(${pendingCount} pending)` : "";
            if (requests.length === 0) {
                inboxEmpty.classList.remove("hidden");
            } else {
                requests
                    .sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
                    .forEach(req => inboxList.appendChild(renderCard(req, { perspective: "inbox", onAction: handleInboxAction })));
            }
        } catch (err) {
            showToast(err?.message || "Couldn't load your inbox", "error");
        } finally {
            inboxLoading.classList.add("hidden");
        }
    }

    async function handleInboxAction(requestId, action, button) {
        setButtonLoading(button, true, action === "accept" ? "Accepting…" : "Declining…");
        try {
            if (action === "accept") {
                await Api.acceptFriendRequest(requestId);
                showToast("Friend request accepted", "success");
            } else {
                await Api.declineFriendRequest(requestId);
                showToast("Friend request declined", "info");
            }
            loadInbox();
        } catch (err) {
            showToast(err?.message || "That action couldn't be completed", "error");
            setButtonLoading(button, false);
        }
    }

    document.getElementById("refresh-inbox").addEventListener("click", loadInbox);

    /* ---------------- send request ---------------- */

    const sendForm = document.getElementById("send-form");
    const sendBtn = document.getElementById("send-btn");
    const sendFormError = document.getElementById("send-form-error");

    sendForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        sendFormError.classList.add("hidden");
        sendForm.querySelector(".error-msg")?.classList.add("hidden");

        const receiverId = sendForm.receiverId.value.trim();
        const message = sendForm.message.value.trim();

        if (!receiverId) {
            const msg = sendForm.querySelector(".error-msg");
            msg.textContent = "Enter the User ID of the person you want to add.";
            msg.classList.remove("hidden");
            return;
        }
        if (receiverId === session.userId) {
            sendFormError.textContent = "You can't send a friend request to yourself.";
            sendFormError.classList.remove("hidden");
            return;
        }

        setButtonLoading(sendBtn, true, "Sending…");
        try {
            await Api.sendFriendRequest({ senderId: session.userId, receiverId, message: message || undefined });
            showToast("Friend request sent", "success");
            sendForm.reset();
        } catch (err) {
            sendFormError.textContent = err?.message || "Couldn't send that request.";
            sendFormError.classList.remove("hidden");
        } finally {
            setButtonLoading(sendBtn, false);
        }
    });

    /* ---------------- all requests ---------------- */

    const allList = document.getElementById("all-list");
    const allEmpty = document.getElementById("all-empty");
    const allLoading = document.getElementById("all-loading");

    async function loadAll() {
        allLoading.classList.remove("hidden");
        allEmpty.classList.add("hidden");
        allList.innerHTML = "";
        try {
            const requests = await Api.findAllFriendRequests();
            if (requests.length === 0) {
                allEmpty.classList.remove("hidden");
            } else {
                requests
                    .sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
                    .forEach(req => allList.appendChild(renderCard(req, { perspective: "all", onAction: null })));
            }
        } catch (err) {
            showToast(err?.message || "Couldn't load requests", "error");
        } finally {
            allLoading.classList.add("hidden");
        }
    }

    document.getElementById("refresh-all").addEventListener("click", loadAll);

    /* ---------------- init ---------------- */

    activateTab("inbox");
})();
