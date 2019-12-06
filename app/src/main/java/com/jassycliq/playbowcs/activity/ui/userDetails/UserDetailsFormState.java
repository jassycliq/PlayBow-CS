package com.jassycliq.playbowcs.activity.ui.userDetails;

import androidx.annotation.Nullable;

class UserDetailsFormState {
    @Nullable
    private Integer firstNameError;
    @Nullable
    private Integer lastNameError;
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer postalAddressError;
    @Nullable
    private Integer accountBalanceError;
    private boolean isDataValid;

    UserDetailsFormState(@Nullable Integer firstNameError, @Nullable Integer lastNameError,
                         @Nullable Integer usernameError, @Nullable Integer passwordError,
                         @Nullable Integer postalAddressError, @Nullable Integer accountBalanceError) {
        this.firstNameError = firstNameError;
        this.lastNameError = lastNameError;
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.postalAddressError = postalAddressError;
        this.accountBalanceError = accountBalanceError;
        this.isDataValid = false;
    }

    UserDetailsFormState(boolean isDataValid) {
        this.firstNameError = null;
        this.lastNameError = null;
        this.usernameError = null;
        this.passwordError = null;
        this.postalAddressError = null;
        this.accountBalanceError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getFirstNameError() {
        return firstNameError;
    }

    @Nullable
    Integer getLastNameError() {
        return lastNameError;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    Integer getPostalAddressError() {
        return postalAddressError;
    }

    @Nullable
    Integer getAccountBalanceError() {
        return accountBalanceError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}
