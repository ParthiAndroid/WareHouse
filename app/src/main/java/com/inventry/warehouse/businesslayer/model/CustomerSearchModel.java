package com.inventry.warehouse.businesslayer.model;

public class CustomerSearchModel {

    String customerNumber;
    String companyName;

    public CustomerSearchModel(String customerNumber, String companyName, String customerCity, String customerState) {
        this.customerNumber = customerNumber;
        this.companyName = companyName;
        this.customerCity = customerCity;
        this.customerState = customerState;
    }

    String customerCity;

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    String customerState;
}
