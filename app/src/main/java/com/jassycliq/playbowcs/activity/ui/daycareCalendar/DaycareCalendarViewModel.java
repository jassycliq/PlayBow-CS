package com.jassycliq.playbowcs.activity.ui.daycareCalendar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jassycliq.playbowcs.activity.data.model.DaycareCalendarDogProfile;
import com.jassycliq.playbowcs.activity.data.model.DaycareCalendarResponse;
import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.activity.ui.login.LoggedInUserView;
import com.jassycliq.playbowcs.adapter.DaycareCalendarAdapter;
import com.jassycliq.playbowcs.network.RetrofitCallback;
import com.jassycliq.playbowcs.network.RetrofitClientInstance;
import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class DaycareCalendarViewModel extends AndroidViewModel {

    public DaycareCalendarViewModel(@NonNull Application application) {
        super(application);
    }

    private LoggedInUser.DataBean loggedInUser = LoggedInUserView.getDatabean();

    private MutableLiveData<DaycareCalendarResult> daycareCalendarResult = new MutableLiveData<DaycareCalendarResult>();
    LiveData<DaycareCalendarResult> getCalendarResponse() {
        return daycareCalendarResult;
    }

    private MutableLiveData<List<DaycareCalendarDogProfile>> dogProfileList = new MutableLiveData<List<DaycareCalendarDogProfile>>();
    LiveData<List<DaycareCalendarDogProfile>> getDogProfileList() {
        return dogProfileList;
    }

    private DaycareCalendarAdapter mAdapter = new DaycareCalendarAdapter(getApplication().getApplicationContext(), ALPHABETICAL_COMPARATOR);
    private static final Comparator<DaycareCalendarDogProfile> ALPHABETICAL_COMPARATOR = (a, b) -> a.getId().compareTo(b.getId());

    DaycareCalendarAdapter getmAdapter() {
        return mAdapter;
    }

    void getDogsAttending(CalendarDay calendarDay) {
        int id = loggedInUser.getUser_id();
        String tokenString = "Token " + loggedInUser.getAuth_token();
        Map<String, String> data = new HashMap<>();
        data.put("date", calendarDay.getDate().toString());

        final Call<DaycareCalendarResponse> responseCall = RetrofitClientInstance.getInstance().getApiInterface().getDaycareAttendance(id, tokenString, data);
        responseCall.enqueue(new RetrofitCallback<DaycareCalendarResponse>() {
            @Override
            public void onSuccess(DaycareCalendarResponse daycareResponse) {
                daycareCalendarResult.setValue(new DaycareCalendarResult(daycareResponse));
                List<DaycareCalendarDogProfile> dogList = daycareResponse.getData().getDogProfile();
                dogProfileList.setValue(dogList);
                mAdapter.replaceAll(dogList);
            }

            @Override
            public void onFailure(@NonNull Call<DaycareCalendarResponse> call, @NonNull Throwable error) {
                daycareCalendarResult.setValue(new DaycareCalendarResult(error));
                error.printStackTrace();
            }
        });
    }
}
