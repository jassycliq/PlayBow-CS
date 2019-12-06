package com.jassycliq.playbowcs.activity.ui.userDetails;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.activity.ui.login.LoggedInUserView;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.network.RetrofitCallback;
import com.jassycliq.playbowcs.network.RetrofitClientInstance;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;

public class UserDetailsViewModel extends ViewModel {
    private LoggedInUser.DataBean userDatabean = LoggedInUserView.getDatabean();
    private final MutableLiveData<UserDetailsFormState> userDetailsFormState = new MutableLiveData<>();

    private String getCurrentUsername() {
        return currentUsername;
    }

    void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    private String getCurrentUserStatus() {
        return currentUserStatus;
    }

    void setCurrentUserStatus(String currentUserStatus) {
        this.currentUserStatus = currentUserStatus;
    }

    private String currentUsername, currentUserStatus;

    LiveData<UserDetailsFormState> getUserDetailsFormState() {
        return userDetailsFormState;
    }

    void userDataChanged(
            @Nullable String firstNameString,
            @Nullable String lastNameString,
//            @Nullable String usernameString,
            @Nullable String newPasswordString,
            @Nullable String newPasswordValidationString,
            @Nullable String postalAddressString,
            @Nullable String accountBalanceAdjustmentString) {
        String errors = "";

        if (!isUserFirstNameValid(firstNameString)) {
            errors += "firstNameError";
            userDetailsFormState.setValue(new UserDetailsFormState(
                    R.string.invalid_first_name,
                    null,
                    null,
                    null,
                    null,
                    null));
        }
        if (!isUserLastNameValid(lastNameString)) {
            errors += "lastNameError";
            userDetailsFormState.setValue(new UserDetailsFormState(
                    null,
                    R.string.invalid_last_name,
                    null,
                    null,
                    null,
                    null));
        }
//        if (!isUsernameValid(usernameString)) {
//            errors += "userNameError";
//            userDetailsFormState.setValue(new UserDetailsFormState(
//                    null,
//                    null,
//                    R.string.invalid_username,
//                    null,
//                    null,
//                    null));
//        }
        if (!isNewPasswordValid(newPasswordString, newPasswordValidationString)) {
            errors += "passwordError";
            userDetailsFormState.setValue(new UserDetailsFormState(
                    null,
                    null,
                    null,
                    R.string.invalid_password,
                    null,
                    null));
        }
        if (!isPostalAddressValid(postalAddressString)) {
            errors += "postalAddressError";
            userDetailsFormState.setValue(new UserDetailsFormState(
                    null,
                    null,
                    null,
                    null,
                    R.string.invalid_postal_address,
                    null));
        }
        if (!isAccountBalanceAdjustmentValid(accountBalanceAdjustmentString)) {
            errors += "accountBalanceError";
            userDetailsFormState.setValue(new UserDetailsFormState(
                    null,
                    null,
                    null,
                    null,
                    null,
                    R.string.invalid_account_adjustment));
        }
        if (errors.isEmpty()) {
            userDetailsFormState.setValue(new UserDetailsFormState(true));
        }
    }

    private boolean isUserFirstNameValid(String userFirstNameString) {
        if (userFirstNameString != null) {
            if (userFirstNameString.length() > 2) {
                return true;
            } else {
                return userFirstNameString.length() == 0;
            }
        } else return true;
    }

    private boolean isUserLastNameValid(String userLastNameString) {
        if (userLastNameString != null) {
            if (userLastNameString.length() > 2) {
                return true;
            } else {
                return userLastNameString.length() == 0;
            }
        } else return true;
    }

//    private boolean isUsernameValid(String usernameString) {
//        if (usernameString != null) {
//            if (usernameString.length() > 2) {
//                if (usernameString.contains("@")) {
//                    return Patterns.EMAIL_ADDRESS.matcher(usernameString).matches();
//                } else {
//                    return true;
//                }
//            } else {
//                return usernameString.length() == 0;
//            }
//        } else return true;
//    }

    private boolean isNewPasswordValid(String newPasswordString, String newPasswordValidationString) {
        if (newPasswordString != null && newPasswordValidationString != null) {
            if (newPasswordString.length() > 5 && newPasswordValidationString.length() > 5 && newPasswordString.equals(newPasswordValidationString)) {
                return true;
            } else {
                return newPasswordString.length() == 0 || newPasswordValidationString.length() == 0;
            }
        } else return true;
    }

    private boolean isPostalAddressValid(String userPostalAddressString) {
        if (userPostalAddressString != null) {
            if (userPostalAddressString.length() > 9) {
                return true;
            } else {
                return userPostalAddressString.length() == 0;
            }
        } else return true;
    }

    private boolean isAccountBalanceAdjustmentValid(String accountBalanceAdjustmentString) {
        if (accountBalanceAdjustmentString != null) {
            if (accountBalanceAdjustmentString.length() > 1) {
                return true;
            } else {
                return accountBalanceAdjustmentString.length() == 0;
            }
        } else {
            return true;
        }
    }

    void setUserInfo(String firstName, String lastName, String passWord, String chipState, String postalAddress, String accountBalanceAdjustment) {
        Map<String, String> data = new HashMap<>();
        if (firstName.length() != 0) {
            data.put("first_name", firstName);
        }
        if (lastName.length() != 0) {
            data.put("last_name", lastName);
        }
//        if (email.length() != 0) {
//            data.put("email", email);
//        }
        if (passWord.length() != 0) {
            data.put("password", passWord);
        }
        if (chipState.length() != 0 && !chipState.equals(Objects.requireNonNull(getCurrentUserStatus()))) {
            data.put("user_status", chipState);
        }
        if (postalAddress.length() != 0) {
            data.put("postal_address", postalAddress);
        }
        if (accountBalanceAdjustment.length() != 0) {
            data.put("account_balance_adjustment", accountBalanceAdjustment);
        }
        if (data.size() != 0) {
            data.put("current_username", Objects.requireNonNull(getCurrentUsername()));
            setUserInfoNetworkCall(data);
        }
    }

    private void setUserInfoNetworkCall(Map<String, String> data) {
        int id = userDatabean.getUser_id();
        String tokenString = "Token " + userDatabean.getAuth_token();
        final Call<OwnershipModel> responseCall = RetrofitClientInstance.getInstance().getApiInterface().updateUser(id, tokenString, data);
        responseCall.enqueue(new RetrofitCallback<OwnershipModel>() {
            @Override
            public void onSuccess(OwnershipModel ownershipModel) {
                if (ownershipModel.getSuccess() == 0) {
                    // TODO : Handle call failure gracefully
                } else if (ownershipModel.getSuccess() == 1) {

                }

            }

            @Override
            public void onFailure(@NonNull Call<OwnershipModel> call, @NonNull Throwable error) {
                error.printStackTrace();
            }
        });
    }
}
