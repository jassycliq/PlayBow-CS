package com.jassycliq.playbowcs.activity.ui.ownership;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.activity.ui.login.LoggedInUserView;
import com.jassycliq.playbowcs.adapter.OwnershipAdapter;
import com.jassycliq.playbowcs.model.OwnershipModel;
import com.jassycliq.playbowcs.network.RetrofitCallback;
import com.jassycliq.playbowcs.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;

public class OwnershipViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private LoggedInUser.DataBean userDatabean = LoggedInUserView.getDatabean();
    private OwnershipAdapter mAdapter = new OwnershipAdapter(getApplication().getApplicationContext(), ALPHABETICAL_COMPARATOR);;
    private List<OwnershipModel.UserProfile> mModels;

    private static final Comparator<OwnershipModel.UserProfile> ALPHABETICAL_COMPARATOR = (a, b) -> a.getUserID().compareTo(b.getUserID());

    public OwnershipViewModel(@NonNull Application application) {
        super(application);
    }

    void getUsers(SwipeRefreshLayout swipeContainer) {
        int id = userDatabean.getUser_id();
        String tokenString = "Token " + userDatabean.getAuth_token();
        final Call<OwnershipModel> responseCall = RetrofitClientInstance.getInstance().getApiInterface().getUsers(id, tokenString);
        responseCall.enqueue(new RetrofitCallback<OwnershipModel>() {
            @Override
            public void onSuccess(OwnershipModel ownershipModel) {
                if (ownershipModel.getSuccess() == 0) {
                    // TODO : Handle call failure gracefully
                } else if (ownershipModel.getSuccess() == 1) {
                    if (ownershipModel.getData().getUserProfile() != null) {
                        mModels = new ArrayList<>();
                        mModels.addAll(ownershipModel.getData().getUserProfile());

                        mAdapter.add(mModels);
                    }
                }
                swipeContainer.setRefreshing(false);
                swipeContainer.setAlpha(1);
            }

            @Override
            public void onFailure(@NonNull Call<OwnershipModel> call, @NonNull Throwable error) {
                error.printStackTrace();
            }
        });
    }

    private static List<OwnershipModel.UserProfile> filter(List<OwnershipModel.UserProfile> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<OwnershipModel.UserProfile> filteredModelList = new ArrayList<>();
        for (OwnershipModel.UserProfile model : models) {
            final String userEmail = model.getUsername().toLowerCase();
            final String userFirstName = model.getUserFirstName().toLowerCase();
            final String userLastName = model.getUserLastName().toLowerCase();
            final String userFullName = userFirstName + " " + userLastName;

            if (!model.getDogOwnership().getDogs().isEmpty()) {
                for (OwnershipModel.UserProfile.DogOwnership.Dog dog : model.getDogOwnership().getDogs()) {
                    final String dogName = dog.getDogName().toLowerCase();

                    if (dogName.contains(lowerCaseQuery)) {
                        filteredModelList.add(model);
                    }
                }
            }

            if (userEmail.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
            if (userFirstName.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
            if (userLastName.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
            if(userFullName.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    void searchItem(String query) {
        final List<OwnershipModel.UserProfile> filteredModelList = OwnershipViewModel.filter(getmModels(), query);
        getAdapter().replaceAll(filteredModelList);
    }
    OwnershipAdapter getAdapter() {
        return mAdapter;
    }

    private List<OwnershipModel.UserProfile> getmModels() {
        return mModels;
    }
}
