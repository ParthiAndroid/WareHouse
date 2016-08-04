package com.inventry.warehouse.registerdevice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.inventry.warehouse.R;
import com.inventry.warehouse.base.BaseActivity;
import com.inventry.warehouse.login.LoginActivity;
import com.inventry.warehouse.orders.HomeActivity;
import com.inventry.warehouse.orders.neworder.NewOrderActivity;
import com.inventry.warehouse.search.SearchActivity;
import com.inventry.warehouse.util.FontsUtil;
import com.inventry.warehouse.util.NetworkUtils;
import com.inventry.warehouse.util.PrefStorage;

public class SplashActivity extends BaseActivity implements RegisterDeviceInteracter.ViewInteractor {

    RegisterDevicePresenter registerDevicePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView lblTxt = (TextView) findViewById(R.id.txt_lbl);
        TextView classicTxt = (TextView) findViewById(R.id.txt_classic);

        classicTxt.setTypeface(FontsUtil.getCoprgtlFont(this));
        lblTxt.setTypeface(FontsUtil.getLatoRegularFont(this));

        registerDevicePresenter = new RegisterDevicePresenter(this);

        if (NetworkUtils.isNetworkAvailable(this)) {
            registerDevicePresenter.onRegister(apiService);
        } else {
            showToast("Network Not Available");
            if (PrefStorage.isLoggedIn()) {
                navigateToHome();
            } else {
                finish();
            }

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();

        /***
         * sleep screen 2000 sec
         */
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToLogin();
            }
        }, 2000);*/
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * Redirect to Login Screen
     */
    private void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    /**
     * Redirect to Home Screen
     */
    private void navigateToHome() {
        startActivity(new Intent(this, NewOrderActivity.class));
        finish();
    }

    @Override
    public void onRegisterSuccess() {
        navigateToLogin();
    }

    @Override
    public void onRegisterFailure(String error) {
        showToast(error);
        finish();
    }

}

