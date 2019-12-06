package com.jassycliq.playbowcs.activity.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookingUser {

    @SerializedName("dog_ownership")
    @Expose
    private BookingDogOwnership dogOwnership;
    @SerializedName("booked_dates")
    @Expose
    private List<BookingData> bookedDates = null;

    public BookingDogOwnership getDogOwnership() {
        return dogOwnership;
    }

    public void setDogOwnership(BookingDogOwnership dogOwnership) {
        this.dogOwnership = dogOwnership;
    }

    public List<BookingData> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(List<BookingData> bookedDates) {
        this.bookedDates = bookedDates;
    }

}
