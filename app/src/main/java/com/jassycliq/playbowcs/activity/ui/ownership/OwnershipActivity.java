package com.jassycliq.playbowcs.activity.ui.ownership;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jassycliq.playbowcs.R;

public class OwnershipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownership);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, OwnershipFragment.newInstance())
                    .commitNow();
        }
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
}
