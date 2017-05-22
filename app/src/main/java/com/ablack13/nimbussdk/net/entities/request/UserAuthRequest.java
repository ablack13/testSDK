package com.ablack13.nimbussdk.net.entities.request;

/**
 * Created by ablack13 on 22.05.17.
 */

public class UserAuthRequest {
    private String action = "user:auth";
    private Body body;

    public UserAuthRequest(String login, String password) {
        body = new Body(login, password);
    }

    static class Body {
        String login;
        String password;

        public Body(String login, String password) {
            this.login = login;
            this.password = password;
        }
    }
}
