package com.inventry.warehouse.orders.neworder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inventry.warehouse.BuildConfig;
import com.inventry.warehouse.R;
import com.inventry.warehouse.base.BaseActivity;
import com.inventry.warehouse.businesslayer.model.SearchResponse;
import com.inventry.warehouse.search.SearchActivity;

public class ViewCustomerDetailsActivity extends BaseActivity implements View.OnClickListener {

    ImageView iv_search_customer;

    TextView txt_first_name, txt_last_name, txt_company_name, txt_phone_no, txt_address, txt_zipcode, txt_city, txt_state;
    Button btn_continue;
    CheckBox chkbox_origin;

    private static final String TAG = ViewCustomerDetailsActivity.class.getSimpleName();

    boolean isFilled = false;

    SearchResponse.Company customerData;
    LinearLayout lyt_customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);

        iv_search_customer = (ImageView) findViewById(R.id.iv_search_customer);
        txt_first_name = (TextView) findViewById(R.id.txt_first_name);
        txt_last_name = (TextView) findViewById(R.id.txt_last_name);
        txt_company_name = (TextView) findViewById(R.id.txt_company_name);
        txt_phone_no = (TextView) findViewById(R.id.txt_phone_no);
        txt_address = (TextView) findViewById(R.id.txt_address);
        txt_zipcode = (TextView) findViewById(R.id.txt_zipcode);
        txt_city = (TextView) findViewById(R.id.txt_city);
        txt_state = (TextView) findViewById(R.id.txt_state);

        lyt_customer = (LinearLayout) findViewById(R.id.lyt_customer);

        btn_continue = (Button) findViewById(R.id.btn_continue);
        chkbox_origin = (CheckBox) findViewById(R.id.chkbox_origin);

        TextView title = (TextView) findViewById(R.id.toolbar_title);
        String orderId = getIntent().getStringExtra("order_id");

        title.setText(orderId);

        iv_search_customer.setOnClickListener(this);
        btn_continue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch (v.getId()) {

            case R.id.iv_search_customer:
                intent = new Intent(ViewCustomerDetailsActivity.this, SearchActivity.class);
                intent.putExtra("wherefrom", "CustomerSearch");
                startActivityForResult(intent, 1000);
                break;

            case R.id.btn_continue:

                if (isFilled) {
                    intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("CompanyData", customerData);
                    bundle.putBoolean("copyToOrgin", chkbox_origin.isChecked());
                    intent.putExtras(bundle);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }

                break;

            case R.id.lyt_customer:
                finish();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {

            Bundle bundle = data.getExtras();
            customerData = (SearchResponse.Company) bundle.getSerializable("CompanyData");
            showCustomerData();
        }
    }

    private void showCustomerData() {

        if (customerData == null) {
            return;
        }

        isFilled = true;
        txt_first_name.setText(cutNull(customerData.getFirstName()));
        txt_last_name.setText(cutNull(customerData.getLastName()));
        txt_company_name.setText(cutNull(customerData.getBusinessName()));
        txt_phone_no.setText(cutNull(customerData.getPhone()));
        txt_address.setText(cutNull(customerData.getAddress1()));
        txt_zipcode.setText(cutNull(customerData.getZipcode()));
        txt_city.setText(cutNull(customerData.getCity()));
        txt_state.setText(cutNull(customerData.getState()));
    }

    private String cutNull(String str) {
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        return str;
    }
}
