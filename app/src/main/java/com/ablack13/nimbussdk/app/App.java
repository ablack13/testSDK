package com.ablack13.nimbussdk.app;

import android.app.Application;

import com.ablack13.nimbussdk.net.ApiConst;
import com.ablack13.nimbussdk.net.NimbusApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ablack13 on 22.05.17.
 */

public class App extends Application {
    private static NimbusApi nimbusApi;

    @Override
    public void onCreate() {
        super.onCreate();

        initRestClient();
    }

    private static void initRestClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConst.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        nimbusApi = retrofit.create(NimbusApi.class);
    }

    public static NimbusApi getNimbusApi() {
        if (nimbusApi == null) {
            initRestClient();
        }
        return nimbusApi;
    }
}
