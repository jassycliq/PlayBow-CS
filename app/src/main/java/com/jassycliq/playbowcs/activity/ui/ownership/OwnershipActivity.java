package com.jassycliq.playbowcs.activity.ui.ownership;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;
import com.jassycliq.playbowcs.activity.ui.userProfile.UserProfileFragment;
import com.jassycliq.playbowcs.utils.StartActivityInterface;

import static com.jassycliq.playbowcs.utils.Constants.DATABEAN;
import static com.jassycliq.playbowcs.utils.Constants.FIRST_RUN;
import static com.jassycliq.playbowcs.utils.Constants.SHARED_PREF;

public class OwnershipActivity extends AppCompatActivity implements StartActivityInterface {
    SharedPreferences sharedPref;
    static UserProfileFragment userProfileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userProfileFragment = new UserProfileFragment();

        sharedPref = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);

        final SharedViewModel sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
        setContentView(R.layout.activity_ownership);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, OwnershipFragment.newInstance(), "root")
                    .commit();
        }

        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++)
                            System.out.println(getSupportFragmentManager().getBackStackEntryAt(i).getName());
                    }
                });
    }

    @Override
    public void onBackPressed(){
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("OwnershipActivity", "popping backstack");
            fm.popBackStack();
        } else {
            Log.i("OwnershipActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

    @Override
    public void startMyIntent(Intent i) {
        SharedPreferences.Editor prefsEditor = sharedPref.edit();
        prefsEditor.putString(DATABEAN, null);
        prefsEditor.putBoolean(FIRST_RUN, true);
        prefsEditor.apply();

        startActivity(i);
        finish();
    }

    @Override
    public void startMyFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, userProfileFragment)
                .addToBackStack("UserProfile")
                .commit();
    }
}

