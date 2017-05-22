package com.ablack13.nimbussdk.net;

import com.ablack13.nimbussdk.net.entities.request.UserAuthRequest;
import com.ablack13.nimbussdk.net.entities.response.UserAuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ablack13 on 22.05.17.
 */

public interface NimbusApi {
    @POST("/")
    Call<UserAuthResponse> authorize(@Body UserAuthRequest request);
}
