package com.jassycliq.playbowcs.activity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DogProfile {

    @SerializedName("dogID")
    @Expose
    private String dogID;
    @SerializedName("dogName")
    @Expose
    private String dogName;
    @SerializedName("dogPhoto")
    @Expose
    private String dogPhoto;

    public String getDogID() {
        return dogID;
    }

    public void setDogID(String dogID) {
        this.dogID = dogID;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogPhoto() {
        return dogPhoto;
    }

    public void setDogPhoto(String dogPhoto) {
        this.dogPhoto = dogPhoto;
    }

}
