package com.jassycliq.playbowcs.activity.ui.login;

import androidx.annotation.Nullable;

import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private LoggedInUser success;
    @Nullable
    private Throwable failure;

    LoginResult(@Nullable LoggedInUser success) {
        this.success = success;
    }

    LoginResult(@Nullable Throwable failure) {
        this.failure = failure;
    }

    @Nullable
    LoggedInUser getSuccess() {
        return success;
    }

    @Nullable
    Throwable getFailure() {
        return failure;
    }
}
