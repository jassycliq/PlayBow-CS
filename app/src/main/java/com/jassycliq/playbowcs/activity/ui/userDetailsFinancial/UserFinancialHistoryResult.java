package com.jassycliq.playbowcs.activity.ui.userDetailsFinancial;

import androidx.annotation.Nullable;

import com.jassycliq.playbowcs.activity.data.model.UserTransactionHistoryData;

public class UserFinancialHistoryResult {
    @Nullable
    private UserTransactionHistoryData success;
    @Nullable
    private Throwable failure;

    UserFinancialHistoryResult(@Nullable UserTransactionHistoryData success) {
        this.success = success;
    }
    UserFinancialHistoryResult(@Nullable Throwable failure) {
        this.failure = failure;
    }

    @Nullable
    UserTransactionHistoryData getSuccess() {
        return success;
    }
    @Nullable
    Throwable getFailure() {
        return failure;
    }
}
