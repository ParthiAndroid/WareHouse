package com.inventry.warehouse.search.sidemark;

import android.app.Activity;
import android.util.Log;

import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.model.SearchSidemarkResponse;
import com.inventry.warehouse.businesslayer.model.SidemarkSearchRequest;
import com.inventry.warehouse.util.PrefStorage;

import retrofit2.Call;
import retrofit2.Callback;

public class SidemarkSearchPresenter implements SidemarkSearchInteracter.ActionListener {

    private static String TAG = SidemarkSearchPresenter.class.getSimpleName();

    SidemarkSearchInteracter.ViewInteractor viewInteractor;

    ApiInterface apiService;
    Activity activity;


    public SidemarkSearchPresenter(ApiInterface apiService, Activity activity, SidemarkSearchInteracter.ViewInteractor viewInteractor) {

        this.apiService = apiService;
        this.viewInteractor = viewInteractor;
        this.activity = activity;

    }

    @Override
    public void onSearchClicked(String itemName, String companyId) {

        SidemarkSearchRequest searchRequest;
        SidemarkSearchRequest sidemarkSearchRequest = new SidemarkSearchRequest();
        SidemarkSearchRequest.Grid grid = sidemarkSearchRequest.new Grid("10", "1", "SideMark", "desc");
        SidemarkSearchRequest.Smark smark = sidemarkSearchRequest.new Smark(/*itemName*/"Private",
                /*companyId*/"f664f2ba-4142-e411-93ec-005056a64903");
        searchRequest = new SidemarkSearchRequest(grid, smark);

        String token = PrefStorage.getValue(activity, PrefStorage.LOGGED_KEY);

        Call<SearchSidemarkResponse> call = apiService.getSidemarkSearchData(token, searchRequest);
        call.enqueue(new Callback<SearchSidemarkResponse>() {

            @Override
            public void onResponse(Call<SearchSidemarkResponse> call, retrofit2.Response<SearchSidemarkResponse> response) {
                int statusCode = response.code();
                Log.e(TAG, "Sidemark search STATUS CODE " + statusCode);
                viewInteractor.onSearchFinished(response.body().getSmark());
            }

            @Override
            public void onFailure(Call<SearchSidemarkResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                viewInteractor.onSearchFailure("Failure");
            }
        });

    }


}
