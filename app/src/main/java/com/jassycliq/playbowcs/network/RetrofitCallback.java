package com.jassycliq.playbowcs.network;

import android.util.Log;

import androidx.annotation.NonNull;

import okhttp3.internal.http2.Http2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.http.HTTP;

public abstract class RetrofitCallback<T> implements Callback<T> {

    public abstract void onSuccess(T arg0);

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        Log.e("retrofit callback: ", String.valueOf(response.isSuccessful()));
        Log.e("retrofit callback", String.valueOf(response.code()));
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            String message = "";
            if (response.code() == 500) {
                message = "Server error!";
            } else if (response.code() == 401){
                message = "Invalid email/password, please try again.";
            }
            Throwable errorMessage = new Throwable(message);
            onFailure(call, errorMessage);
        }
    }
}
