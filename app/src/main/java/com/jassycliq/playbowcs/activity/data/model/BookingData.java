package com.jassycliq.playbowcs.activity.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingData {

    @SerializedName("dog_id")
    @Expose
    private String dogId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("membership_id")
    @Expose
    private String membershipId;
    @SerializedName("booking_date")
    @Expose
    private String bookingDate;
    @SerializedName("dog_booking_rate")
    @Expose
    private Float dogBookingRate;
    @SerializedName("delivery_option")
    @Expose
    private Integer deliveryOption;
    @SerializedName("tips_percentage")
    @Expose
    private String tipsPercentage;
    @SerializedName("tips_amount")
    @Expose
    private Float tipsAmount;
    @SerializedName("is_special_rate")
    @Expose
    private String isSpecialRate;
    @SerializedName("total_amount")
    @Expose
    private String totalAmount;

    public String getDogId() {
        return dogId;
    }

    public void setDogId(String dogId) {
        this.dogId = dogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Float getDogBookingRate() {
        return dogBookingRate;
    }

    public void setDogBookingRate(Float dogBookingRate) {
        this.dogBookingRate = dogBookingRate;
    }

    public Integer getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(Integer deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public String getTipsPercentage() {
        return tipsPercentage;
    }

    public void setTipsPercentage(String tipsPercentage) {
        this.tipsPercentage = tipsPercentage;
    }

    public Float getTipsAmount() {
        return tipsAmount;
    }

    public void setTipsAmount(Float tipsAmount) {
        this.tipsAmount = tipsAmount;
    }

    public String getIsSpecialRate() {
        return isSpecialRate;
    }

    public void setIsSpecialRate(String isSpecialRate) {
        this.isSpecialRate = isSpecialRate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
