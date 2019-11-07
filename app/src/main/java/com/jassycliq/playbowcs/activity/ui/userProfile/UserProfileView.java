package com.jassycliq.playbowcs.activity.ui.userProfile;

import com.jassycliq.playbowcs.model.OwnershipModel;

/**
 * Class exposing authenticated user details to the UI.
 */
public class UserProfileView {
    private static OwnershipModel.UserProfile userProfile;
    //... other data fields that may be accessible to the UI

    public UserProfileView(OwnershipModel.UserProfile userProfile) {
        UserProfileView.userProfile = userProfile;
    }

    public static OwnershipModel.UserProfile getDatabean() {
        return userProfile;
    }
}
