package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.SerializedName;

public class SearchGridData {

    @SerializedName("PageSize")
    String PageSize;
    @SerializedName("PageIndex")
    String PageIndex;
    @SerializedName("SortColumn")
    String SortColumn;
    @SerializedName("SortOrder")
    String SortOrder;

    public SearchGridData(String pageSize, String pageIndex, String sortColumn, String sortOrder) {
        PageSize = pageSize;
        PageIndex = pageIndex;
        SortColumn = sortColumn;
        SortOrder = sortOrder;
    }


    public String getSortOrder() {
        return SortOrder;
    }

    public void setSortOrder(String sortOrder) {
        SortOrder = sortOrder;
    }

    public String getSortColumn() {
        return SortColumn;
    }

    public void setSortColumn(String sortColumn) {
        SortColumn = sortColumn;
    }

    public String getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(String pageIndex) {
        PageIndex = pageIndex;
    }

    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }


}
