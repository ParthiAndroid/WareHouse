package com.inventry.warehouse.login;

import com.inventry.warehouse.businesslayer.ApiInterface;

public interface LoginInteractor {

    interface ViewInteractor {

        void showProgress();

        void hideProgress();

        void showError();

        void onLoginSuccess();

        void onLoginFailure(String errorMessage);

        void onFetchMasterDataSuccess();

        void onFetchMasterDataFailure(String errorMessage);

    }

    interface ActionListener {
        void onLoginClick(String name, String pwd);

        void onReceiveMasterData();
    }
}
