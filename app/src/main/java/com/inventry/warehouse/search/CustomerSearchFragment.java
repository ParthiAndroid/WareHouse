package com.inventry.warehouse.search;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.inventry.warehouse.R;
import com.inventry.warehouse.businesslayer.ApiClient;
import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.db.DBHelper;
import com.inventry.warehouse.businesslayer.model.Category;
import com.inventry.warehouse.businesslayer.model.SearchResponse;
import com.inventry.warehouse.util.NetworkUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerSearchFragment extends Fragment implements CustomerSearchInterater.ViewInteractor, View.OnClickListener {

    Context mContext;
    private static String TAG = CustomerSearchFragment.class.getSimpleName();

    //private SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog mDialog;
    RecyclerView customerDataList;
    SearchListAdapter adapter;
    Spinner searchTypeSpn;
    EditText edt_search_item;

    CustomerSearchPresenter customerSearchPresenter;
    ApiInterface apiService;

    ArrayList<Category> categoryList;

    DBHelper helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
        apiService = ApiClient.getClient().create(ApiInterface.class);
        helper = new DBHelper(getActivity());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_customer_search, container, false);


        customerDataList = (RecyclerView) root.findViewById(R.id.customer_data_list);
        customerDataList.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchTypeSpn = (Spinner) root.findViewById(R.id.spn_search_type);
        edt_search_item = (EditText) root.findViewById(R.id.edt_search_item);

        //ImageView iv_search = (ImageView) root.findViewById(R.id.iv_search);
        RelativeLayout search_lyt = (RelativeLayout) root.findViewById(R.id.search_lyt);
        RelativeLayout close_lyt = (RelativeLayout) root.findViewById(R.id.close_lyt);

        /*swipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);*/

        edt_search_item.setText("Rog0030");

        mDialog = new ProgressDialog(mContext);

        customerSearchPresenter = new CustomerSearchPresenter(apiService, getActivity(), this);

        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */
       /* swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        inventryListArr = helper.getSavedItems();

                                        if (inventryListArr.size() > 0) {
                                            List<CustomerSearchModel> listItems = new ArrayList<>();

                                        adapter = new SearchListAdapter(listItems, mContext);
                                        customerDataList.setAdapter(adapter);
                                        swipeRefreshLayout.setRefreshing(false);
                                        }

                                    }
                                }
        );*/


        adapter = new SearchListAdapter(this);

        //swipeRefreshLayout.setRefreshing(false);
        categoryList = helper.getDictionaryPair("CustomerSearch");
        String[] items = new String[categoryList.size()];
        for (int z = 0; z < categoryList.size(); z++) {
            items[z]= categoryList.get(z).getCategoryKey();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, items);
        searchTypeSpn.setAdapter(adapter);
        search_lyt.setOnClickListener(this);
        close_lyt.setOnClickListener(this);
        //searchTypeSpn.setOnItemSelectedListener(this);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /*@Override
    public void onRefresh() {
        Log.d(TAG, "onRefresh");
        swipeRefreshLayout.setRefreshing(true);

        List<CustomerSearchModel> listItems = new ArrayList<>();
        if(listItems.size()>0) {
            adapter = new SearchListAdapter(listItems, mContext);
            customerDataList.setAdapter(adapter);
        }
        swipeRefreshLayout.setRefreshing(false);
        adapter.notifyDataSetChanged();
    }*/

    @Override
    public void onClick(View v) {
        if (R.id.search_lyt == v.getId()) {

            String itemType = categoryList.get(searchTypeSpn.getSelectedItemPosition()).toString();
            String itemName = edt_search_item.getText().toString();

            if (itemName.equals("")) {
                Toast.makeText(getActivity(), "Enter item to be search", Toast.LENGTH_SHORT).show();
            } else if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                Toast.makeText(getActivity(), "Network not Available", Toast.LENGTH_SHORT).show();
            } else {
                showProgress();
                customerSearchPresenter.onSearchClicked(itemType, itemName);
            }
        }
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
    public void onSearchFinished(List<SearchResponse.Company> searchedContents) {
        hideProgress();
        customerDataList.setAdapter(adapter);
        adapter.add(searchedContents);
    }

    @Override
    public void onSearchFailure(String errorMessage) {
        hideProgress();
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    public void postDataToCustomerSearch(SearchResponse.Company companyData) {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("CompanyData",companyData);
        intent.putExtras(bundle);

        ((SearchActivity) mContext).setResult(Activity.RESULT_OK, intent);
        ((SearchActivity) mContext).finish();
    }

    interface SearchCallBack {
        void onItemClick();
    }
}
