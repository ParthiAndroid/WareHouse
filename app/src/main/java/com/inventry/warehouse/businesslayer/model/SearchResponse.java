package com.inventry.warehouse.businesslayer.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchResponse implements Serializable{

    @SerializedName("Category")
    String category;
    @SerializedName("Item")
    String item;
    @SerializedName("Smark")
    String sidemark;

    @SerializedName("Company")
    ArrayList<Company> CompanyDataItems;

    public ArrayList<Company> getCompanyDataItems() {
        return CompanyDataItems;
    }

    public void setCompanyDataItems(ArrayList<Company> companyDataItems) {
        CompanyDataItems = companyDataItems;
    }

    public String getSidemark() {
        return sidemark;
    }

    public void setSidemark(String sidemark) {
        this.sidemark = sidemark;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public class Company implements Serializable{

        @SerializedName("CreatedBy")
        String CreatedBy;
        @SerializedName("CreatedDate")
        String CreatedDate;
        @SerializedName("ModifiedBy")
        String ModifiedBy;
        @SerializedName("ModifiedDate")
        String ModifiedDate;
        @SerializedName("Address1")
        String Address1;
        @SerializedName("AddressId")
        String AddressId;
        @SerializedName("Beeper")
        String Beeper;
        @SerializedName("BillingContact")
        String BillingContact;
        @SerializedName("BillingContactId")
        String BillingContactId;
        @SerializedName("BusinessName")
        String BusinessName;
        @SerializedName("Cell")
        String Cell;
        @SerializedName("City")
        String City;
        @SerializedName("ClientStatus")
        String ClientStatus;
        @SerializedName("CompAddIsDefault")
        boolean CompAddIsDefault;
        @SerializedName("CompanyAddressId")
        String CompanyAddressId;
        @SerializedName("CompanyContactId")
        String CompanyContactId;
        @SerializedName("CompanyId")
        String CompanyId;
        @SerializedName("CompanyIndustryType")
        String CompanyIndustryType;
        @SerializedName("CompanyNo")
        String CompanyNo;
        @SerializedName("ContactCsr")
        String ContactCsr;
        @SerializedName("ContactId")
        String ContactId;
        @SerializedName("ContactNo")
        String ContactNo;
        @SerializedName("CountryId")
        String CountryId;
        @SerializedName("CountryName")
        String CountryName;
        @SerializedName("CreditStatusId")
        String CreditStatusId;
        @SerializedName("DisplayId")
        String DisplayId;

        ///
        @SerializedName("Email")
        String Email;
        @SerializedName("Fax")
        String Fax;
        @SerializedName("FirstName")
        String FirstName;
        @SerializedName("Flag")
        String Flag;
        @SerializedName("InvoiceNo")
        String InvoiceNo;
        @SerializedName("IsActive")
        String IsActive;
        @SerializedName("IsBilling")
        String IsBilling;
        @SerializedName("IsCompanyContact")
        String IsCompanyContact;
        @SerializedName("IsConsBilling")
        String IsConsBilling;
        @SerializedName("IsCustomPricing")
        String IsCustomPricing;
        @SerializedName("IsImportant")
        String IsImportant;
        @SerializedName("IsPrimary")
        String IsPrimary;
        @SerializedName("IsSecondary")
        String IsSecondary;
        @SerializedName("IsValuationD")
        String IsValuationD;
        @SerializedName("IsViewInvoice")
        String IsViewInvoice;
        @SerializedName("LastName")
        String LastName;
        @SerializedName("Latitude")
        String Latitude;
        @SerializedName("Longitude")
        String Longitude;
        @SerializedName("NotesCount")
        int NotesCount;
        @SerializedName("Number")
        String Number;
        @SerializedName("OtherPhone")
        String OtherPhone;
        @SerializedName("ParentBusinessName")
        String ParentBusinessName;
        @SerializedName("ParentCompanyId")
        String ParentCompanyId;
        @SerializedName("PayTermId")
        String PayTermId;
        @SerializedName("Phone")
        String Phone;

        /////
        @SerializedName("PrimaryContact")
        boolean PrimaryContact;
        @SerializedName("QBListId")
        String QBListId;
        @SerializedName("RegionId")
        String RegionId;
        @SerializedName("RowId")
        int RowId;
        @SerializedName("ShowAll")
        boolean ShowAll;
        @SerializedName("State")
        String State;
        @SerializedName("TotalRecords")
        int TotalRecords;
        @SerializedName("Type")
        String Type;
        @SerializedName("TypeId")
        String TypeId;
        @SerializedName("WebSite")
        String WebSite;
        @SerializedName("WorkPhone")
        String WorkPhone;
        @SerializedName("Zipcode")
        String Zipcode;

        public String getCreatedBy() {
            return CreatedBy;
        }

        public void setCreatedBy(String createdBy) {
            CreatedBy = createdBy;
        }

        public String getCreatedDate() {
            return CreatedDate;
        }

        public void setCreatedDate(String createdDate) {
            CreatedDate = createdDate;
        }

        public String getModifiedBy() {
            return ModifiedBy;
        }

        public void setModifiedBy(String modifiedBy) {
            ModifiedBy = modifiedBy;
        }

        public String getModifiedDate() {
            return ModifiedDate;
        }

        public void setModifiedDate(String modifiedDate) {
            ModifiedDate = modifiedDate;
        }

        public String getAddress1() {
            return Address1;
        }

        public void setAddress1(String address1) {
            Address1 = address1;
        }

        public String getAddressId() {
            return AddressId;
        }

        public void setAddressId(String addressId) {
            AddressId = addressId;
        }

        public String getBeeper() {
            return Beeper;
        }

        public void setBeeper(String beeper) {
            Beeper = beeper;
        }

        public String getBillingContact() {
            return BillingContact;
        }

        public void setBillingContact(String billingContact) {
            BillingContact = billingContact;
        }

        public String getBillingContactId() {
            return BillingContactId;
        }

        public void setBillingContactId(String billingContactId) {
            BillingContactId = billingContactId;
        }

        public String getBusinessName() {
            return BusinessName;
        }

        public void setBusinessName(String businessName) {
            BusinessName = businessName;
        }

        public String getCell() {
            return Cell;
        }

        public void setCell(String cell) {
            Cell = cell;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            City = city;
        }

        public String getClientStatus() {
            return ClientStatus;
        }

        public void setClientStatus(String clientStatus) {
            ClientStatus = clientStatus;
        }

        public boolean isCompAddIsDefault() {
            return CompAddIsDefault;
        }

        public void setCompAddIsDefault(boolean compAddIsDefault) {
            CompAddIsDefault = compAddIsDefault;
        }

        public String getCompanyAddressId() {
            return CompanyAddressId;
        }

        public void setCompanyAddressId(String companyAddressId) {
            CompanyAddressId = companyAddressId;
        }

        public String getCompanyContactId() {
            return CompanyContactId;
        }

        public void setCompanyContactId(String companyContactId) {
            CompanyContactId = companyContactId;
        }

        public String getCompanyId() {
            return CompanyId;
        }

        public void setCompanyId(String companyId) {
            CompanyId = companyId;
        }

        public String getCompanyIndustryType() {
            return CompanyIndustryType;
        }

        public void setCompanyIndustryType(String companyIndustryType) {
            CompanyIndustryType = companyIndustryType;
        }

        public String getCompanyNo() {
            return CompanyNo;
        }

        public void setCompanyNo(String companyNo) {
            CompanyNo = companyNo;
        }

        public String getContactCsr() {
            return ContactCsr;
        }

        public void setContactCsr(String contactCsr) {
            ContactCsr = contactCsr;
        }

        public String getContactId() {
            return ContactId;
        }

        public void setContactId(String contactId) {
            ContactId = contactId;
        }

        public String getContactNo() {
            return ContactNo;
        }

        public void setContactNo(String contactNo) {
            ContactNo = contactNo;
        }

        public String getCountryId() {
            return CountryId;
        }

        public void setCountryId(String countryId) {
            CountryId = countryId;
        }

        public String getCountryName() {
            return CountryName;
        }

        public void setCountryName(String countryName) {
            CountryName = countryName;
        }

        public String getCreditStatusId() {
            return CreditStatusId;
        }

        public void setCreditStatusId(String creditStatusId) {
            CreditStatusId = creditStatusId;
        }

        public String getDisplayId() {
            return DisplayId;
        }

        public void setDisplayId(String displayId) {
            DisplayId = displayId;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getFax() {
            return Fax;
        }

        public void setFax(String fax) {
            Fax = fax;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getFlag() {
            return Flag;
        }

        public void setFlag(String flag) {
            Flag = flag;
        }

        public String getInvoiceNo() {
            return InvoiceNo;
        }

        public void setInvoiceNo(String invoiceNo) {
            InvoiceNo = invoiceNo;
        }

        public String getIsActive() {
            return IsActive;
        }

        public void setIsActive(String isActive) {
            IsActive = isActive;
        }

        public String getIsBilling() {
            return IsBilling;
        }

        public void setIsBilling(String isBilling) {
            IsBilling = isBilling;
        }

        public String getIsCompanyContact() {
            return IsCompanyContact;
        }

        public void setIsCompanyContact(String isCompanyContact) {
            IsCompanyContact = isCompanyContact;
        }

        public String getIsConsBilling() {
            return IsConsBilling;
        }

        public void setIsConsBilling(String isConsBilling) {
            IsConsBilling = isConsBilling;
        }

        public String getIsCustomPricing() {
            return IsCustomPricing;
        }

        public void setIsCustomPricing(String isCustomPricing) {
            IsCustomPricing = isCustomPricing;
        }

        public String getIsImportant() {
            return IsImportant;
        }

        public void setIsImportant(String isImportant) {
            IsImportant = isImportant;
        }

        public String getIsPrimary() {
            return IsPrimary;
        }

        public void setIsPrimary(String isPrimary) {
            IsPrimary = isPrimary;
        }

        public String getIsSecondary() {
            return IsSecondary;
        }

        public void setIsSecondary(String isSecondary) {
            IsSecondary = isSecondary;
        }

        public String getIsValuationD() {
            return IsValuationD;
        }

        public void setIsValuationD(String isValuationD) {
            IsValuationD = isValuationD;
        }

        public String getIsViewInvoice() {
            return IsViewInvoice;
        }

        public void setIsViewInvoice(String isViewInvoice) {
            IsViewInvoice = isViewInvoice;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getLatitude() {
            return Latitude;
        }

        public void setLatitude(String latitude) {
            Latitude = latitude;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String longitude) {
            Longitude = longitude;
        }

        public int getNotesCount() {
            return NotesCount;
        }

        public void setNotesCount(int notesCount) {
            NotesCount = notesCount;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String number) {
            Number = number;
        }

        public String getOtherPhone() {
            return OtherPhone;
        }

        public void setOtherPhone(String otherPhone) {
            OtherPhone = otherPhone;
        }

        public String getParentBusinessName() {
            return ParentBusinessName;
        }

        public void setParentBusinessName(String parentBusinessName) {
            ParentBusinessName = parentBusinessName;
        }

        public String getParentCompanyId() {
            return ParentCompanyId;
        }

        public void setParentCompanyId(String parentCompanyId) {
            ParentCompanyId = parentCompanyId;
        }

        public String getPayTermId() {
            return PayTermId;
        }

        public void setPayTermId(String payTermId) {
            PayTermId = payTermId;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone) {
            Phone = phone;
        }

        public boolean isPrimaryContact() {
            return PrimaryContact;
        }

        public void setPrimaryContact(boolean primaryContact) {
            PrimaryContact = primaryContact;
        }

        public String getQBListId() {
            return QBListId;
        }

        public void setQBListId(String QBListId) {
            this.QBListId = QBListId;
        }

        public String getRegionId() {
            return RegionId;
        }

        public void setRegionId(String regionId) {
            RegionId = regionId;
        }

        public int getRowId() {
            return RowId;
        }

        public void setRowId(int rowId) {
            RowId = rowId;
        }

        public boolean isShowAll() {
            return ShowAll;
        }

        public void setShowAll(boolean showAll) {
            ShowAll = showAll;
        }

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }

        public int getTotalRecords() {
            return TotalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            TotalRecords = totalRecords;
        }

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getTypeId() {
            return TypeId;
        }

        public void setTypeId(String typeId) {
            TypeId = typeId;
        }

        public String getWebSite() {
            return WebSite;
        }

        public void setWebSite(String webSite) {
            WebSite = webSite;
        }

        public String getWorkPhone() {
            return WorkPhone;
        }

        public void setWorkPhone(String workPhone) {
            WorkPhone = workPhone;
        }

        public String getZipcode() {
            return Zipcode;
        }

        public void setZipcode(String zipcode) {
            Zipcode = zipcode;
        }


    }


}
