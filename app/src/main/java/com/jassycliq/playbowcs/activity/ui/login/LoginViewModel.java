package com.jassycliq.playbowcs.activity.ui.login;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.network.RetrofitCallback;
import com.jassycliq.playbowcs.network.RetrofitClientInstance;

import org.jetbrains.annotations.NotNull;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
        RequestBody emailBody = RequestBody.create(username, MediaType.parse("text/plain"));
        RequestBody new_PasswordBody = RequestBody.create(password, MediaType.parse("text/plain"));
        RequestBody AndroidTokenBody = RequestBody.create("", MediaType.parse("multipart/form-data"));
        RequestBody IosTokenBody = RequestBody.create("", MediaType.parse("multipart/form-data"));
        final Call<LoggedInUser> responseCall = RetrofitClientInstance.getInstance().getApiInterface().getLogin(emailBody, new_PasswordBody,AndroidTokenBody,IosTokenBody);
        responseCall.enqueue(new RetrofitCallback<LoggedInUser>() {

            @Override
            public void onFailure(@NotNull Call<LoggedInUser> call, @NotNull Throwable t) {
                loginResult.setValue(new LoginResult(t));
            }

            @Override
            public void onSuccess(LoggedInUser response) {
                if (response.getSuccess() == 1) {
                    loginResult.setValue(new LoginResult(response));
                } else {
                    loginResult.setValue(new LoginResult(response));
                }
            }
        });
    }

    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}
