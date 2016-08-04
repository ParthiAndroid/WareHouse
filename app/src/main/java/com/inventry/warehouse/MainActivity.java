package com.inventry.warehouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.inventry.warehouse.base.BaseActivity;
import com.inventry.warehouse.businesslayer.ApiClient;
import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.model.RegisterData;
import com.inventry.warehouse.businesslayer.model.RegisterRequest;
import com.inventry.warehouse.businesslayer.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        /*final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/

        RegisterRequest request = new RegisterRequest(new RegisterData("A","15.1","10003","30000000000004"));


        Call<RegisterResponse> call = apiService.registerDevice(request);
        call.enqueue(new Callback<RegisterResponse>() {

            @Override
            public void onResponse(Call<RegisterResponse> call, retrofit2.Response<RegisterResponse> response) {
                int statusCode = response.code();
                Log.e(TAG,"STATUS CODE "+statusCode);

                Log.e(TAG,"RegisterResponse "+response.body().getAuthKey());
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}