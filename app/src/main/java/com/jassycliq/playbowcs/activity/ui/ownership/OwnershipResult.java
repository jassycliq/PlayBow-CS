package com.jassycliq.playbowcs.activity.ui.ownership;

import androidx.annotation.Nullable;

public class OwnershipResult {
    @Nullable
    private Throwable failure;

    OwnershipResult(@Nullable Throwable failure) {
        this.failure = failure;
    }

    @Nullable
    Throwable getFailure() {
        return failure;
    }
}
