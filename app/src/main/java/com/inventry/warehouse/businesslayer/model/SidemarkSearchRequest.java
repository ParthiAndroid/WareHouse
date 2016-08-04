package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SidemarkSearchRequest {

    @SerializedName("grid")
    @Expose
    public Grid grid;
    @SerializedName("smark")
    @Expose
    public Smark smark;

    public SidemarkSearchRequest() {
    }

    /**
     *
     * @param smark
     * @param grid
     */
    public SidemarkSearchRequest(Grid grid, Smark smark) {
        this.grid = grid;
        this.smark = smark;
    }

    /**
     *
     * @return
     * The grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     *
     * @param grid
     * The grid
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /**
     *
     * @return
     * The smark
     */
    public Smark getSmark() {
        return smark;
    }

    /**
     *
     * @param smark
     * The smark
     */
    public void setSmark(Smark smark) {
        this.smark = smark;
    }

    public class Grid {

        @SerializedName("PageSize")
        @Expose
        private String pageSize;
        @SerializedName("PageIndex")
        @Expose
        private String pageIndex;
        @SerializedName("SortColumn")
        @Expose
        private String sortColumn;
        @SerializedName("SortOrder")
        @Expose
        private String sortOrder;

        /**
         * No args constructor for use in serialization
         *
         * @param aPrivate
         * @param s
         */
        public Grid(String aPrivate, String s) {
        }

        /**
         *
         * @param sortColumn
         * @param sortOrder
         * @param pageSize
         * @param pageIndex
         */
        public Grid(String pageSize, String pageIndex, String sortColumn, String sortOrder) {
            this.pageSize = pageSize;
            this.pageIndex = pageIndex;
            this.sortColumn = sortColumn;
            this.sortOrder = sortOrder;
        }

        /**
         *
         * @return
         * The pageSize
         */
        public String getPageSize() {
            return pageSize;
        }

        /**
         *
         * @param pageSize
         * The PageSize
         */
        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        /**
         *
         * @return
         * The pageIndex
         */
        public String getPageIndex() {
            return pageIndex;
        }

        /**
         *
         * @param pageIndex
         * The PageIndex
         */
        public void setPageIndex(String pageIndex) {
            this.pageIndex = pageIndex;
        }

        /**
         *
         * @return
         * The sortColumn
         */
        public String getSortColumn() {
            return sortColumn;
        }

        /**
         *
         * @param sortColumn
         * The SortColumn
         */
        public void setSortColumn(String sortColumn) {
            this.sortColumn = sortColumn;
        }

        /**
         *
         * @return
         * The sortOrder
         */
        public String getSortOrder() {
            return sortOrder;
        }

        /**
         *
         * @param sortOrder
         * The SortOrder
         */
        public void setSortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
        }

    }


    public class Smark {

        @SerializedName("SideMark")
        @Expose
        private String sideMark;
        @SerializedName("CompanyId")
        @Expose
        private String companyId;

        /**
         * No args constructor for use in serialization
         *
         */
        public Smark() {
        }

        /**
         *
         * @param companyId
         * @param sideMark
         */
        public Smark(String sideMark, String companyId) {
            this.sideMark = sideMark;
            this.companyId = companyId;
        }

        /**
         *
         * @return
         * The sideMark
         */
        public String getSideMark() {
            return sideMark;
        }

        /**
         *
         * @param sideMark
         * The SideMark
         */
        public void setSideMark(String sideMark) {
            this.sideMark = sideMark;
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

    }

}



