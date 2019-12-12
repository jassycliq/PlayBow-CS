package com.jassycliq.playbowcs.activity.ui.daycareCalendar;

import androidx.annotation.Nullable;

import com.jassycliq.playbowcs.activity.data.model.DaycareCalendarResponse;

public class DaycareCalendarResult {
    @Nullable
    private DaycareCalendarResponse success;
    @Nullable
    private Throwable failure;

    DaycareCalendarResult(@Nullable DaycareCalendarResponse success) {
        this.success = success;
    }

    DaycareCalendarResult(@Nullable Throwable failure) {
        this.failure = failure;
    }

    @Nullable
    DaycareCalendarResponse getSuccess() {
        return success;
    }

    @Nullable
    Throwable getFailure() {
        return failure;
    }
}
