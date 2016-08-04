package com.inventry.warehouse.registerdevice;

import com.inventry.warehouse.businesslayer.ApiInterface;

public class RegisterDeviceInteracter {

    interface ViewInteractor {

        void onRegisterSuccess();

        void onRegisterFailure(String errorMessage);

    }

    interface ActionListener {
        void onRegister(ApiInterface apiInterface);
    }
}
