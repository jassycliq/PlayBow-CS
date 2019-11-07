package com.jassycliq.playbowcs.network;

import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitCallback<T> implements Callback<T> {

    public abstract void onSuccess(T arg0);

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        Log.e("retrofit callback: ", String.valueOf(response.isSuccessful()));
        Log.e("retrofit callback", String.valueOf(response.code()));
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            String message = "Invalid email/password, please try again.";
            Throwable errorMessage = new Throwable(message);
            onFailure(call, errorMessage);
        }
    }
}
