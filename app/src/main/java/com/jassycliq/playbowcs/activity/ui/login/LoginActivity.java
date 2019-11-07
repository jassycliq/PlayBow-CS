package com.jassycliq.playbowcs.activity.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputLayout;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.data.model.LoggedInUser;
import com.jassycliq.playbowcs.activity.ui.ownership.OwnershipActivity;
import com.jassycliq.playbowcs.network.RetrofitClientInstance;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    public LoggedInUserView loggedInUserView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.RGBA_8888);
        setContentView(R.layout.activity_login);

        new RetrofitClientInstance();

        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final TextInputLayout usernameInputLayout = findViewById(R.id.username_layout);
        final EditText passwordEditText = findViewById(R.id.password);
        final TextInputLayout passwordInputLayout = findViewById(R.id.password_layout);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            loginButton.setEnabled(loginFormState.isDataValid());
            if (loginFormState.getUsernameError() != null) {
                usernameInputLayout.setError(getString(loginFormState.getUsernameError()));
            } else {
                usernameInputLayout.setError(null);
            }
            if (loginFormState.getPasswordError() != null) {
                passwordInputLayout.setError(getString(loginFormState.getPasswordError()));
            } else {
                passwordInputLayout.setError(null);
            }
        });

        loginViewModel.getLoginResult().observe(this, loginResult -> {
            if (loginResult == null) {
                return;
            }
            loadingProgressBar.setVisibility(View.GONE);

            if (loginResult.getSuccess() != null) {
                if (loginResult.getSuccess().getSuccess() == 1) {
                    updateUiWithUser(loginResult.getSuccess().getData());
                } else {
                    showLoginFailed(Objects.requireNonNull(loginResult.getFailure()).getMessage());
                }
            } else {
                if (loginResult.getFailure() != null) {
                    showLoginFailed(loginResult.getFailure().getMessage());
                }
            }
            setResult(Activity.RESULT_OK);
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
            return false;
        });

        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            loginViewModel.login(usernameEditText.getText().toString(),
                    passwordEditText.getText().toString());
        });
    }

    private void updateUiWithUser(LoggedInUser.DataBean model) {
        loggedInUserView = new LoggedInUserView(model);
        String welcome = getString(R.string.welcome) + " " + model.getFirstname() + " " + model.getLastname();
        Intent intent = new Intent(this, OwnershipActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
        finish();
    }

    private void showLoginFailed(String errorString) {
        String failed = getString(R.string.login_failed ) + errorString;
        Toast.makeText(getApplicationContext(), failed, Toast.LENGTH_SHORT).show();
    }
}
