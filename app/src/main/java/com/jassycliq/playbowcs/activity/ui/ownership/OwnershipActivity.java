package com.jassycliq.playbowcs.activity.ui.ownership;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;
import com.jassycliq.playbowcs.activity.ui.settingsDashboard.SettingsDashboard;

import org.jetbrains.annotations.NotNull;

import static com.jassycliq.playbowcs.utils.Constants.SHARED_PREF;

public class OwnershipActivity extends AppCompatActivity {
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPref = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);

        final SharedViewModel sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        setContentView(R.layout.activity_ownership);

        NavController navController = Navigation.findNavController(this, R.id.container);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationUI.setupWithNavController(toolbar, navController);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.navigation, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if (item.getItemId() == R.id.settingsDashboard) {
//            Navigation.findNavController(this, R.id.container).navigate(R.id.action_homeFragment_to_settingsDashboard);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
//        NavController navController = Navigation.findNavController(this, R.id.container);
//        return NavigationUI.onNavDestinationSelected(item, navController)
//                || super.onOptionsItemSelected(item);
//    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        menuItem.isVisible() = false;
//    }
}

