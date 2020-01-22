package com.jassycliq.playbowcs.activity.data.model;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.chip.ChipGroup;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class OwnershipModel {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {

        @SerializedName("user_profile")
        @Expose
        private List<UserProfile> userProfile = null;

        public List<UserProfile> getUserProfile() {
            return userProfile;
        }

        public void setUserProfile(List<UserProfile> userProfile) {
            this.userProfile = userProfile;
        }

    }

    public static class UserProfile extends BaseObservable{

        @SerializedName("userID")
        @Expose
        private String userID;
        @SerializedName("userFirstName")
        @Expose
        private String userFirstName;
        @SerializedName("userLastName")
        @Expose
        private String userLastName;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("user_status")
        @Expose
        private String userStatus;
        @SerializedName("user_address")
        @Expose
        private String userAddress;
        @SerializedName("ewallet_balance")
        @Expose
        private String ewalletBalance;
        @SerializedName("dog_ownership")
        @Expose
        private DogOwnership dogOwnership;
        @SerializedName("booked_dates")
        @Expose
        private List<BookingData> bookedDates = null;

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getUserFirstName() {
            return userFirstName;
        }

        public void setUserFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
        }

        public String getUserLastName() {
            return userLastName;
        }

        public void setUserLastName(String userLastName) {
            this.userLastName = userLastName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(String userStatus) {
            this.userStatus = userStatus;
        }

        public String getUserAddress() {
            return userAddress;
        }

        public void setUserAddress(String userAddress) {
            this.userAddress = userAddress;
        }

        public String getEwalletBalance() {
            return ewalletBalance;
        }

        public void setEwalletBalance(String ewalletBalance) {
            this.ewalletBalance = ewalletBalance;
        }

        public DogOwnership getDogOwnership() {
            return dogOwnership;
        }

        public void setDogOwnership(DogOwnership dogOwnership) {
            this.dogOwnership = dogOwnership;
        }

        public List<BookingData> getBookedDates() {
            return bookedDates;
        }

        public void setBookedDates(List<BookingData> bookedDates) {
            this.bookedDates = bookedDates;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserProfile that = (UserProfile) o;
            return userID.equals(that.userID) &&
                    Objects.equals(userFirstName, that.userFirstName) &&
                    Objects.equals(userLastName, that.userLastName) &&
                    username.equals(that.username) &&
                    userStatus.equals(that.userStatus) &&
                    Objects.equals(userAddress, that.userAddress) &&
                    Objects.equals(ewalletBalance, that.ewalletBalance);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userID, userFirstName, userLastName, username, userStatus, userAddress, ewalletBalance);
        }

        public static class DogOwnership extends BaseObservable {

            @SerializedName("dogs")
            @Expose
            private List<Dog> dogs = null;

            public List<Dog> getDogs() {
                return dogs;
            }

            public void setDogs(List<Dog> dogs) {
                this.dogs = dogs;
            }

            public static class Dog {

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

                public String getDogPhoto() {
                    return dogPhoto;
                }

            }
        }
    }

    @BindingAdapter("imgUrl")
    public static void setDogPhoto(ImageView view, String dogPhoto) {
        GlideApp.with(view.getContext())
                .load(dogPhoto)
                .apply(new RequestOptions().circleCrop())
//                .thumbnail(0.1f)
                .transition(withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }

    @BindingAdapter("dogNameText")
    public static void setDogName(TextView view, OwnershipModel.UserProfile userProfile) {
        if (!userProfile.dogOwnership.getDogs().isEmpty()) {
            StringBuilder dogNames = new StringBuilder();
            ArrayList<UserProfile.DogOwnership.Dog> dogs = new ArrayList<>(userProfile.dogOwnership.getDogs());
            for (UserProfile.DogOwnership.Dog dog : dogs) {
                if (dog != dogs.get(0)) {
                    dogNames.append(", ");
                }
                dogNames.append(dog.getDogName());
            }
            view.setText(dogNames.toString());
        } else {
            view.setText(R.string.no_dog);
        }
    }

    @BindingAdapter("balanceText")
    public static void setBalanceText(TextView view, OwnershipModel.UserProfile userProfile) {
        String modifiedBalance = "$ " + userProfile.getEwalletBalance();
        view.setText(modifiedBalance);
    }

    @BindingAdapter("balanceHint")
    public static void setBalanceHint(TextView view, OwnershipModel.UserProfile userProfile) {
        String modifiedBalance = "$ " + userProfile.getEwalletBalance();
        view.setHint(modifiedBalance);
    }

    @BindingAdapter("checkChips")
    public static void setCheckedChip(ChipGroup view, OwnershipModel.UserProfile userProfile) {
        boolean mBoolean = userProfile.userStatus.contains("True");
        if (mBoolean) {
            view.check(R.id.chip4);
        } else {
            view.check(R.id.chip2);
        }
    }
}
