/* ============================================================
   NoStrings — shared frontend utilities
   Wraps the backend REST API (see FriendRequestController /
   OnboardingController) and provides small UI helpers reused
   across every page.
   ============================================================ */

// Works whether the page is served BY Spring Boot (same-origin, relative
// path) or opened on its own (e.g. file:// or a static file server) while
// the backend runs locally on port 8080.
const API_BASE = (() => {
    if (window.location.protocol === "http:" || window.location.protocol === "https:") {
        if (window.location.port && window.location.port !== "8080") {
            return "http://localhost:8080/api/noStrings";
        }
        return `${window.location.origin}/api/noStrings`;
    }
    return "http://localhost:8080/api/noStrings";
})();

const STORAGE_KEY = "nostrings_session";

/* ---------------- session (client-side "sign in") ----------------
   The backend has no login endpoint (no /login, no findByEmail) — the
   only identifier it understands is the userId returned at registration.
   We treat that userId as the person's access key: they save it on
   sign-up and use it to sign back in on the Sign In page. */

const Session = {
    get() {
        try {
            const raw = localStorage.getItem(STORAGE_KEY);
            return raw ? JSON.parse(raw) : null;
        } catch {
            return null;
        }
    },
    set(session) {
        localStorage.setItem(STORAGE_KEY, JSON.stringify(session));
    },
    clear() {
        localStorage.removeItem(STORAGE_KEY);
    },
    requireOrRedirect() {
        const s = Session.get();
        if (!s || !s.userId) {
            window.location.href = "signin.html";
            return null;
        }
        return s;
    }
};

/* ---------------- toasts ---------------- */

function ensureToastStack() {
    let stack = document.getElementById("toast-stack");
    if (!stack) {
        stack = document.createElement("div");
        stack.id = "toast-stack";
        document.body.appendChild(stack);
    }
    return stack;
}

function showToast(message, type = "info", timeout = 4500) {
    const stack = ensureToastStack();
    const el = document.createElement("div");
    el.className = `toast toast-${type}`;
    el.textContent = message;
    stack.appendChild(el);
    setTimeout(() => {
        el.style.transition = "opacity 0.2s ease";
        el.style.opacity = "0";
        setTimeout(() => el.remove(), 200);
    }, timeout);
}

/* ---------------- API wrapper ---------------- */

/**
 * Calls the noStrings API and normalizes errors to the backend's
 * ApiErrorResponse shape: { status, error, message, timestamp }.
 */
async function apiRequest(path, { method = "GET", body } = {}) {
    let response;
    try {
        response = await fetch(`${API_BASE}${path}`, {
            method,
            headers: { "Content-Type": "application/json" },
            body: body !== undefined ? JSON.stringify(body) : undefined
        });
    } catch (networkErr) {
        throw {
            status: 0,
            error: "Network Error",
            message: "Couldn't reach the NoStrings server. Is the backend running on port 8080?"
        };
    }

    const text = await response.text();
    const data = text ? JSON.parse(text) : null;

    if (!response.ok) {
        throw data || {
            status: response.status,
            error: response.statusText,
            message: "Something went wrong."
        };
    }
    return data;
}

const Api = {
    register(payload) {
        return apiRequest("/register", { method: "POST", body: payload });
    },
    sendFriendRequest(payload) {
        return apiRequest("/friend-requests", { method: "POST", body: payload });
    },
    acceptFriendRequest(requestId) {
        return apiRequest(`/friend-requests/${requestId}/accept`, { method: "POST" });
    },
    declineFriendRequest(requestId) {
        return apiRequest(`/friend-requests/${requestId}/decline`, { method: "POST" });
    },
    findAllFriendRequests() {
        return apiRequest("/friend-requests");
    },
    findInbox(userId) {
        return apiRequest(`/friend-requests/inbox/${userId}`);
    }
};

/* ---------------- small shared UI helpers ---------------- */

function initMobileNav() {
    const toggle = document.getElementById("nav-toggle");
    const menu = document.getElementById("mobile-menu");
    if (!toggle || !menu) return;
    toggle.addEventListener("click", () => {
        const isOpen = menu.classList.toggle("open");
        toggle.setAttribute("aria-expanded", isOpen ? "true" : "false");
    });
}

function setButtonLoading(button, loading, loadingText = "Please wait…") {
    if (loading) {
        button.dataset.originalText = button.innerHTML;
        button.disabled = true;
        button.innerHTML = `<span class="spinner mr-2 align-middle"></span>${loadingText}`;
    } else {
        button.disabled = false;
        if (button.dataset.originalText) button.innerHTML = button.dataset.originalText;
    }
}

function initials(name) {
    if (!name) return "?";
    return name.split(" ").filter(Boolean).slice(0, 2).map(p => p[0].toUpperCase()).join("");
}

function formatDate(iso) {
    if (!iso) return "";
    const d = new Date(iso);
    if (isNaN(d)) return iso;
    return d.toLocaleDateString(undefined, { month: "short", day: "numeric", year: "numeric" }) +
        " · " + d.toLocaleTimeString(undefined, { hour: "numeric", minute: "2-digit" });
}

document.addEventListener("DOMContentLoaded", initMobileNav);
