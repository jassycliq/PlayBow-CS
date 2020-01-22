package com.jassycliq.playbowcs.activity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserTransactionHistoryData {

    @SerializedName("user_transaction_history")
    @Expose
    private List<UserTransactionHistory> userTransactionHistory = null;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("next_page")
    @Expose
    private Integer nextPage;
    @SerializedName("is_next_page_available")
    @Expose
    private Boolean isNextPageAvailable;

    public List<UserTransactionHistory> getUserTransactionHistory() {
        return userTransactionHistory;
    }

    public void setUserTransactionHistory(List<UserTransactionHistory> userTransactionHistory) {
        this.userTransactionHistory = userTransactionHistory;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Boolean getIsNextPageAvailable() {
        return isNextPageAvailable;
    }

    public void setIsNextPageAvailable(Boolean isNextPageAvailable) {
        this.isNextPageAvailable = isNextPageAvailable;
    }
}
