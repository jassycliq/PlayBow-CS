package com.jassycliq.playbowcs.activity.data.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class SettingsDashboardResponse (
    @SerializedName("data")
    var data: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("success")
    var success: Int
) {

    @Keep
    data class Data(
        @SerializedName("android_version")
        var androidVersion: String,
        @SerializedName("daily_refund_percentage")
        var dailyRefundPercentage: String,
        @SerializedName("ios_version")
        var iosVersion: String,
        @SerializedName("monthly_refund_percentage")
        var monthlyRefundPercentage: String,
        @SerializedName("unlimited_plus_price")
        var unlimitedPlusPrice: String,
        @SerializedName("unlimited_standard_price")
        var unlimitedStandardPrice: String
    )
}
