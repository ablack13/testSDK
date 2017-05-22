package com.ablack13.nimbussdk;

import com.ablack13.nimbussdk.app.App;
import com.ablack13.nimbussdk.net.entities.request.UserAuthRequest;
import com.ablack13.nimbussdk.net.entities.response.UserAuthResponse;

import org.junit.Test;

import retrofit2.Response;

/**
 * Created by ablack13 on 22.05.17.
 */

public class ApiTest {
    String login = "";
    String password = "";

    @Test
    public void authorize() throws Exception {
        Response<UserAuthResponse> response = App.getNimbusApi()
                .authorize(new UserAuthRequest(login, password))
                .execute();
        String login = response.body().body.info.login;
        System.out.print("login::" + login);
    }
}
