package com.jassycliq.playbowcs.activity.ui.userDetailsFinancial;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.activity.data.model.UserTransactionHistory;
import com.jassycliq.playbowcs.activity.data.model.UserTransactionHistoryResponse;
import com.jassycliq.playbowcs.activity.ui.login.LoggedInUserView;
import com.jassycliq.playbowcs.activity.ui.userProfile.UserProfileView;
import com.jassycliq.playbowcs.adapter.UserDetailsFinancialHistoryAdapter;
import com.jassycliq.playbowcs.network.RetrofitCallback;
import com.jassycliq.playbowcs.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class UserDetailsFinancialViewModel extends AndroidViewModel {

    public UserDetailsFinancialViewModel(@NonNull Application application) {
        super(application);
    }

    private LoggedInUser.DataBean userDatabean = LoggedInUserView.getDatabean();
    private static final Comparator<UserTransactionHistory> ALPHABETICAL_COMPARATOR = (a, b) -> a.getUserId().compareTo(b.getUserId());
    private UserDetailsFinancialHistoryAdapter mAdapter = new UserDetailsFinancialHistoryAdapter(getApplication().getApplicationContext(), ALPHABETICAL_COMPARATOR);
    private List<UserTransactionHistory> mModels;
    private OwnershipModel.UserProfile wanteUserProfile = UserProfileView.getDatabean();


    private MutableLiveData<UserFinancialHistoryResult> userFinancialHistoryResult = new MutableLiveData<>();
    LiveData<UserFinancialHistoryResult> getFinancialHistoryResult() {
        return userFinancialHistoryResult;
    }

    private List<UserTransactionHistory> getmModels() {
        return mModels;
    }
    UserDetailsFinancialHistoryAdapter getAdapter() {
        return mAdapter;
    }

    void getUserDetailsFinancialHistory(SwipeRefreshLayout swipeContainer) {
        swipeContainer.setRefreshing(true);
        swipeContainer.setAlpha((float) 0.20);

        if (wanteUserProfile != null) {
            int id = userDatabean.getUser_id();
            String userID = wanteUserProfile.getUserID();
            String tokenString = "Token " + userDatabean.getAuth_token();
            Map<String, String> data = new HashMap<>();
            data.put("user_id", userID);

            final Call<UserTransactionHistoryResponse> responseCall = RetrofitClientInstance.getInstance().getApiInterface().getFinancialHistory(id, tokenString, data);
            responseCall.enqueue(new RetrofitCallback<UserTransactionHistoryResponse>() {
                @Override
                public void onSuccess(UserTransactionHistoryResponse response) {
                    if (response.getSuccess() == 0) {
                        // TODO : Handle call failure gracefully
                    } else if (response.getSuccess() == 1) {
                        if (response.getUserTransactionHistoryData().getUserTransactionHistory() != null) {
                            mModels = new ArrayList<>();
                            mModels.addAll(response.getUserTransactionHistoryData().getUserTransactionHistory());

                            mAdapter.replaceAll(mModels);
                        }
                    }
                    swipeContainer.setRefreshing(false);
                    swipeContainer.setAlpha(1);
                }

                @Override
                public void onFailure(@NonNull Call<UserTransactionHistoryResponse> call, @NonNull Throwable error) {
                    userFinancialHistoryResult.setValue(new UserFinancialHistoryResult(error));
                    error.printStackTrace();
                }
            });
        }
    }
}
