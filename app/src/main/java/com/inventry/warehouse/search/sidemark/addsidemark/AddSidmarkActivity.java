package com.inventry.warehouse.search.sidemark.addsidemark;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.inventry.warehouse.R;
import com.inventry.warehouse.base.BaseActivity;
import com.inventry.warehouse.businesslayer.db.DBHelper;
import com.inventry.warehouse.businesslayer.model.Category;

import java.util.ArrayList;

public class AddSidmarkActivity extends BaseActivity {

    DBHelper helper;
    Spinner defaultPricingSpn, storageTypeSpn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sidemark);

        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        toolbarTitle.setText(getString(R.string.add_side_mark));
        storageTypeSpn = (Spinner) findViewById(R.id.spn_storage_type);
        defaultPricingSpn = (Spinner) findViewById(R.id.spn_default_pricing);

        helper = new DBHelper(this);

        ArrayList<Category> storageTypeList = helper.getDictionaryPair("StorageType");
        String[] storageItems = new String[storageTypeList.size()];
        for (int z = 0; z < storageTypeList.size(); z++) {
            storageItems[z] = storageTypeList.get(z).getCategoryKey();
        }

        ArrayList<Category> pricingTypeList = helper.getDictionaryPair("Pricing");
        String[] priceItems = new String[pricingTypeList.size()];
        for (int z = 0; z < pricingTypeList.size(); z++) {
            priceItems[z] = pricingTypeList.get(z).getCategoryKey();
        }

        ArrayAdapter<String> storageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, storageItems);
        ArrayAdapter<String> pricingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, priceItems);

        storageTypeSpn.setAdapter(storageAdapter);
        defaultPricingSpn.setAdapter(pricingAdapter);

    }


}
