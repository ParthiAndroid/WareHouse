package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.SerializedName;

public class ContactModel {

    public String getDisplayId() {
        return displayId;
    }

    public ContactModel(String displayId) {
        this.displayId = displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    @SerializedName("displayId")
    String displayId;
}
