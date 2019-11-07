package com.jassycliq.playbowcs.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jassycliq.playbowcs.BuildConfig;
import com.jassycliq.playbowcs.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static RetrofitClientInstance instance;
    private ApiEndpointInterface apiInterface;

    public RetrofitClientInstance() {
        instance = this;


        final Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ItemTypeAdapterFactory()).setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'").create();

        final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(10, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(10, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(interceptor);
        }

        okHttpClientBuilder.addNetworkInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .build();

                return chain.proceed(request);
            }
        });

        final Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.baseUrl(Constants.BASE_API_URL);

        retrofitBuilder.client(okHttpClientBuilder.build());
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create(gson));

        final Retrofit retrofit = retrofitBuilder.build();
        apiInterface = retrofit.create(ApiEndpointInterface.class);
    }

    public static RetrofitClientInstance getInstance() {
        return instance;
    }

    public ApiEndpointInterface getApiInterface() {
        return apiInterface;
    }
}
