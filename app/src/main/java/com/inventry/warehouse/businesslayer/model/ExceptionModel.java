package com.inventry.warehouse.businesslayer.model;

public class ExceptionModel {

    String mException;
    String mLocation;
    String mComments;

    public ExceptionModel(String mException, String mLocation, String mComments) {
        this.mException = mException;
        this.mLocation = mLocation;
        this.mComments = mComments;
    }

    public String getComments() {
        return mComments;
    }

    public void setComments(String comments) {
        this.mComments = comments;
    }

    public String getException() {
        return mException;
    }

    public void setException(String mException) {
        this.mException = mException;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }


}
