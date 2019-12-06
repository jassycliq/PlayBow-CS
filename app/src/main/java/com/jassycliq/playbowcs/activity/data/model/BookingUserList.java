package com.jassycliq.playbowcs.activity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookingUserList {

    @SerializedName("user_profile")
    @Expose
    private List<BookingUser> userProfile = null;

    public List<BookingUser> getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(List<BookingUser> userProfile) {
        this.userProfile = userProfile;
    }
}
