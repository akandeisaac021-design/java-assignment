(() => {
    const form = document.getElementById("signin-form");
    const submitBtn = document.getElementById("submit-btn");
    const formError = document.getElementById("form-error");

    // Already signed in? Skip straight to the dashboard.
    const existing = Session.get();
    if (existing && existing.userId) {
        window.location.href = "dashboard.html";
        return;
    }

    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        formError.classList.add("hidden");

        const userId = form.userId.value.trim();
        if (!userId) {
            formError.textContent = "Enter your User ID.";
            formError.classList.remove("hidden");
            return;
        }

        setButtonLoading(submitBtn, true, "Signing in…");
        try {
            // The backend has no dedicated login endpoint, so we confirm the
            // ID is real by asking for its inbox — a 404 means it doesn't exist.
            await Api.findInbox(userId);
            Session.set({ userId });
            showToast("Signed in", "success", 1500);
            window.location.href = "dashboard.html";
        } catch (err) {
            const message = err?.status === 404
                ? "We couldn't find an account with that User ID."
                : (err?.message || "Something went wrong. Please try again.");
            formError.textContent = message;
            formError.classList.remove("hidden");
        } finally {
            setButtonLoading(submitBtn, false);
        }
    });
})();
