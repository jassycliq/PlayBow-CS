package com.jassycliq.playbowcs.activity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.ui.userProfile.ZoomOutPageTransformer;
import com.jassycliq.playbowcs.adapter.HomePageAdapter;
import com.jassycliq.playbowcs.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HomePageAdapter homePageAdapter = new HomePageAdapter(requireContext(), this.getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.home_view_pager);
        viewPager.setAdapter(homePageAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        TabLayout tabs = view.findViewById(R.id.home_tabs);
        tabs.setupWithViewPager(viewPager);

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
}
