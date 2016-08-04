package com.inventry.warehouse.search.sidemark;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.inventry.warehouse.R;
import com.inventry.warehouse.businesslayer.ApiClient;
import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.model.SearchSidemarkResponse;
import com.inventry.warehouse.search.SearchActivity;

import java.io.Serializable;
import java.util.List;

public class SidemarkSearchFragment extends Fragment implements SidemarkSearchInteracter.ViewInteractor, View.OnClickListener {

    Context mContext;
    private static final String TAG = SidemarkSearchFragment.class.getSimpleName();

    ProgressDialog mDialog;

    RecyclerView Rv_sidemarksearch;

    SidemarkSearchPresenter sidemarkSearch_presenter;

    ImageView iv_search_sidemark;

    SidemarkSearchAdapter SAdapter;
    ApiInterface apiService;
    String companyId;
    EditText edt_search_sidemark;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
        apiService = ApiClient.getClient().create(ApiInterface.class);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sidemark_search, container, false);

        Bundle bundle = getArguments();

        companyId = bundle.getString("companyId");

        Rv_sidemarksearch = (RecyclerView) root.findViewById(R.id.rv_sidemark_search);
        edt_search_sidemark = (EditText)root.findViewById(R.id.edt_search_sidemark);

        Rv_sidemarksearch.setLayoutManager(new LinearLayoutManager(getActivity()));

        mDialog = new ProgressDialog(mContext);
        iv_search_sidemark = (ImageView) root.findViewById(R.id.iv_search_sidemark);
        sidemarkSearch_presenter = new SidemarkSearchPresenter(apiService, getActivity(), this);

        iv_search_sidemark.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.iv_search_sidemark:
                String searchContent = edt_search_sidemark.getText().toString();
                showProgress();
                sidemarkSearch_presenter.onSearchClicked(searchContent, companyId);
                break;
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
            if (mDialog.isShowing())
                mDialog.dismiss();
    }

    @Override
    public void showError() {

    }

    @Override
    public void onSearchFinished(List<SearchSidemarkResponse.Smark> searchedContents) {
        SAdapter = new SidemarkSearchAdapter(SidemarkSearchFragment.this, searchedContents);
        Rv_sidemarksearch.setAdapter(SAdapter);
        SAdapter.notifyDataSetChanged();
        hideProgress();
    }

    @Override
    public void onSearchFailure(String errorMessage) {

        hideProgress();
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }


    public void postDataToSidemarkSearch(SearchSidemarkResponse.Smark searchedContents) {

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SideMark", searchedContents);
        intent.putExtras(bundle);

        ((SearchActivity) mContext).setResult(Activity.RESULT_OK, intent);
        ((SearchActivity) mContext).finish();

    }
}
