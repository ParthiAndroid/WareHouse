package com.inventry.warehouse.login;

import android.util.Log;
import android.widget.Toast;

import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.db.DBHelper;
import com.inventry.warehouse.businesslayer.model.LoginRequest;
import com.inventry.warehouse.businesslayer.model.LoginResponse;
import com.inventry.warehouse.businesslayer.model.MasterDataRequest;
import com.inventry.warehouse.businesslayer.model.MasterDataResponse;
import com.inventry.warehouse.util.NetworkUtils;
import com.inventry.warehouse.util.PrefStorage;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginPresenter implements LoginInteractor.ActionListener {

    private static String TAG = LoginPresenter.class.getSimpleName();

    LoginInteractor.ViewInteractor viewInteractor;
    LoginActivity activity;
    ApiInterface apiService;

    DBHelper helper;

    public LoginPresenter(ApiInterface apiInterface,
                          LoginActivity activity,
                          LoginInteractor.ViewInteractor viewInteractor) {
        this.apiService = apiInterface;
        this.viewInteractor = viewInteractor;
        this.activity = activity;

        this.helper = new DBHelper(activity);
    }

    @Override
    public void onLoginClick(String user, String pwd) {
        //perform Login and intimate to the view through  view interfac
        //ON successfull login call viewInteractor.onLoginSuccess();
        //On Failure case  viewInteractor.onLoginFailure();
        //viewInteractor.showProgress();
        if (validateData(user, pwd)) {
            viewInteractor.showProgress();
            LoginRequest request = new LoginRequest(user, pwd, PrefStorage.getAuthKey());

            Call<LoginResponse> call = apiService.signInUser(request);
            call.enqueue(new Callback<LoginResponse>() {

                @Override
                public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                    int statusCode = response.code();
                    Log.e(TAG, "STATUS CODE " + statusCode);

                    Log.e(TAG, "LoginMessage " + response.body().getMessage());
                    Log.e(TAG, "LoginKey " + response.body().getLoggedKey());
                    Log.e(TAG, "LoginUserId " + response.body().getUserId());

                    String loggedKey = response.body().getLoggedKey();
                    boolean isSuccess = response.body().getIsSuccess();
                    String message = response.body().getMessage();
                    String userId = response.body().getUserId();
                    if (isSuccess) {
                        PrefStorage.setUserLoginCredentials(activity, userId, loggedKey, true);
                        viewInteractor.onLoginSuccess();
                    } else {
                        viewInteractor.onLoginFailure(message);
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                    viewInteractor.onLoginFailure("Failure");
                }
            });
        }
    }

    @Override
    public void onReceiveMasterData() {

        String userId = PrefStorage.getValue(activity, PrefStorage.USER_ID);
        String token = PrefStorage.getValue(activity, PrefStorage.LOGGED_KEY);

        Call<MasterDataResponse> call = apiService.getMasterData(token, new MasterDataRequest(userId));

        call.enqueue(new Callback<MasterDataResponse>() {
            @Override
            public void onResponse(Call<MasterDataResponse> call, retrofit2.Response<MasterDataResponse> response) {
                helper.insertMasterData(response.body());
                viewInteractor.onFetchMasterDataSuccess();
            }

            @Override
            public void onFailure(Call<MasterDataResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    private boolean validateData(String userName, String pwd) {
        if (!NetworkUtils.isNetworkAvailable(activity)) {
            Toast.makeText(activity, "Network Not Available", Toast.LENGTH_SHORT).show();
            return false;
        } else if (userName.equals("")) {
            viewInteractor.showError();
            activity.usernameEdt.requestFocus();
            return false;
        } else if (pwd.equals("")) {
            viewInteractor.showError();
            activity.pwdEdt.requestFocus();
            return false;
        }

        return true;
    }
}
