package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {


    @SerializedName("AuthKey")
    private String authKey;
    @SerializedName("Message")
    private String Message;

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    @SerializedName("Success")
    private boolean Success;


}