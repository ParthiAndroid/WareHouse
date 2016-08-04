package com.inventry.warehouse.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inventry.warehouse.R;
import com.inventry.warehouse.base.BaseActivity;
import com.inventry.warehouse.orders.neworder.NewOrderActivity;
import com.inventry.warehouse.util.FontsUtil;
import com.inventry.warehouse.util.PrefStorage;

public class LoginActivity extends BaseActivity implements LoginInteractor.ViewInteractor, View.OnClickListener {

    LoginPresenter loginPresenter;
    EditText usernameEdt, pwdEdt;
    RelativeLayout loginBtn;
    TextView lblTxt, classicTxt;
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        loginPresenter = new LoginPresenter(apiService, this, this);

        lblTxt = (TextView) findViewById(R.id.txt_lbl);
        classicTxt = (TextView) findViewById(R.id.txt_classic);

        usernameEdt = (EditText) findViewById(R.id.username_edt);
        pwdEdt = (EditText) findViewById(R.id.pwd_edt);
        loginBtn = (RelativeLayout) findViewById(R.id.login_btn_lyt);

        usernameEdt.setText("cbeers");
        pwdEdt.setText("cds059");

        loginBtn.setOnClickListener(this);
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading...");

        //custom fonts
        classicTxt.setTypeface(FontsUtil.getCoprgtlFont(this));
        lblTxt.setTypeface(FontsUtil.getLatoRegularFont(this));
    }

    @Override
    public void showProgress() {
        if (mDialog != null)
            if (!mDialog.isShowing())
                mDialog.show();
    }

    @Override
    public void hideProgress() {
        if (mDialog != null)
            mDialog.dismiss();
    }

    @Override
    public void showError() {

    }

    @Override
    public void onLoginSuccess() {
        if(!PrefStorage.IsMasterDataAlreadyAdded()) {
            loginPresenter.onReceiveMasterData();
        }else{
            showToast("Login success");
            hideProgress();
            startActivity(new Intent(this, NewOrderActivity.class));
            finish();
        }
        //hideProgress();

    }

    @Override
    public void onLoginFailure(String error) {
        showToast("Login Failed : " + error);
        hideProgress();
    }

    @Override
    public void onClick(View v) {
        if (R.id.login_btn_lyt == v.getId()) {
            String userName = usernameEdt.getText().toString().trim();
            String pwd = pwdEdt.getText().toString().trim();
            loginPresenter.onLoginClick(userName, pwd);
        }
    }

    @Override
    public void onFetchMasterDataSuccess() {
        PrefStorage.setIsMasterDataAdded(true);
        showToast("Login success");
        hideProgress();
        startActivity(new Intent(this, NewOrderActivity.class));
        finish();
    }

    @Override
    public void onFetchMasterDataFailure(String errorMessage) {
        showToast("Fetch Master Data Failed : " + errorMessage);
        hideProgress();
    }
}
