package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 7/27/2016.
 */
public class MasterDataResponse {
    @SerializedName("Category")
    @Expose
    private List<Category> category = new ArrayList<Category>();
    @SerializedName("Company")
    @Expose
    private Object company;
    @SerializedName("Item")
    @Expose
    private Object item;
    @SerializedName("Smark")
    @Expose
    private Object smark;

    /**
     *
     * @return
     * The category
     */
    public List<Category> getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The Category
     */
    public void setCategory(List<Category> category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The company
     */
    public Object getCompany() {
        return company;
    }

    /**
     *
     * @param company
     * The Company
     */
    public void setCompany(Object company) {
        this.company = company;
    }

    /**
     *
     * @return
     * The item
     */
    public Object getItem() {
        return item;
    }

    /**
     *
     * @param item
     * The Item
     */
    public void setItem(Object item) {
        this.item = item;
    }

    /**
     *
     * @return
     * The smark
     */
    public Object getSmark() {
        return smark;
    }

    /**
     *
     * @param smark
     * The Smark
     */
    public void setSmark(Object smark) {
        this.smark = smark;
    }

    public class Category {

        @SerializedName("CategoryName")
        @Expose
        private String categoryName;
        @SerializedName("DictionaryPair")
        @Expose
        private List<DictionaryPair> dictionaryPair = new ArrayList<DictionaryPair>();

        /**
         *
         * @return
         * The categoryName
         */
        public String getCategoryName() {
            return categoryName;
        }

        /**
         *
         * @param categoryName
         * The CategoryName
         */
        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        /**
         *
         * @return
         * The dictionaryPair
         */
        public List<DictionaryPair> getDictionaryPair() {
            return dictionaryPair;
        }

        /**
         *
         * @param dictionaryPair
         * The DictionaryPair
         */
        public void setDictionaryPair(List<DictionaryPair> dictionaryPair) {
            this.dictionaryPair = dictionaryPair;
        }


        public class DictionaryPair {

            @SerializedName("key")
            @Expose
            private String key;
            @SerializedName("value")
            @Expose
            private String value;

            /**
             *
             * @return
             * The key
             */
            public String getKey() {
                return key;
            }

            /**
             *
             * @param key
             * The key
             */
            public void setKey(String key) {
                this.key = key;
            }

            /**
             *
             * @return
             * The value
             */
            public String getValue() {
                return value;
            }

            /**
             *
             * @param value
             * The value
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }


}




