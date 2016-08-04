package com.inventry.warehouse.businesslayer.model;


import com.google.gson.annotations.SerializedName;

public class SearchRequest {

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void setContactModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public SearchGridData getGridData() {
        return gridData;
    }

    public void setGridData(SearchGridData gridData) {
        this.gridData = gridData;
    }

    public SearchRequest(ContactModel contactModel, SearchGridData gridData) {
        this.contactModel = contactModel;
        this.gridData = gridData;
    }

    @SerializedName("contactModel")
    ContactModel contactModel;

    @SerializedName("grid")
    SearchGridData gridData;
}
