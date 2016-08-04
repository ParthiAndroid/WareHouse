package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    @SerializedName("deviceModel")
    private RegisterData deviceModel;

    public RegisterRequest(RegisterData deviceModel) {
        this.deviceModel = deviceModel;
    }


    public RegisterData getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(RegisterData deviceModel) {
        this.deviceModel = deviceModel;
    }
}