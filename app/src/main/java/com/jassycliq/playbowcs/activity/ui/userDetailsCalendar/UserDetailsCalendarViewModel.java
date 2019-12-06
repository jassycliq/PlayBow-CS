package com.jassycliq.playbowcs.activity.ui.userDetailsCalendar;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jassycliq.playbowcs.activity.data.model.BookingData;
import com.jassycliq.playbowcs.activity.data.model.BookingResponse;
import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.activity.ui.login.LoggedInUserView;
import com.jassycliq.playbowcs.activity.ui.userProfile.UserProfileView;
import com.jassycliq.playbowcs.network.RetrofitCallback;
import com.jassycliq.playbowcs.network.RetrofitClientInstance;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.threeten.bp.LocalDate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;

public class UserDetailsCalendarViewModel extends ViewModel {
    private OwnershipModel.UserProfile wanteUserProfile = UserProfileView.getDatabean();
    private LoggedInUser.DataBean loggedInUser = LoggedInUserView.getDatabean();

    private final MutableLiveData<Set<CalendarDay>> chosenDates = new MutableLiveData<>();

    LiveData<Set<CalendarDay>> getChosenDates() {
        return chosenDates;
    }

    private void select(Set<CalendarDay> calendarDay) {
        chosenDates.setValue(calendarDay);
    }

    void getBookedDates() {
        if (wanteUserProfile != null) {
            Set<CalendarDay> bookedDates = new ArraySet<>();
            int id = loggedInUser.getUser_id();
            String tokenString = "Token " + loggedInUser.getAuth_token();
            Map<String, String> data = new HashMap<>();
            String userID = wanteUserProfile.getUserID();
            data.put("user_id", userID);

            final Call<BookingResponse> responseCall = RetrofitClientInstance.getInstance().getApiInterface().getUserBookedDates(id, tokenString, data);
            responseCall.enqueue(new RetrofitCallback<BookingResponse>() {
                @Override
                public void onSuccess(BookingResponse bookingResponse) {
                    if (bookingResponse.getSuccess() == 1) {
                        for (int i = 0; i < bookingResponse.getData().getUserProfile().get(0).getBookedDates().size(); i++) {
                            BookingData bookedDate = bookingResponse.getData().getUserProfile().get(0).getBookedDates().get(i);
                            String bookingDate = bookedDate.getBookingDate();
                            LocalDate date = LocalDate.parse(bookingDate);
                            CalendarDay calendarDay = CalendarDay.from(date);
                            bookedDates.add(calendarDay);
                        }
                        select(bookedDates);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<BookingResponse> call, @NonNull Throwable error) {
                    error.printStackTrace();
                    UserDetailsCalendarResult result = new UserDetailsCalendarResult(error);
                }
            });
        }
    }
}
