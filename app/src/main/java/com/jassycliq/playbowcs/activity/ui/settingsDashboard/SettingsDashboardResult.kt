package com.jassycliq.playbowcs.activity.ui.settingsDashboard

import com.jassycliq.playbowcs.activity.data.model.SettingsDashboardResponse

class SettingsDashboardResult {
    var failure: Throwable? = null
        private set
    @JvmField
    var settingsDashboardResponse: SettingsDashboardResponse? = null

    internal constructor(failure: Throwable?) {
        this.failure = failure
    }

    internal constructor(settingsDashboardResponse: SettingsDashboardResponse?) {
        this.settingsDashboardResponse = settingsDashboardResponse
    }

}