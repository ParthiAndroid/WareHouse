package com.inventry.warehouse.orders.neworder;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Job {

    @SerializedName("JobId")
    @Expose
    private String jobId;
    @SerializedName("JobDisplayId")
    @Expose
    private String jobDisplayId;
    @SerializedName("IsPuResidence")
    @Expose
    private Boolean isPuResidence;
    @SerializedName("PayTermId")
    @Expose
    private String payTermId;
    @SerializedName("CompanyId")
    @Expose
    private String companyId;
    @SerializedName("SmarkId")
    @Expose
    private String smarkId;
    @SerializedName("SmarkName")
    @Expose
    private String smarkName;
    @SerializedName("CubicFeet")
    @Expose
    private String cubicFeet;
    @SerializedName("PayerId")
    @Expose
    private String payerId;
    @SerializedName("Customer")
    @Expose
    private Customer customer;
    @SerializedName("Pickup")
    @Expose
    private Pickup pickup;
    @SerializedName("Payer")
    @Expose
    private Payer payer;
    @SerializedName("PayerType")
    @Expose
    private String payerType;
    @SerializedName("Items")
    @Expose
    private List<Item> items = new ArrayList<Item>();
    @SerializedName("TotalItems")
    @Expose
    private String totalItems;
    @SerializedName("Freight")
    @Expose
    private Freight freight;
    @SerializedName("CreatedBy")
    @Expose
    private String createdBy;
    @SerializedName("StorageTypeId")
    @Expose
    private String storageTypeId;
    @SerializedName("StorageType")
    @Expose
    private String storageType;
    @SerializedName("PayerContId")
    @Expose
    private String payerContId;
    @SerializedName("isItemChanged")
    @Expose
    private Boolean isItemChanged;
    @SerializedName("OrginName")
    @Expose
    private String orginName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Job() {
    }

    /**
     *
     * @param smarkId
     * @param payTermId
     * @param jobId
     * @param pickup
     * @param payerType
     * @param cubicFeet
     * @param isPuResidence
     * @param isItemChanged
     * @param customer
     * @param smarkName
     * @param createdBy
     * @param items
     * @param payer
     * @param storageType
     * @param freight
     * @param totalItems
     * @param payerId
     * @param companyId
     * @param orginName
     * @param payerContId
     * @param jobDisplayId
     * @param storageTypeId
     */
    public Job(String jobId, String jobDisplayId, Boolean isPuResidence, String payTermId, String companyId, String smarkId, String smarkName, String cubicFeet, String payerId, Customer customer, Pickup pickup, Payer payer, String payerType, List<Item> items, String totalItems, Freight freight, String createdBy, String storageTypeId, String storageType, String payerContId, Boolean isItemChanged, String orginName) {
        this.jobId = jobId;
        this.jobDisplayId = jobDisplayId;
        this.isPuResidence = isPuResidence;
        this.payTermId = payTermId;
        this.companyId = companyId;
        this.smarkId = smarkId;
        this.smarkName = smarkName;
        this.cubicFeet = cubicFeet;
        this.payerId = payerId;
        this.customer = customer;
        this.pickup = pickup;
        this.payer = payer;
        this.payerType = payerType;
        this.items = items;
        this.totalItems = totalItems;
        this.freight = freight;
        this.createdBy = createdBy;
        this.storageTypeId = storageTypeId;
        this.storageType = storageType;
        this.payerContId = payerContId;
        this.isItemChanged = isItemChanged;
        this.orginName = orginName;
    }

    /**
     *
     * @return
     * The jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     *
     * @param jobId
     * The JobId
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     *
     * @return
     * The jobDisplayId
     */
    public String getJobDisplayId() {
        return jobDisplayId;
    }

    /**
     *
     * @param jobDisplayId
     * The JobDisplayId
     */
    public void setJobDisplayId(String jobDisplayId) {
        this.jobDisplayId = jobDisplayId;
    }

    /**
     *
     * @return
     * The isPuResidence
     */
    public Boolean getIsPuResidence() {
        return isPuResidence;
    }

    /**
     *
     * @param isPuResidence
     * The IsPuResidence
     */
    public void setIsPuResidence(Boolean isPuResidence) {
        this.isPuResidence = isPuResidence;
    }

    /**
     *
     * @return
     * The payTermId
     */
    public String getPayTermId() {
        return payTermId;
    }

    /**
     *
     * @param payTermId
     * The PayTermId
     */
    public void setPayTermId(String payTermId) {
        this.payTermId = payTermId;
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
     * The smarkId
     */
    public String getSmarkId() {
        return smarkId;
    }

    /**
     *
     * @param smarkId
     * The SmarkId
     */
    public void setSmarkId(String smarkId) {
        this.smarkId = smarkId;
    }

    /**
     *
     * @return
     * The smarkName
     */
    public String getSmarkName() {
        return smarkName;
    }

    /**
     *
     * @param smarkName
     * The SmarkName
     */
    public void setSmarkName(String smarkName) {
        this.smarkName = smarkName;
    }

    /**
     *
     * @return
     * The cubicFeet
     */
    public String getCubicFeet() {
        return cubicFeet;
    }

    /**
     *
     * @param cubicFeet
     * The CubicFeet
     */
    public void setCubicFeet(String cubicFeet) {
        this.cubicFeet = cubicFeet;
    }

    /**
     *
     * @return
     * The payerId
     */
    public String getPayerId() {
        return payerId;
    }

    /**
     *
     * @param payerId
     * The PayerId
     */
    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    /**
     *
     * @return
     * The customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     * The Customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     * The pickup
     */
    public Pickup getPickup() {
        return pickup;
    }

    /**
     *
     * @param pickup
     * The Pickup
     */
    public void setPickup(Pickup pickup) {
        this.pickup = pickup;
    }

    /**
     *
     * @return
     * The payer
     */
    public Payer getPayer() {
        return payer;
    }

    /**
     *
     * @param payer
     * The Payer
     */
    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    /**
     *
     * @return
     * The payerType
     */
    public String getPayerType() {
        return payerType;
    }

    /**
     *
     * @param payerType
     * The PayerType
     */
    public void setPayerType(String payerType) {
        this.payerType = payerType;
    }

    /**
     *
     * @return
     * The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The Items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     *
     * @return
     * The totalItems
     */
    public String getTotalItems() {
        return totalItems;
    }

    /**
     *
     * @param totalItems
     * The TotalItems
     */
    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    /**
     *
     * @return
     * The freight
     */
    public Freight getFreight() {
        return freight;
    }

    /**
     *
     * @param freight
     * The Freight
     */
    public void setFreight(Freight freight) {
        this.freight = freight;
    }

    /**
     *
     * @return
     * The createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     *
     * @param createdBy
     * The CreatedBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     *
     * @return
     * The storageTypeId
     */
    public String getStorageTypeId() {
        return storageTypeId;
    }

    /**
     *
     * @param storageTypeId
     * The StorageTypeId
     */
    public void setStorageTypeId(String storageTypeId) {
        this.storageTypeId = storageTypeId;
    }

    /**
     *
     * @return
     * The storageType
     */
    public String getStorageType() {
        return storageType;
    }

    /**
     *
     * @param storageType
     * The StorageType
     */
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    /**
     *
     * @return
     * The payerContId
     */
    public String getPayerContId() {
        return payerContId;
    }

    /**
     *
     * @param payerContId
     * The PayerContId
     */
    public void setPayerContId(String payerContId) {
        this.payerContId = payerContId;
    }

    /**
     *
     * @return
     * The isItemChanged
     */
    public Boolean getIsItemChanged() {
        return isItemChanged;
    }

    /**
     *
     * @param isItemChanged
     * The isItemChanged
     */
    public void setIsItemChanged(Boolean isItemChanged) {
        this.isItemChanged = isItemChanged;
    }

    /**
     *
     * @return
     * The orginName
     */
    public String getOrginName() {
        return orginName;
    }

    /**
     *
     * @param orginName
     * The OrginName
     */
    public void setOrginName(String orginName) {
        this.orginName = orginName;
    }

}