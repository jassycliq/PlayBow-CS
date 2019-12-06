package com.jassycliq.playbowcs.activity.ui.userProfile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;
import com.jassycliq.playbowcs.adapter.SectionsPagerAdapter;
import com.jassycliq.playbowcs.databinding.FragmentUserProfileBinding;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;

import org.jetbrains.annotations.NotNull;

public class UserProfileFragment extends Fragment {

    private UserProfileViewModel mViewModel;
    private SharedViewModel sharedViewModel;
    private OwnershipModel.UserProfile userProfile;
    private FragmentUserProfileBinding mBinding;

    public static UserProfileFragment newInstance() {
        return new UserProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(requireContext(), this.getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        userProfile = sharedViewModel.getSelected().getValue();
        mBinding.setModel(userProfile);
    }
}
