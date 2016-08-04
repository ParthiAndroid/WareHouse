package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("LoggedKey")
    private String loggedKey;

    @SerializedName("Message")
    private String Message;

    @SerializedName("Success")
    private boolean isSuccess;

    @SerializedName("UserId")
    private String UserId;

    public String getUserId() {
        return UserId;
    }

    public String getLoggedKey() {
        return loggedKey;
    }

    public void setLoggedKey(String loggedKey) {
        this.loggedKey = loggedKey;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        isSuccess = isSuccess;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }


}
