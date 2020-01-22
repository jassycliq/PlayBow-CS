package com.jassycliq.playbowcs.activity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserTransactionHistory {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("membership_id")
    @Expose
    private String membershipId;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("transaction_type")
    @Expose
    private String transactionType;
    @SerializedName("ewallet")
    @Expose
    private String ewallet;
    @SerializedName("closing_ewallet")
    @Expose
    private String closingEwallet;
    @SerializedName("transaction_message")
    @Expose
    private String transactionMessage;
    @SerializedName("transaction_datetime")
    @Expose
    private String transactionDatetime;
    @SerializedName("transaction_status")
    @Expose
    private String transactionStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getEwallet() {
        return ewallet;
    }

    public void setEwallet(String ewallet) {
        this.ewallet = ewallet;
    }

    public String getClosingEwallet() {
        return closingEwallet;
    }

    public void setClosingEwallet(String closingEwallet) {
        this.closingEwallet = closingEwallet;
    }

    public String getTransactionMessage() {
        return transactionMessage;
    }

    public void setTransactionMessage(String transactionMessage) {
        this.transactionMessage = transactionMessage;
    }

    public String getTransactionDatetime() {
        return transactionDatetime;
    }

    public void setTransactionDatetime(String transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
