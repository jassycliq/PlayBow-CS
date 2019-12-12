package com.jassycliq.playbowcs.activity.ui.userDetailsCalendar;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jassycliq.playbowcs.activity.data.Result;
import com.jassycliq.playbowcs.activity.data.model.BookingData;
import com.jassycliq.playbowcs.activity.data.model.BookingResponse;
import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.activity.ui.login.LoggedInUserView;
import com.jassycliq.playbowcs.activity.ui.userProfile.UserProfileView;
import com.jassycliq.playbowcs.network.RetrofitCallback;
import com.jassycliq.playbowcs.network.RetrofitClientInstance;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import org.jetbrains.annotations.NotNull;
import org.threeten.bp.LocalDate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;

public class UserDetailsCalendarViewModel extends ViewModel {
    private OwnershipModel.UserProfile wanteUserProfile = UserProfileView.getDatabean();
    private LoggedInUser.DataBean loggedInUser = LoggedInUserView.getDatabean();

    private int id = loggedInUser.getUser_id();
    private String tokenString = "Token " + loggedInUser.getAuth_token();
    private Map<String, String> data = new HashMap<>();
    private String userID = wanteUserProfile.getUserID();

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
            data.put("user_id", userID);

            final Call<BookingResponse> responseCall = RetrofitClientInstance.getInstance().getApiInterface().getUserBookedDates(id, tokenString, data);
            responseCall.enqueue(new RetrofitCallback<BookingResponse>() {
                @Override
                public void onSuccess(BookingResponse response) {
                    if (response.getSuccess() == 1) {
                        for (int i = 0; i < response.getData().getUserProfile().get(0).getBookedDates().size(); i++) {
                            BookingData bookedDate = response.getData().getUserProfile().get(0).getBookedDates().get(i);
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

    public void updateCalendar(Set<CalendarDay> calendarDaySet, boolean isRemovingDates) {
        final Call<Result<BookingData>> calendarResponseCall;
        if (!isRemovingDates) {
            calendarResponseCall = RetrofitClientInstance.getInstance().getApiInterface().setAdminBookedDates(id, tokenString, data);
        } else {
            calendarResponseCall = RetrofitClientInstance.getInstance().getApiInterface().setAdminRemovedDates(id, tokenString, data);
        }
        calendarResponseCall.enqueue(new RetrofitCallback<Result<BookingData>>() {

            @Override
            public void onFailure(@NotNull Call<Result<BookingData>> call, @NotNull Throwable t) {

            }

            @Override
            public void onSuccess(Result<BookingData> calendarResponse) {

            }
        });
    }
}
