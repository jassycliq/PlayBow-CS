package com.jassycliq.playbowcs.activity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DaycareCalendarDogProfileList {
    @SerializedName("dog_profile")
    @Expose
    private List<DaycareCalendarDogProfile> dogProfile = null;

    public List<DaycareCalendarDogProfile> getDogProfile() {
        return dogProfile;
    }

    public void setDogProfile(List<DaycareCalendarDogProfile> dogProfile) {
        this.dogProfile = dogProfile;
    }
}
