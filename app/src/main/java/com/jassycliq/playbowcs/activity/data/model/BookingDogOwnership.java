package com.jassycliq.playbowcs.activity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookingDogOwnership {

    @SerializedName("dogs")
    @Expose
    private List<BookingDog> dogs = null;

    public List<BookingDog> getDogs() {
        return dogs;
    }

    public void setDogs(List<BookingDog> dogs) {
        this.dogs = dogs;
    }

}
