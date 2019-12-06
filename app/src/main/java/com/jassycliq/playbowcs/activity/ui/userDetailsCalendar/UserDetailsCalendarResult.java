package com.jassycliq.playbowcs.activity.ui.userDetailsCalendar;

import androidx.annotation.Nullable;

public class UserDetailsCalendarResult {
    @Nullable
    private Throwable failure;

    UserDetailsCalendarResult(@Nullable Throwable failure) {
        this.failure = failure;
    }

    @Nullable
    Throwable getFailure() {
        return failure;
    }
}
