package com.inventry.warehouse.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inventry.warehouse.BuildConfig;
import com.inventry.warehouse.R;
import com.inventry.warehouse.base.BaseActivity;
import com.inventry.warehouse.search.sidemark.addsidemark.AddSidmarkActivity;
import com.inventry.warehouse.search.sidemark.SidemarkSearchFragment;

public class SearchActivity extends BaseActivity {

    private static final int CUSTOMER_SEARCH = 1000;
    private static final int SIDE_MARK_SEARCH = 1001;

    Fragment fragment;

    String whereFrom;
    String companyId;

    private static final String TAG = SearchActivity.class.getSimpleName();
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_search);

        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        backBtn = (ImageView) findViewById(R.id.back_btn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        setTitle(BuildConfig.FLAVOR);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (getIntent() != null) {
            whereFrom = getIntent().getStringExtra("wherefrom");
            companyId = getIntent().getStringExtra("companyId");
            if (whereFrom.equals("CustomerSearch")) {
                toolbarTitle.setText(getString(R.string.customer_search));
                changeTab(CUSTOMER_SEARCH);
            } else {
                toolbarTitle.setText(getString(R.string.sidemark));
                changeTab(SIDE_MARK_SEARCH);
            }
        }

        Log.e(TAG, "OnCreate wherefrom " + whereFrom);

    }

    public void changeTab(int i) {

        FragmentManager fm = getSupportFragmentManager();
        switch (i) {
            case SIDE_MARK_SEARCH:
                /*Bundle bundle = new Bundle();
                bundle.putBoolean("deleteAccess", deleteAccess);*/
                fragment = new SidemarkSearchFragment();
                Bundle bundle = new Bundle();
                bundle.putString("companyId", companyId);
                fragment.setArguments(bundle);
                fm.beginTransaction().add(R.id.frame_search, fragment).commit();
                break;
            default:
                fragment = new CustomerSearchFragment();
                fm.beginTransaction().add(R.id.frame_search, fragment).commit();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     
        if (getIntent() != null) {
            whereFrom = getIntent().getStringExtra("wherefrom");
            if (whereFrom.equals("CustomerSearch")) {
                //getMenuInflater().inflate(R.menu.main_menu, menu);
            } else {
                getMenuInflater().inflate(R.menu.add_item, menu);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_add) {
            startActivity(new Intent(this, AddSidmarkActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
