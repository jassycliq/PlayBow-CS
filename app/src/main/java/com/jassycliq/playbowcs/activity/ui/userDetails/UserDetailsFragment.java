package com.jassycliq.playbowcs.activity.ui.userDetails;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;
import com.jassycliq.playbowcs.databinding.FragmentUserDetailsBinding;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserDetailsFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private UserDetailsViewModel userDetailsViewModel;
    private FragmentUserDetailsBinding mBinding;
    private OwnershipModel.UserProfile userProfile;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_details, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        userDetailsViewModel = ViewModelProviders.of(this).get(UserDetailsViewModel.class);
        userProfile = sharedViewModel.getSelected().getValue();
        if (userProfile != null) {
            userDetailsViewModel.setCurrentUsername(userProfile.getUsername());
            userDetailsViewModel.setCurrentUserStatus(userProfile.getUserStatus());
        }
        mBinding.setModel(userProfile);

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
                userDetailsViewModel.userDataChanged(
                        Objects.requireNonNull(mBinding.firstNameEditText.getText()).toString(),
                        Objects.requireNonNull(mBinding.lastNameEditText.getText()).toString(),
//                        Objects.requireNonNull(mBinding.editTextTextEmailAddress.getText()).toString(),
                        mBinding.newPassword.getText().toString(),
                        mBinding.newPasswordValidation.getText().toString(),
                        mBinding.editTextTextPostalAddress.getText().toString(),
                        mBinding.accountBalanceEditTextNumberDecimal.getText().toString());
            }
        };

        mBinding.firstNameEditText.addTextChangedListener(afterTextChangedListener);
        mBinding.lastNameEditText.addTextChangedListener(afterTextChangedListener);
//        mBinding.editTextTextEmailAddress.addTextChangedListener(afterTextChangedListener);
        mBinding.newPassword.addTextChangedListener(afterTextChangedListener);
        mBinding.newPasswordValidation.addTextChangedListener(afterTextChangedListener);
        mBinding.editTextTextPostalAddress.addTextChangedListener(afterTextChangedListener);
        mBinding.accountBalanceEditTextNumberDecimal.addTextChangedListener(afterTextChangedListener);

        userDetailsViewModel.getUserDetailsFormState().observe(requireActivity(),  userDetailsFormState -> {
            if (userDetailsFormState == null) {
                return;
            }
            mBinding.floatingActionButton.setEnabled(userDetailsFormState.isDataValid());
            if (userDetailsFormState.getFirstNameError() != null) {
                 mBinding.firstNameEditTextLayout.setError(getString(userDetailsFormState.getFirstNameError()));
            } else {
                mBinding.firstNameEditTextLayout.setError(null);
            }
            if (userDetailsFormState.getLastNameError() != null) {
                mBinding.lastNameEditTextLayout.setError(getString(userDetailsFormState.getLastNameError()));
            } else {
                mBinding.lastNameEditTextLayout.setError(null);
            }
//            if (userDetailsFormState.getUsernameError() != null) {
//                mBinding.editTextTextEmailAddress.setError(getString(userDetailsFormState.getUsernameError()));
//            } else {
//                mBinding.editTextTextEmailAddress.setError(null);
//            }
            if (userDetailsFormState.getPasswordError() != null) {
                mBinding.newPasswordValidationInputLayout.setError(getString(userDetailsFormState.getPasswordError()));
            } else {
                mBinding.newPasswordValidationInputLayout.setError(null);
            }
            if (userDetailsFormState.getPostalAddressError() != null) {
                mBinding.editTextTextPostalAddress.setError(getString(userDetailsFormState.getPostalAddressError()));
            } else {
                mBinding.editTextTextPostalAddress.setError(null);
            }
            if (userDetailsFormState.getAccountBalanceError() != null) {
                mBinding.accountBalanceEditTextNumberDecimal.setError(getString(userDetailsFormState.getAccountBalanceError()));
            } else {
                mBinding.accountBalanceEditTextNumberDecimal.setError(null);
            }
        });

        mBinding.floatingActionButton.setOnClickListener(v -> {
            String chipState = null;
            String firstName = Objects.requireNonNull(mBinding.firstNameEditText.getText()).toString();
            String lastName = Objects.requireNonNull(mBinding.lastNameEditText.getText()).toString();
//            String userName = Objects.requireNonNull(mBinding.editTextTextEmailAddress.getText()).toString();
            String passWord = mBinding.newPasswordValidation.getText().toString();
            String postalAddress = mBinding.editTextTextPostalAddress.getText().toString();
            String accountBalanceAdjustment = mBinding.accountBalanceEditTextNumberDecimal.getText().toString();
            if (mBinding.chip2.isChecked()) {
                chipState = "False";
            }
            if (mBinding.chip4.isChecked()) {
                chipState = "True";
            }
            userDetailsViewModel.setUserInfo(firstName, lastName, passWord, chipState, postalAddress, accountBalanceAdjustment);
            requireActivity().getSupportFragmentManager().popBackStack();
        });
    }
}