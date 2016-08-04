package com.inventry.warehouse.orders.neworder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pickup {

    @SerializedName("ContactId")
    @Expose
    private String contactId;
    @SerializedName("CompanyId")
    @Expose
    private String companyId;
    @SerializedName("AddressId")
    @Expose
    private String addressId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pickup() {
    }

    /**
     *
     * @param contactId
     * @param companyId
     * @param addressId
     */
    public Pickup(String contactId, String companyId, String addressId) {
        this.contactId = contactId;
        this.companyId = companyId;
        this.addressId = addressId;
    }

    /**
     *
     * @return
     * The contactId
     */
    public String getContactId() {
        return contactId;
    }

    /**
     *
     * @param contactId
     * The ContactId
     */
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    /**
     *
     * @return
     * The companyId
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     *
     * @param companyId
     * The CompanyId
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     *
     * @return
     * The addressId
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     *
     * @param addressId
     * The AddressId
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

}