package com.jassycliq.playbowcs.activity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserTransactionHistoryResponse {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private UserTransactionHistoryData userTransactionHistoryData;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserTransactionHistoryData getUserTransactionHistoryData() {
        return userTransactionHistoryData;
    }

    public void setUserTransactionHistoryData(UserTransactionHistoryData userTransactionHistoryData) {
        this.userTransactionHistoryData = userTransactionHistoryData;
    }
}
