package com.jassycliq.playbowcs.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.ui.daycareCalendar.DaycareCalendarFragment;
import com.jassycliq.playbowcs.activity.ui.ownership.OwnershipFragment;

import org.jetbrains.annotations.NotNull;

public class HomePageAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.home_tab_text_1, R.string.home_tab_text_2};
    private final Context mContext;

    public HomePageAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        switch (position) {
            case 0:
                return new OwnershipFragment();
            case 1:
                return new DaycareCalendarFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}
