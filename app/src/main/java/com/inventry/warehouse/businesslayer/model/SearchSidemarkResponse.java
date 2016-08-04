package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchSidemarkResponse implements Serializable {

    @SerializedName("Smark")
    @Expose
    private List<Smark> smark = new ArrayList<Smark>();

    /**
     *
     * @return
     * The smark
     */
    public List<Smark> getSmark() {
        return smark;
    }

    /**
     *
     * @param smark
     * The Smark
     */
    public void setSmark(List<Smark> smark) {
        this.smark = smark;
    }


    public class Smark implements Serializable {

        @SerializedName("CreatedBy")
        @Expose
        private Object createdBy;
        @SerializedName("CreatedDate")
        @Expose
        private Object createdDate;
        @SerializedName("ModifiedBy")
        @Expose
        private Object modifiedBy;
        @SerializedName("ModifiedDate")
        @Expose
        private Object modifiedDate;
        @SerializedName("BillTypeID")
        @Expose
        private Object billTypeID;
        @SerializedName("ClientCode")
        @Expose
        private String clientCode;
        @SerializedName("ClientName")
        @Expose
        private String clientName;
        @SerializedName("CompanyContactId")
        @Expose
        private String companyContactId;
        @SerializedName("Documents")
        @Expose
        private Object documents;
        @SerializedName("IsActive")
        @Expose
        private Boolean isActive;
        @SerializedName("IsCftStoragePricDef")
        @Expose
        private Object isCftStoragePricDef;
        @SerializedName("IsReceivingVal")
        @Expose
        private Boolean isReceivingVal;
        @SerializedName("IsStorageDeliveryVal")
        @Expose
        private Boolean isStorageDeliveryVal;
        @SerializedName("ItemSmarkId")
        @Expose
        private String itemSmarkId;
        @SerializedName("Notes")
        @Expose
        private Object notes;
        @SerializedName("PricingTypeId")
        @Expose
        private String pricingTypeId;
        @SerializedName("PricingValue")
        @Expose
        private String pricingValue;
        @SerializedName("ReceivingVal")
        @Expose
        private String receivingVal;
        @SerializedName("SmarkId")
        @Expose
        private String smarkId;
        @SerializedName("SmarkName")
        @Expose
        private String smarkName;
        @SerializedName("StorageDeliveryVal")
        @Expose
        private String storageDeliveryVal;
        @SerializedName("StorageType")
        @Expose
        private String storageType;
        @SerializedName("StorageTypeId")
        @Expose
        private String storageTypeId;

        /**
         *
         * @return
         * The createdBy
         */
        public Object getCreatedBy() {
            return createdBy;
        }

        /**
         *
         * @param createdBy
         * The CreatedBy
         */
        public void setCreatedBy(Object createdBy) {
            this.createdBy = createdBy;
        }

        /**
         *
         * @return
         * The createdDate
         */
        public Object getCreatedDate() {
            return createdDate;
        }

        /**
         *
         * @param createdDate
         * The CreatedDate
         */
        public void setCreatedDate(Object createdDate) {
            this.createdDate = createdDate;
        }

        /**
         *
         * @return
         * The modifiedBy
         */
        public Object getModifiedBy() {
            return modifiedBy;
        }

        /**
         *
         * @param modifiedBy
         * The ModifiedBy
         */
        public void setModifiedBy(Object modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        /**
         *
         * @return
         * The modifiedDate
         */
        public Object getModifiedDate() {
            return modifiedDate;
        }

        /**
         *
         * @param modifiedDate
         * The ModifiedDate
         */
        public void setModifiedDate(Object modifiedDate) {
            this.modifiedDate = modifiedDate;
        }

        /**
         *
         * @return
         * The billTypeID
         */
        public Object getBillTypeID() {
            return billTypeID;
        }

        /**
         *
         * @param billTypeID
         * The BillTypeID
         */
        public void setBillTypeID(Object billTypeID) {
            this.billTypeID = billTypeID;
        }

        /**
         *
         * @return
         * The clientCode
         */
        public String getClientCode() {
            return clientCode;
        }

        /**
         *
         * @param clientCode
         * The ClientCode
         */
        public void setClientCode(String clientCode) {
            this.clientCode = clientCode;
        }

        /**
         *
         * @return
         * The clientName
         */
        public String getClientName() {
            return clientName;
        }

        /**
         *
         * @param clientName
         * The ClientName
         */
        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        /**
         *
         * @return
         * The companyContactId
         */
        public String getCompanyContactId() {
            return companyContactId;
        }

        /**
         *
         * @param companyContactId
         * The CompanyContactId
         */
        public void setCompanyContactId(String companyContactId) {
            this.companyContactId = companyContactId;
        }

        /**
         *
         * @return
         * The documents
         */
        public Object getDocuments() {
            return documents;
        }

        /**
         *
         * @param documents
         * The Documents
         */
        public void setDocuments(Object documents) {
            this.documents = documents;
        }

        /**
         *
         * @return
         * The isActive
         */
        public Boolean getIsActive() {
            return isActive;
        }

        /**
         *
         * @param isActive
         * The IsActive
         */
        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

        /**
         *
         * @return
         * The isCftStoragePricDef
         */
        public Object getIsCftStoragePricDef() {
            return isCftStoragePricDef;
        }

        /**
         *
         * @param isCftStoragePricDef
         * The IsCftStoragePricDef
         */
        public void setIsCftStoragePricDef(Object isCftStoragePricDef) {
            this.isCftStoragePricDef = isCftStoragePricDef;
        }

        /**
         *
         * @return
         * The isReceivingVal
         */
        public Boolean getIsReceivingVal() {
            return isReceivingVal;
        }

        /**
         *
         * @param isReceivingVal
         * The IsReceivingVal
         */
        public void setIsReceivingVal(Boolean isReceivingVal) {
            this.isReceivingVal = isReceivingVal;
        }

        /**
         *
         * @return
         * The isStorageDeliveryVal
         */
        public Boolean getIsStorageDeliveryVal() {
            return isStorageDeliveryVal;
        }

        /**
         *
         * @param isStorageDeliveryVal
         * The IsStorageDeliveryVal
         */
        public void setIsStorageDeliveryVal(Boolean isStorageDeliveryVal) {
            this.isStorageDeliveryVal = isStorageDeliveryVal;
        }

        /**
         *
         * @return
         * The itemSmarkId
         */
        public String getItemSmarkId() {
            return itemSmarkId;
        }

        /**
         *
         * @param itemSmarkId
         * The ItemSmarkId
         */
        public void setItemSmarkId(String itemSmarkId) {
            this.itemSmarkId = itemSmarkId;
        }

        /**
         *
         * @return
         * The notes
         */
        public Object getNotes() {
            return notes;
        }

        /**
         *
         * @param notes
         * The Notes
         */
        public void setNotes(Object notes) {
            this.notes = notes;
        }

        /**
         *
         * @return
         * The pricingTypeId
         */
        public String getPricingTypeId() {
            return pricingTypeId;
        }

        /**
         *
         * @param pricingTypeId
         * The PricingTypeId
         */
        public void setPricingTypeId(String pricingTypeId) {
            this.pricingTypeId = pricingTypeId;
        }

        /**
         *
         * @return
         * The pricingValue
         */
        public String getPricingValue() {
            return pricingValue;
        }

        /**
         *
         * @param pricingValue
         * The PricingValue
         */
        public void setPricingValue(String pricingValue) {
            this.pricingValue = pricingValue;
        }

        /**
         *
         * @return
         * The receivingVal
         */
        public String getReceivingVal() {
            return receivingVal;
        }

        /**
         *
         * @param receivingVal
         * The ReceivingVal
         */
        public void setReceivingVal(String receivingVal) {
            this.receivingVal = receivingVal;
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
         * The storageDeliveryVal
         */
        public String getStorageDeliveryVal() {
            return storageDeliveryVal;
        }

        /**
         *
         * @param storageDeliveryVal
         * The StorageDeliveryVal
         */
        public void setStorageDeliveryVal(String storageDeliveryVal) {
            this.storageDeliveryVal = storageDeliveryVal;
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

    }



}
