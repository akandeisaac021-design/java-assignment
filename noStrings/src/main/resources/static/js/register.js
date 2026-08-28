(() => {
    const form = document.getElementById("register-form");
    const submitBtn = document.getElementById("submit-btn");
    const formError = document.getElementById("form-error");
    const togglePassword = document.getElementById("toggle-password");
    const passwordInput = document.getElementById("password");

    let lastResult = null;

    // Cap the DOB picker at "18 years ago" so obviously-underage dates
    // are caught before the request round-trips to the server.
    const dobInput = document.getElementById("dob");
    const eighteenYearsAgo = new Date();
    eighteenYearsAgo.setFullYear(eighteenYearsAgo.getFullYear() - 18);
    dobInput.max = eighteenYearsAgo.toISOString().split("T")[0];

    togglePassword.addEventListener("click", () => {
        const isPwd = passwordInput.type === "password";
        passwordInput.type = isPwd ? "text" : "password";
        togglePassword.textContent = isPwd ? "Hide" : "Show";
    });

    function clearFieldErrors() {
        form.querySelectorAll(".error-msg").forEach(el => {
            el.textContent = "";
            el.classList.add("hidden");
        });
        formError.classList.add("hidden");
        formError.textContent = "";
    }

    function showFieldError(fieldId, message) {
        const input = document.getElementById(fieldId);
        const msg = input?.parentElement?.querySelector(".error-msg")
            ?? input?.closest("div")?.querySelector(".error-msg");
        if (msg) {
            msg.textContent = message;
            msg.classList.remove("hidden");
        }
    }

    function validate(values) {
        const errors = {};
        if (!values.firstName.trim()) errors.firstName = "First name is required";
        if (!values.lastName.trim()) errors.lastName = "Last name is required";
        if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(values.email)) errors.email = "Enter a valid email address";
        if (!values.password || values.password.length < 4) errors.password = "Password must be at least 4 characters";
        if (!values.gender) errors.gender = "Please select a gender";
        if (!values.dob) {
            errors.dob = "Date of birth is required";
        } else {
            const age = Math.floor((Date.now() - new Date(values.dob).getTime()) / (1000 * 60 * 60 * 24 * 365.25));
            if (age < 18) errors.dob = "You must be at least 18 years old";
        }
        return errors;
    }

    form.addEventListener("submit", async (e) => {
        e.preventDefault();
        clearFieldErrors();

        const values = {
            firstName: form.firstName.value,
            lastName: form.lastName.value,
            email: form.email.value,
            password: form.password.value,
            gender: form.gender.value,
            dob: form.dob.value
        };

        const errors = validate(values);
        if (Object.keys(errors).length > 0) {
            Object.entries(errors).forEach(([field, msg]) => showFieldError(field, msg));
            return;
        }

        setButtonLoading(submitBtn, true, "Creating account…");
        try {
            const result = await Api.register(values);
            lastResult = result;
            showSuccess(result);
        } catch (err) {
            handleApiError(err);
        } finally {
            setButtonLoading(submitBtn, false);
        }
    });

    function handleApiError(err) {
        // GlobalExceptionHandler returns { status, error, message } — surface
        // it as a form-level banner and let the person retry.
        const message = err?.message || "Something went wrong. Please try again.";
        formError.textContent = message;
        formError.classList.remove("hidden");
        showToast(message, "error");
    }

    function showSuccess(result) {
        document.getElementById("welcome-name").textContent = result.fullName || "there";
        document.getElementById("user-id-display").textContent = result.userId;
        document.getElementById("success-modal").classList.remove("hidden");
    }

    document.getElementById("copy-id-btn").addEventListener("click", async () => {
        if (!lastResult) return;
        try {
            await navigator.clipboard.writeText(lastResult.userId);
            showToast("User ID copied to clipboard", "success", 2000);
        } catch {
            showToast("Couldn't copy — select and copy the ID manually", "error");
        }
    });

    document.getElementById("continue-btn").addEventListener("click", () => {
        if (!lastResult) return;
        Session.set({
            userId: lastResult.userId,
            seekerId: lastResult.seekerId,
            email: lastResult.email,
            fullName: lastResult.fullName
        });
        window.location.href = "dashboard.html";
    });
})();
