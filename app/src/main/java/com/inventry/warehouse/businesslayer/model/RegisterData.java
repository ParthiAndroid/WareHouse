package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.SerializedName;

public class RegisterData {

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getGsmId() {
        return gsmId;
    }

    public void setGsmId(String gsmId) {
        this.gsmId = gsmId;
    }

    @SerializedName("DeviceType")
    private String deviceType;
    @SerializedName("Version")
    private String version;
    @SerializedName("DeviceId")
    private String deviceId;
    @SerializedName("GSM")
    private String gsmId;

    public RegisterData(String deviceType, String version, String deviceId, String gsmId) {
        this.deviceType = deviceType;
        this.version = version;
        this.deviceId = deviceId;
        this.gsmId = gsmId;
    }

}
