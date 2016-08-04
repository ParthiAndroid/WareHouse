package com.inventry.warehouse.orders.neworder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConditionalNote {

    @SerializedName("ExceptionId")
    @Expose
    private String exceptionId;
    @SerializedName("ExceptionName")
    @Expose
    private String exceptionName;
    @SerializedName("LocationId")
    @Expose
    private String locationId;
    @SerializedName("LocationName")
    @Expose
    private String locationName;
    @SerializedName("Comments")
    @Expose
    private String comments;
    @SerializedName("ConditionalNoteId")
    @Expose
    private Integer conditionalNoteId;

    /**
     * No args constructor for use in serialization
     *
     */
    public ConditionalNote() {
    }

    /**
     *
     * @param conditionalNoteId
     * @param exceptionName
     * @param exceptionId
     * @param locationId
     * @param locationName
     * @param comments
     */
    public ConditionalNote(String exceptionId, String exceptionName, String locationId, String locationName, String comments, Integer conditionalNoteId) {
        this.exceptionId = exceptionId;
        this.exceptionName = exceptionName;
        this.locationId = locationId;
        this.locationName = locationName;
        this.comments = comments;
        this.conditionalNoteId = conditionalNoteId;
    }


    /**
     *
     * @return
     * The exceptionId
     */
    public String getExceptionId() {
        return exceptionId;
    }

    /**
     *
     * @param exceptionId
     * The ExceptionId
     */
    public void setExceptionId(String exceptionId) {
        this.exceptionId = exceptionId;
    }

    /**
     *
     * @return
     * The exceptionName
     */
    public String getExceptionName() {
        return exceptionName;
    }

    /**
     *
     * @param exceptionName
     * The ExceptionName
     */
    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    /**
     *
     * @return
     * The locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     *
     * @param locationId
     * The LocationId
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    /**
     *
     * @return
     * The locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     *
     * @param locationName
     * The LocationName
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     *
     * @return
     * The comments
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     * The Comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     * The conditionalNoteId
     */
    public Integer getConditionalNoteId() {
        return conditionalNoteId;
    }

    /**
     *
     * @param conditionalNoteId
     * The ConditionalNoteId
     */
    public void setConditionalNoteId(Integer conditionalNoteId) {
        this.conditionalNoteId = conditionalNoteId;
    }

}