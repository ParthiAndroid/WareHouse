package com.inventry.warehouse.search;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.model.ContactModel;
import com.inventry.warehouse.businesslayer.model.SearchGridData;
import com.inventry.warehouse.businesslayer.model.SearchRequest;
import com.inventry.warehouse.businesslayer.model.SearchResponse;
import com.inventry.warehouse.util.NetworkUtils;
import com.inventry.warehouse.util.PrefStorage;

import retrofit2.Call;
import retrofit2.Callback;

public class CustomerSearchPresenter implements CustomerSearchInterater.ActionListener {

    private static String TAG = CustomerSearchPresenter.class.getSimpleName();

    CustomerSearchInterater.ViewInteractor viewInteractor;
    //CustomerSearchFragment searchFragment;
    Activity activity;
    ApiInterface apiService;

    public CustomerSearchPresenter(ApiInterface apiInterface,Activity activity,
                                   /*CustomerSearchFragment fragment,*/
                                   CustomerSearchInterater.ViewInteractor viewInteractor) {
        this.apiService = apiInterface;
        this.viewInteractor = viewInteractor;
        //this.searchFragment = fragment;
        this.activity = activity;
    }

    @Override
    public void onSearchClicked(String itemType, String itemName) {


        SearchRequest searchRequest = new SearchRequest(
                new ContactModel(itemName),
                new SearchGridData("10", "1", itemType, "desc"));

        String loggedKey = PrefStorage.getValue(activity,PrefStorage.LOGGED_KEY);
        Log.e(TAG, "Logged Key "+loggedKey);

        Call<SearchResponse> call = apiService.searchCustomer(loggedKey, searchRequest);
        call.enqueue(new Callback<SearchResponse>() {

            @Override
            public void onResponse(Call<SearchResponse> call, retrofit2.Response<SearchResponse> response) {
                int statusCode = response.code();
                Log.e(TAG, "STATUS CODE " + statusCode);

                viewInteractor.onSearchFinished(response.body().getCompanyDataItems());
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                viewInteractor.onSearchFailure("Failure");
            }
        });
    }

}
