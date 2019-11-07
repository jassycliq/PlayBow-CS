package com.jassycliq.playbowcs.activity.ui.userDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.ui.ownership.SharedViewModel;
import com.jassycliq.playbowcs.databinding.FragmentUserDetailsBinding;
import com.jassycliq.playbowcs.model.OwnershipModel;

import org.jetbrains.annotations.NotNull;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserDetailsFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private FragmentUserDetailsBinding mBinding;
    private UserDetailsHandler handler = new UserDetailsHandler();

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
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);

        userProfile = sharedViewModel.getSelected().getValue();
        mBinding.setModel(userProfile);
        mBinding.setHandlers(handler);
    }

    public class UserDetailsHandler {

        public void setAdjustmentPositiveColor() {
            mBinding.accountBalanceEditTextNumberDecimal.setTextColor(getResources().getColor(R.color.colorHoloGreenLight, null));
        }

        public void setAdjustmentNegativeColor() {
            mBinding.accountBalanceEditTextNumberDecimal.setTextColor(getResources().getColor(R.color.colorHoloRedDark, null));
        }
    }
}