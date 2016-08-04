package com.inventry.warehouse.orders.neworder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Item {

    @SerializedName("JobItemId")
    @Expose
    private String jobItemId;
    @SerializedName("ItemName")
    @Expose
    private String itemName;
    @SerializedName("ItemH")
    @Expose
    private String itemH;
    @SerializedName("ItemW")
    @Expose
    private String itemW;
    @SerializedName("ItemD")
    @Expose
    private String itemD;
    @SerializedName("ItemValue")
    @Expose
    private Integer itemValue;
    @SerializedName("ItemQuantity")
    @Expose
    private String itemQuantity;
    @SerializedName("ItemCuFt")
    @Expose
    private String itemCuFt;
    @SerializedName("ItemSqFt")
    @Expose
    private String itemSqFt;
    @SerializedName("ItemLbs")
    @Expose
    private String itemLbs;
    @SerializedName("IsConditionNotes")
    @Expose
    private Boolean isConditionNotes;
    @SerializedName("BarCode")
    @Expose
    private String barCode;
    @SerializedName("IsNew")
    @Expose
    private Boolean isNew;
    @SerializedName("IsCubicOverride")
    @Expose
    private Boolean isCubicOverride;
    @SerializedName("IsSqFtOverride")
    @Expose
    private Boolean isSqFtOverride;
    @SerializedName("SeqNo")
    @Expose
    private String seqNo;
    @SerializedName("SmarkId")
    @Expose
    private String smarkId;

    public String getValuationTypeId() {
        return ValuationTypeId;
    }

    public void setValuationTypeId(String valuationTypeId) {
        ValuationTypeId = valuationTypeId;
    }

    /*public boolean isImportantNotes() {
        return isImportantNotes;
    }*/

    @SerializedName("ValuationTypeId")
    @Expose
    private String ValuationTypeId;
    @SerializedName("IsQuickAdd")
    @Expose
    private Boolean isQuickAdd;
    @SerializedName("IsImportantNotes")
    @Expose
    private boolean isImportantNotes;
    @SerializedName("ConditionalNotes")
    @Expose
    private List<ConditionalNote> conditionalNotes = new ArrayList<ConditionalNote>();
    @SerializedName("TagDetails")
    @Expose
    private List<TagDetail> tagDetails = new ArrayList<TagDetail>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Item() {
    }

    /**
     *
     * @param smarkId
     * @param itemD
     * @param itemLbs
     * @param itemName
     * @param itemQuantity
     * @param seqNo
     * @param isCubicOverride
     * @param itemH
     * @param isNew
     * @param isQuickAdd
     * @param isSqFtOverride
     * @param jobItemId
     * @param itemValue
     * @param itemCuFt
     * @param itemSqFt
     * @param isConditionNotes
     * @param itemW
     * @param isImportantNotes
     * @param barCode
     * @param conditionalNotes
     * @param tagDetails
     */
    public Item(String jobItemId, String itemName, String itemH, String itemW, String itemD,
                Integer itemValue, String itemQuantity, String itemCuFt, String itemSqFt,
                String itemLbs, Boolean isConditionNotes, String barCode, Boolean isNew,
                Boolean isCubicOverride, Boolean isSqFtOverride, String seqNo, String smarkId,
                Boolean isQuickAdd, String ValuationTypeId, boolean isImportantNotes, List<ConditionalNote> conditionalNotes,
                List<TagDetail> tagDetails) {
        this.jobItemId = jobItemId;
        this.itemName = itemName;
        this.itemH = itemH;
        this.itemW = itemW;
        this.itemD = itemD;
        this.itemValue = itemValue;
        this.itemQuantity = itemQuantity;
        this.itemCuFt = itemCuFt;
        this.itemSqFt = itemSqFt;
        this.itemLbs = itemLbs;
        this.isConditionNotes = isConditionNotes;
        this.barCode = barCode;
        this.isNew = isNew;
        this.isCubicOverride = isCubicOverride;
        this.isSqFtOverride = isSqFtOverride;
        this.seqNo = seqNo;
        this.smarkId = smarkId;
        this.isQuickAdd = isQuickAdd;
        this.isImportantNotes = isImportantNotes;
        this.conditionalNotes = conditionalNotes;
        this.tagDetails = tagDetails;
        this.ValuationTypeId = ValuationTypeId;
    }

    /**
     *
     * @return
     * The jobItemId
     */
    public String getJobItemId() {
        return jobItemId;
    }

    /**
     *
     * @param jobItemId
     * The JobItemId
     */
    public void setJobItemId(String jobItemId) {
        this.jobItemId = jobItemId;
    }

    /**
     *
     * @return
     * The itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     *
     * @param itemName
     * The ItemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return
     * The itemH
     */
    public String getItemH() {
        return itemH;
    }

    /**
     *
     * @param itemH
     * The ItemH
     */
    public void setItemH(String itemH) {
        this.itemH = itemH;
    }

    /**
     *
     * @return
     * The itemW
     */
    public String getItemW() {
        return itemW;
    }

    /**
     *
     * @param itemW
     * The ItemW
     */
    public void setItemW(String itemW) {
        this.itemW = itemW;
    }

    /**
     *
     * @return
     * The itemD
     */
    public String getItemD() {
        return itemD;
    }

    /**
     *
     * @param itemD
     * The ItemD
     */
    public void setItemD(String itemD) {
        this.itemD = itemD;
    }

    /**
     *
     * @return
     * The itemValue
     */
    public Integer getItemValue() {
        return itemValue;
    }

    /**
     *
     * @param itemValue
     * The ItemValue
     */
    public void setItemValue(Integer itemValue) {
        this.itemValue = itemValue;
    }

    /**
     *
     * @return
     * The itemQuantity
     */
    public String getItemQuantity() {
        return itemQuantity;
    }

    /**
     *
     * @param itemQuantity
     * The ItemQuantity
     */
    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     *
     * @return
     * The itemCuFt
     */
    public String getItemCuFt() {
        return itemCuFt;
    }

    /**
     *
     * @param itemCuFt
     * The ItemCuFt
     */
    public void setItemCuFt(String itemCuFt) {
        this.itemCuFt = itemCuFt;
    }

    /**
     *
     * @return
     * The itemSqFt
     */
    public String getItemSqFt() {
        return itemSqFt;
    }

    /**
     *
     * @param itemSqFt
     * The ItemSqFt
     */
    public void setItemSqFt(String itemSqFt) {
        this.itemSqFt = itemSqFt;
    }

    /**
     *
     * @return
     * The itemLbs
     */
    public String getItemLbs() {
        return itemLbs;
    }

    /**
     *
     * @param itemLbs
     * The ItemLbs
     */
    public void setItemLbs(String itemLbs) {
        this.itemLbs = itemLbs;
    }

    /**
     *
     * @return
     * The isConditionNotes
     */
    public Boolean getIsConditionNotes() {
        return isConditionNotes;
    }

    /**
     *
     * @param isConditionNotes
     * The IsConditionNotes
     */
    public void setIsConditionNotes(Boolean isConditionNotes) {
        this.isConditionNotes = isConditionNotes;
    }

    /**
     *
     * @return
     * The barCode
     */
    public Object getBarCode() {
        return barCode;
    }

    /**
     *
     * @param barCode
     * The BarCode
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /**
     *
     * @return
     * The isNew
     */
    public Boolean getIsNew() {
        return isNew;
    }

    /**
     *
     * @param isNew
     * The IsNew
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    /**
     *
     * @return
     * The isCubicOverride
     */
    public Boolean getIsCubicOverride() {
        return isCubicOverride;
    }

    /**
     *
     * @param isCubicOverride
     * The IsCubicOverride
     */
    public void setIsCubicOverride(Boolean isCubicOverride) {
        this.isCubicOverride = isCubicOverride;
    }

    /**
     *
     * @return
     * The isSqFtOverride
     */
    public Boolean getIsSqFtOverride() {
        return isSqFtOverride;
    }

    /**
     *
     * @param isSqFtOverride
     * The IsSqFtOverride
     */
    public void setIsSqFtOverride(Boolean isSqFtOverride) {
        this.isSqFtOverride = isSqFtOverride;
    }

    /**
     *
     * @return
     * The seqNo
     */
    public Object getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @param seqNo
     * The SeqNo
     */
    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
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
     * The isQuickAdd
     */
    public Boolean getIsQuickAdd() {
        return isQuickAdd;
    }

    /**
     *
     * @param isQuickAdd
     * The IsQuickAdd
     */
    public void setIsQuickAdd(Boolean isQuickAdd) {
        this.isQuickAdd = isQuickAdd;
    }

    /**
     *
     * @return
     * The isImportantNotes
     */
    public Object getIsImportantNotes() {
        return isImportantNotes;
    }

    /**
     *
     * @param isImportantNotes
     * The IsImportantNotes
     */
    public void setIsImportantNotes(boolean isImportantNotes) {
        this.isImportantNotes = isImportantNotes;
    }

    /**
     *
     * @return
     * The conditionalNotes
     */
    public List<ConditionalNote> getConditionalNotes() {
        return conditionalNotes;
    }

    /**
     *
     * @param conditionalNotes
     * The ConditionalNotes
     */
    public void setConditionalNotes(List<ConditionalNote> conditionalNotes) {
        this.conditionalNotes = conditionalNotes;
    }

    /**
     *
     * @return
     * The tagDetails
     */
    public List<TagDetail> getTagDetails() {
        return tagDetails;
    }

    /**
     *
     * @param tagDetails
     * The TagDetails
     */
    public void setTagDetails(List<TagDetail> tagDetails) {
        this.tagDetails = tagDetails;
    }

}