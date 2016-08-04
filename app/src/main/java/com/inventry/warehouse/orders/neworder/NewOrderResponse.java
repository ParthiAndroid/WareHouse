package com.inventry.warehouse.orders.neworder;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewOrderResponse {

    public NewOrderResponse(){
    }

    public NewOrderResponse(String message, boolean success) {
        Message = message;
        Success = success;
    }

    @SerializedName("Message")
    @Expose
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

    @SerializedName("Success")
    @Expose
    private boolean Success;

}
