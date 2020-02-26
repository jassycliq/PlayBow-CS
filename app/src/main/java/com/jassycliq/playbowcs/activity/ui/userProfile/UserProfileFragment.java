package com.jassycliq.playbowcs.activity.ui.userProfile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;
import com.jassycliq.playbowcs.adapter.UserProfilePagerAdapter;
import com.jassycliq.playbowcs.databinding.FragmentUserProfileBinding;

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

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        userProfile = sharedViewModel.getSelected().getValue();
        if (userProfile != null && userProfile.getDogOwnership().getDogs().size() != 0) {
            StringBuilder dogNames = new StringBuilder();

            for (int i = 0; i < userProfile.getDogOwnership().getDogs().size(); i++) {
                if (i > 0) {
                    dogNames.append(", ");
                }
                dogNames.append(userProfile.getDogOwnership().getDogs().get(i).getDogName());
            }

            requireActivity().setTitle(dogNames + " (" + userProfile.getUserFirstName() + " " + userProfile.getUserLastName() + ")");
        }
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
        mViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        UserProfilePagerAdapter userProfilePagerAdapter = new UserProfilePagerAdapter(requireContext(), this.getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(userProfilePagerAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        mBinding.setModel(userProfile);

        // TODO: Eventually transition to a single FAB for both fragments instead of a FAB for each fragment
//        mBinding.floatingActionButton3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (viewPager.getCurrentItem()) {
//                    case 0:
//
//                }
//            }
//        });
    }

    @Override
    public void onPause() {
        requireActivity().setTitle(R.string.app_name);
        super.onPause();
    }
}
