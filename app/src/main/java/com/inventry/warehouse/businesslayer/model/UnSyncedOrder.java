package com.inventry.warehouse.businesslayer.model;

public class UnSyncedOrder {

    String customerName;
    String sideMark;
    String csrName;
    String dateAdded;
    String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSideMark() {
        return sideMark;
    }

    public void setSideMark(String sideMark) {
        this.sideMark = sideMark;
    }

    public String getCsrName() {
        return csrName;
    }

    public void setCsrName(String csrName) {
        this.csrName = csrName;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
