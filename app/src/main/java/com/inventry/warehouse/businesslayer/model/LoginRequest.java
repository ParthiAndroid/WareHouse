package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("userName")
    private String userName;
    @SerializedName("passWord")
    private String passWord;

    public LoginRequest(String userName, String passWord, String authKey) {
        this.userName = userName;
        this.passWord = passWord;
        this.authKey = authKey;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @SerializedName("authKey")
    private String authKey;
}
