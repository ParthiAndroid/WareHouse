package com.inventry.warehouse.businesslayer.model;


public class MasterDataRequest {

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    String userId;

    public MasterDataRequest(String userId) {
        this.userId = userId;
    }
}
