package com.easyhome.jrconsumer.mvp.model.entity;


public class LoginInfo {

    private String token;
    private String id_2290;

    public String getToken() {
        if (null == token) {
            return "";
        }
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId_2290() {
        return id_2290;
    }

    public void setId_2290(String id_2290) {
        this.id_2290 = id_2290;
    }
}
