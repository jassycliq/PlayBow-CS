package com.jassycliq.playbowcs.activity.ui.userDetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.databinding.FragmentUserDetailsCalendarBinding;

public class UserDetailsCalendarFragment extends Fragment {

    private FragmentUserDetailsCalendarBinding mBinding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_details_calendar, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }
}
