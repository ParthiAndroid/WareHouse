package com.inventry.warehouse.orders.neworder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TagDetail {

    @SerializedName("TagName")
    @Expose
    private String tagName;
    @SerializedName("TagId")
    @Expose
    private Integer tagId;
    @SerializedName("SeqNo")
    @Expose
    private Integer seqNo;
    @SerializedName("IsNew")
    @Expose
    private Boolean isNew;
    @SerializedName("CreatedBy")
    @Expose
    private String CreatedBy;
    @SerializedName("ModifiedBy")
    @Expose
    private String ModifiedBy;

    @SerializedName("CreatedDate")
    @Expose
    private String CreatedDate;
    @SerializedName("ModifiedDate")
    @Expose
    private String ModifiedDate;

    public String getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    /**

     * No args constructor for use in serialization
     *
     */
    public TagDetail() {
    }

    /**
     *
     * @param seqNo
     * @param isNew
     * @param tagName
     * @param tagId
     */
    public TagDetail(String tagName, Integer tagId, Integer seqNo, Boolean isNew,
                     String ModifiedBy, String CreatedBy, String CreatedDate, String ModifiedDate) {
        this.tagName = tagName;
        this.tagId = tagId;
        this.seqNo = seqNo;
        this.isNew = isNew;
        this.ModifiedBy = ModifiedBy;
        this.CreatedBy =CreatedBy;
        this.CreatedDate = CreatedDate;
        this.ModifiedDate = ModifiedDate;
    }

    /**
     *
     * @return
     * The tagName
     */
    public String getTagName() {
        return tagName;
    }

    /**
     *
     * @param tagName
     * The TagName
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     *
     * @return
     * The tagId
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     *
     * @param tagId
     * The TagId
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     *
     * @return
     * The seqNo
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @param seqNo
     * The SeqNo
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
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

}