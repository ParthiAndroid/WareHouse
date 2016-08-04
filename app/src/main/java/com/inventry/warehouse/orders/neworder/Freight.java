package com.inventry.warehouse.orders.neworder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Freight {

    @SerializedName("FreightId")
    @Expose
    private Integer freightId;
    @SerializedName("JobId")
    @Expose
    private String jobId;
    @SerializedName("CarrierId")
    @Expose
    private String carrierId;
    @SerializedName("CarrierName")
    @Expose
    private Object carrierName;
    @SerializedName("FreightBillNo")
    @Expose
    private String freightBillNo;
    @SerializedName("IsFreightBill")
    @Expose
    private Boolean isFreightBill;
    @SerializedName("IsCollect")
    @Expose
    private Boolean isCollect;
    @SerializedName("IsPrepaid")
    @Expose
    private Boolean isPrepaid;
    @SerializedName("FreightAmt")
    @Expose
    private String freightAmt;
    @SerializedName("Weight")
    @Expose
    private String weight;

    /**
     * No args constructor for use in serialization
     *
     */
    public Freight() {
    }

    /**
     *
     * @param isFreightBill
     * @param weight
     * @param freightAmt
     * @param jobId
     * @param freightBillNo
     * @param carrierId
     * @param freightId
     * @param carrierName
     * @param isCollect
     * @param isPrepaid
     */
    public Freight(Integer freightId, String jobId, String carrierId, Object carrierName, String freightBillNo, Boolean isFreightBill, Boolean isCollect, Boolean isPrepaid, String freightAmt, String weight) {
        this.freightId = freightId;
        this.jobId = jobId;
        this.carrierId = carrierId;
        this.carrierName = carrierName;
        this.freightBillNo = freightBillNo;
        this.isFreightBill = isFreightBill;
        this.isCollect = isCollect;
        this.isPrepaid = isPrepaid;
        this.freightAmt = freightAmt;
        this.weight = weight;
    }

    /**
     *
     * @return
     * The freightId
     */
    public Integer getFreightId() {
        return freightId;
    }

    /**
     *
     * @param freightId
     * The FreightId
     */
    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
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
     * The carrierId
     */
    public String getCarrierId() {
        return carrierId;
    }

    /**
     *
     * @param carrierId
     * The CarrierId
     */
    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    /**
     *
     * @return
     * The carrierName
     */
    public Object getCarrierName() {
        return carrierName;
    }

    /**
     *
     * @param carrierName
     * The CarrierName
     */
    public void setCarrierName(Object carrierName) {
        this.carrierName = carrierName;
    }

    /**
     *
     * @return
     * The freightBillNo
     */
    public String getFreightBillNo() {
        return freightBillNo;
    }

    /**
     *
     * @param freightBillNo
     * The FreightBillNo
     */
    public void setFreightBillNo(String freightBillNo) {
        this.freightBillNo = freightBillNo;
    }

    /**
     *
     * @return
     * The isFreightBill
     */
    public Boolean getIsFreightBill() {
        return isFreightBill;
    }

    /**
     *
     * @param isFreightBill
     * The IsFreightBill
     */
    public void setIsFreightBill(Boolean isFreightBill) {
        this.isFreightBill = isFreightBill;
    }

    /**
     *
     * @return
     * The isCollect
     */
    public Boolean getIsCollect() {
        return isCollect;
    }

    /**
     *
     * @param isCollect
     * The IsCollect
     */
    public void setIsCollect(Boolean isCollect) {
        this.isCollect = isCollect;
    }

    /**
     *
     * @return
     * The isPrepaid
     */
    public Boolean getIsPrepaid() {
        return isPrepaid;
    }

    /**
     *
     * @param isPrepaid
     * The IsPrepaid
     */
    public void setIsPrepaid(Boolean isPrepaid) {
        this.isPrepaid = isPrepaid;
    }

    /**
     *
     * @return
     * The freightAmt
     */
    public String getFreightAmt() {
        return freightAmt;
    }

    /**
     *
     * @param freightAmt
     * The FreightAmt
     */
    public void setFreightAmt(String freightAmt) {
        this.freightAmt = freightAmt;
    }

    /**
     *
     * @return
     * The weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     * The Weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

}