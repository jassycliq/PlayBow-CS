package com.jassycliq.playbowcs.activity.ui.settingsDashboard

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jassycliq.playbowcs.activity.data.model.SettingsDashboardResponse
import com.jassycliq.playbowcs.activity.ui.login.LoggedInUserView
import com.jassycliq.playbowcs.network.RetrofitCallback
import com.jassycliq.playbowcs.network.RetrofitClientInstance
import com.jassycliq.playbowcs.utils.ObservableViewModel
import retrofit2.Call
import java.util.*

class SettingDashboardViewModel : ObservableViewModel() {
    private val userDatabean = LoggedInUserView.getDatabean()
    private val id = userDatabean.user_id
    private val tokenString = "Token " + userDatabean.auth_token

    private var settingsDashboardValues: MutableMap<String, String>? = null

    private val settingsDashboardResultMutableLiveData = MutableLiveData<SettingsDashboardResult>()
    val settingsDashboardResult: LiveData<SettingsDashboardResult>
        get() = settingsDashboardResultMutableLiveData

    fun getSettingsDashboard() {
        if (settingsDashboardValues != null) {
            settingsDashboardValues!!.clear()
        } else {
            settingsDashboardValues = HashMap()
        }
        setSettingsDashboard(settingsDashboardValues)
    }

    fun setSettingsDashboard(mapValues: Map<String, String>?) {
        val responseCall = RetrofitClientInstance.getInstance().apiInterface.setSettingsDashboard(id, tokenString, mapValues)
        responseCall.enqueue(object : RetrofitCallback<SettingsDashboardResponse?>() {

            override fun onSuccess(arg0: SettingsDashboardResponse?) {
                settingsDashboardResultMutableLiveData.value = SettingsDashboardResult(arg0)
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<SettingsDashboardResponse?>, t: Throwable) {
                settingsDashboardResultMutableLiveData.value = SettingsDashboardResult(t)
            }
        })
    }
}