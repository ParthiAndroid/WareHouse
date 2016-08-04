package com.inventry.warehouse.orders.neworder;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewOrder {

    @SerializedName("job")
    @Expose
    private Job job;
    @SerializedName("trfJobId")
    @Expose
    private String trfJobId;
    @SerializedName("UserId")
    @Expose
    private String userId;

    /**
     * No args constructor for use in serialization
     */
    public NewOrder() {
    }

    /**
     * @param userId
     * @param job
     * @param trfJobId
     */
    public NewOrder(Job job, String trfJobId, String userId) {
        this.job = job;
        this.trfJobId = trfJobId;
        this.userId = userId;
    }

    /**
     * @return The job
     */
    public Job getJob() {
        return job;
    }

    /**
     * @param job The job
     */
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * @return The trfJobId
     */
    public String getTrfJobId() {
        return trfJobId;
    }

    /**
     * @param trfJobId The trfJobId
     */
    public void setTrfJobId(String trfJobId) {
        this.trfJobId = trfJobId;
    }

    /**
     * @return The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId The UserId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}