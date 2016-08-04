package com.inventry.warehouse.registerdevice;

import android.util.Log;

import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.model.MasterDataRequest;
import com.inventry.warehouse.businesslayer.model.MasterDataResponse;
import com.inventry.warehouse.businesslayer.model.RegisterData;
import com.inventry.warehouse.businesslayer.model.RegisterRequest;
import com.inventry.warehouse.businesslayer.model.RegisterResponse;
import com.inventry.warehouse.util.PrefStorage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterDevicePresenter implements RegisterDeviceInteracter.ActionListener {

    private String TAG = RegisterDevicePresenter.class.getSimpleName();

    RegisterDeviceInteracter.ViewInteractor viewInteractor;

    public RegisterDevicePresenter(RegisterDeviceInteracter.ViewInteractor viewInteractor) {
        this.viewInteractor = viewInteractor;
    }

    @Override
    public void onRegister(ApiInterface apiService) {

        RegisterRequest request = new RegisterRequest(new RegisterData("A", "15.1", "10003", "30000000000004"));


        Call<RegisterResponse> call = apiService.registerDevice(request);
        call.enqueue(new Callback<RegisterResponse>() {

            @Override
            public void onResponse(Call<RegisterResponse> call, retrofit2.Response<RegisterResponse> response) {
                int statusCode = response.code();
                Log.e(TAG, "STATUS CODE " + statusCode);
                Log.e(TAG, "Message " + response.body().getMessage());
                Log.e(TAG, "RegisterResponse " + response.body().getAuthKey());

                String authKey = response.body().getAuthKey();
                String message = response.body().getMessage();
                boolean isSuccess = response.body().isSuccess();
                if (isSuccess) {
                    if (authKey != null && !authKey.equals("")) {
                        PrefStorage.setAuthKey(authKey);
                        viewInteractor.onRegisterSuccess();
                    }
                } else {
                    viewInteractor.onRegisterFailure(message);
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                viewInteractor.onRegisterFailure("Failed");
            }
        });
    }


}
