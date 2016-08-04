package com.inventry.warehouse.orders.neworder;

import android.app.Activity;

import com.inventry.warehouse.App;
import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.db.DBHelper;
import com.inventry.warehouse.util.PrefStorage;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class NewOrderPresenter implements NewOrderInteracter.ActionListener {


    private static String TAG = NewOrderPresenter.class.getSimpleName();

    NewOrderInteracter.ViewInteractor viewInteractor;
    Activity activity;
    ApiInterface apiService;

    DBHelper helper;

    public NewOrderPresenter(ApiInterface apiInterface,
                             NewOrderActivity activity,
                             NewOrderInteracter.ViewInteractor viewInteractor) {
        this.apiService = apiInterface;
        this.viewInteractor = viewInteractor;
        this.activity = activity;

        this.helper = new DBHelper(activity);
    }


    @Override
    public void onJobPost(NewOrder order) {

        String mToken = PrefStorage.getValue(activity, PrefStorage.LOGGED_KEY);

        /*App.PrintLog.w(TAG, "trfJobId : " + order.getTrfJobId());
        App.PrintLog.w(TAG, "UserId : " + order.getUserId());

        Job mJob = order.getJob();

        App.PrintLog.w(TAG, "JobId : " + mJob.getJobId());
        App.PrintLog.w(TAG, "JobDisplayId : " + mJob.getJobDisplayId());
        App.PrintLog.w(TAG, "IsPuResidence : " + mJob.getIsPuResidence());
        App.PrintLog.w(TAG, "PayTermId : " + mJob.getPayTermId());
        App.PrintLog.w(TAG, "CompanyId : " + mJob.getCompanyId());
        App.PrintLog.w(TAG, "SmarkId : " + mJob.getSmarkId());
        App.PrintLog.w(TAG, "SmarkName : " + mJob.getSmarkName());
        App.PrintLog.w(TAG, "CubicFeet : " + mJob.getCubicFeet());
        App.PrintLog.w(TAG, "PayerId : " + mJob.getPayerId());
        App.PrintLog.w(TAG, "PayerType : " + mJob.getPayerType());
        App.PrintLog.w(TAG, "TotalItems : " + mJob.getTotalItems());
        App.PrintLog.w(TAG, "CreatedBy : " + mJob.getCreatedBy());
        App.PrintLog.w(TAG, "StorageTypeId : " + mJob.getStorageTypeId());
        App.PrintLog.w(TAG, "StorageType : " + mJob.getStorageType());
        App.PrintLog.w(TAG, "PayerContId : " + mJob.getPayerContId());
        App.PrintLog.w(TAG, "isItemChanged : " + mJob.getIsItemChanged());
        App.PrintLog.w(TAG, "OrginName : " + mJob.getOrginName());

        App.PrintLog.w(TAG, "*******************//*/Fright/*//************************");
        Freight mFreight = mJob.getFreight();
        App.PrintLog.w(TAG, "FreightId : " + mFreight.getFreightId());
        App.PrintLog.w(TAG, "JobId : " + mFreight.getJobId());
        App.PrintLog.w(TAG, "CarrierId : " + mFreight.getCarrierId());
        App.PrintLog.w(TAG, "CarrierName : " + mFreight.getCarrierName());
        App.PrintLog.w(TAG, "FreightBillNo : " + mFreight.getFreightBillNo());
        App.PrintLog.w(TAG, "IsFreightBill : " + mFreight.getIsFreightBill());
        App.PrintLog.w(TAG, "IsCollect : " + mFreight.getIsCollect());
        App.PrintLog.w(TAG, "IsPrepaid : " + mFreight.getIsPrepaid());
        App.PrintLog.w(TAG, "FreightAmt : " + mFreight.getFreightAmt());
        App.PrintLog.w(TAG, "Weight : " + mFreight.getWeight());

        App.PrintLog.w(TAG, "*******************//*/Customer/*//************************");

        Customer customer = mJob.getCustomer();
        App.PrintLog.w(TAG, "ContactId : " + customer.getContactId());
        App.PrintLog.w(TAG, "CompanyId : " + customer.getCompanyId());
        App.PrintLog.w(TAG, "AddressId : " + customer.getAddressId());

        App.PrintLog.w(TAG, "*******************//*/Customer/*//************************");

        Pickup pickup = mJob.getPickup();
        App.PrintLog.w(TAG, "ContactId : " + pickup.getContactId());
        App.PrintLog.w(TAG, "CompanyId : " + pickup.getCompanyId());
        App.PrintLog.w(TAG, "AddressId : " + pickup.getAddressId());

        App.PrintLog.w(TAG, "*******************//*/Customer/*//************************");

        Payer payer = mJob.getPayer();
        App.PrintLog.w(TAG, "ContactId : " + payer.getContactId());
        App.PrintLog.w(TAG, "CompanyId : " + payer.getCompanyId());
        App.PrintLog.w(TAG, "AddressId : " + payer.getAddressId());


        App.PrintLog.w(TAG, "*******************//*/Items/*//************************");
        List<Item> listItems = mJob.getItems();
        for (int i = 0; i < listItems.size(); i++) {
            Item item = listItems.get(i);
            App.PrintLog.w(TAG, "*******************//*/Items " + i + " /*//************************");
            App.PrintLog.w(TAG, "JobItemId : " + item.getJobItemId());
            App.PrintLog.w(TAG, "ItemName : " + item.getItemName());
            App.PrintLog.w(TAG, "ItemH : " + item.getItemH());
            App.PrintLog.w(TAG, "ItemW : " + item.getItemW());
            App.PrintLog.w(TAG, "ItemD : " + item.getItemD());
            App.PrintLog.w(TAG, "ItemValue : " + item.getItemValue());
            App.PrintLog.w(TAG, "ItemQuantity : " + item.getItemQuantity());
            App.PrintLog.w(TAG, "ItemCuFt : " + item.getItemCuFt());
            App.PrintLog.w(TAG, "ItemCuFt : " + item.getItemCuFt());
            App.PrintLog.w(TAG, "ItemLbs : " + item.getItemLbs());
            App.PrintLog.w(TAG, "ItemLbs : " + item.getItemLbs());
            App.PrintLog.w(TAG, "BarCode : " + item.getBarCode());
            App.PrintLog.w(TAG, "IsNew : " + item.getIsNew());
            App.PrintLog.w(TAG, "IsCubicOverride : " + item.getIsCubicOverride());
            App.PrintLog.w(TAG, "SeqNo : " + item.getSeqNo());
            App.PrintLog.w(TAG, "SmarkId : " + item.getSmarkId());
            App.PrintLog.w(TAG, "ValuationTypeId : " + item.getValuationTypeId());
            App.PrintLog.w(TAG, "IsQuickAdd : " + item.getIsQuickAdd());
            App.PrintLog.w(TAG, "IsImportantNotes : " + item.getIsImportantNotes());
            App.PrintLog.w(TAG, "IsSqFtOverride : " + item.getIsSqFtOverride());
            App.PrintLog.w(TAG, "IsSqFtOverride : " + item.getIsSqFtOverride());

            App.PrintLog.w(TAG, "*******************//*/Items " + i + " //ConditionalNotes/*//************************");
            List<ConditionalNote> notes = item.getConditionalNotes();
            for (int j = 0; j < notes.size(); j++) {
                App.PrintLog.w(TAG, "*****************//*/Items " + i + " //ConditionalNotes//" + j + "/*//**********************");
                ConditionalNote note = notes.get(j);

                App.PrintLog.w(TAG, "ExceptionId : " + note.getExceptionId());
                App.PrintLog.w(TAG, "ExceptionName : " + note.getExceptionName());
                App.PrintLog.w(TAG, "LocationId : " + note.getLocationId());
                App.PrintLog.w(TAG, "LocationName : " + note.getLocationName());
                App.PrintLog.w(TAG, "Comments : " + note.getComments());
                App.PrintLog.w(TAG, "ConditionalNoteId : " + note.getConditionalNoteId());
            }

            App.PrintLog.w(TAG, "*******************//*/Items " + i + " //TagDetails/*//************************");
            List<TagDetail> tagDetails = item.getTagDetails();

            for (int j = 0; j < tagDetails.size(); j++) {
                App.PrintLog.w(TAG, "*****************//*/Items " + i + " //TagDetails//" + j + "/*//**********************");
                TagDetail tagDetail = tagDetails.get(j);

                App.PrintLog.w(TAG, "TagName : " + tagDetail.getTagName());
                App.PrintLog.w(TAG, "TagId : " + tagDetail.getTagId());
                App.PrintLog.w(TAG, "SeqNo : " + tagDetail.getSeqNo());
                App.PrintLog.w(TAG, "IsNew : " + tagDetail.getIsNew());
            }

        }

        App.PrintLog.w(TAG, "*****************//*/Data Finished/*//**********************");*/


        Call<NewOrderResponse> call = apiService.postNewOrderJob(mToken, order);

        call.enqueue(new Callback<NewOrderResponse>() {
            @Override
            public void onResponse(Call<NewOrderResponse> call, retrofit2.Response<NewOrderResponse> response) {

                String msg = response.body().getMessage();
                if (response.code() == 200 && response.body().isSuccess()) {
                    viewInteractor.onJobPostSuccess(msg);
                } else {
                    viewInteractor.onJobPostFailure(msg);
                }

            }

            @Override
            public void onFailure(Call<NewOrderResponse> call, Throwable t) {
                App.PrintLog.e(TAG, t.toString());
                viewInteractor.onJobPostFailure("Failed");
            }
        });
    }
}