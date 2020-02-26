package com.jassycliq.playbowcs.activity.ui.settingsDashboard

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.jassycliq.playbowcs.R
import com.jassycliq.playbowcs.databinding.ActivitySettingsDashboardBinding

class SettingsDashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val settingsDashboardViewModel : SettingDashboardViewModel by viewModels()
        val binding : ActivitySettingsDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_settings_dashboard)
        binding.lifecycleOwner = this

        settingsDashboardViewModel.getSettingsDashboard()

        // Create the observer which updates the UI.
        val settingsDashboardObserver = Observer<SettingsDashboardResult> { newSettings ->
            // Update the UI, in this case, a TextView.
            if (newSettings.settingsDashboardResponse != null) {
                binding.dashboardModel = newSettings.settingsDashboardResponse
            }

            if (newSettings.failure != null) {
                Toast.makeText(this, newSettings.failure!!.message.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        settingsDashboardViewModel.settingsDashboardResult.observe(this, settingsDashboardObserver)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu!!.clear()
        super.onCreateOptionsMenu(menu)
        return true
    }
}