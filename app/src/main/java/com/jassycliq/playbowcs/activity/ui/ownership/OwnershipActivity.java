package com.jassycliq.playbowcs.activity.ui.ownership;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;

import static com.jassycliq.playbowcs.utils.Constants.SHARED_PREF;

public class OwnershipActivity extends AppCompatActivity {
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPref = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);

        final SharedViewModel sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
        setContentView(R.layout.activity_ownership);
    }
}

