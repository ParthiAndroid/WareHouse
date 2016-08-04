package com.inventry.warehouse.businesslayer;

import com.inventry.warehouse.businesslayer.model.LoginRequest;
import com.inventry.warehouse.businesslayer.model.LoginResponse;
import com.inventry.warehouse.businesslayer.model.MasterDataRequest;
import com.inventry.warehouse.businesslayer.model.MasterDataResponse;
import com.inventry.warehouse.businesslayer.model.RegisterRequest;
import com.inventry.warehouse.businesslayer.model.RegisterResponse;
import com.inventry.warehouse.businesslayer.model.SearchRequest;
import com.inventry.warehouse.businesslayer.model.SearchResponse;
import com.inventry.warehouse.businesslayer.model.SearchSidemarkResponse;
import com.inventry.warehouse.businesslayer.model.SidemarkSearchRequest;
import com.inventry.warehouse.orders.neworder.NewOrder;
import com.inventry.warehouse.orders.neworder.NewOrderResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    ////http://74.85.128.67/MobileServices/WarehouseService.svc/WJobSave


    @POST("DeviceRegistration")
    Call<RegisterResponse> registerDevice(@Body RegisterRequest request);

    @POST("ValidateUser")
    Call<LoginResponse> signInUser(@Body LoginRequest request);


    @POST("MobileCustomerSearch")
    Call<SearchResponse> searchCustomer(@Header("Token") String token, @Body SearchRequest request);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST("GetMobileMasterData")
    Call<MasterDataResponse> getMasterData(@Header("Token") String mToken, @Body MasterDataRequest request);

    @POST("MobileSidemarkSearch")
    Call<SearchSidemarkResponse> getSidemarkSearchData(@Header("Token") String mToken, @Body SidemarkSearchRequest request);

    @POST("WJobSave")
    Call<NewOrderResponse> postNewOrderJob(@Header("Token") String mToken, @Body NewOrder request);

}
