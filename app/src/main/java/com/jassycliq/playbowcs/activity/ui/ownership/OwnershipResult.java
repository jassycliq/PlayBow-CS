package com.jassycliq.playbowcs.activity.ui.ownership;

import androidx.annotation.Nullable;

import com.jassycliq.playbowcs.model.OwnershipModel;

public class OwnershipResult {
    @Nullable
    private OwnershipModel success;
    @Nullable
    private Throwable failure;

    OwnershipResult(@Nullable OwnershipModel success) {
        this.success = success;
    }

    OwnershipResult(@Nullable Throwable failure) {
        this.failure = failure;
    }

    @Nullable
    OwnershipModel getSuccess() {
        return success;
    }

    @Nullable
    Throwable getFailure() {
        return failure;
    }
}
