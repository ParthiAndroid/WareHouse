package com.inventry.warehouse.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.inventry.warehouse.BuildConfig;
import com.inventry.warehouse.businesslayer.ApiClient;
import com.inventry.warehouse.businesslayer.ApiInterface;

public class BaseActivity extends AppCompatActivity {

    public ApiInterface apiService;
    public String EMPTY = BuildConfig.FLAVOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiService = ApiClient.getClient().create(ApiInterface.class);
    }

    public void showToast(String msg) {
        if (msg != null)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
