package com.inventry.warehouse.search;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inventry.warehouse.R;
import com.inventry.warehouse.businesslayer.model.CustomerSearchModel;
import com.inventry.warehouse.businesslayer.model.SearchResponse;

import java.io.Serializable;
import java.util.List;

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ItemViewHolder> {

    //private List<CustomerSearchModel> searchList;
    private List<SearchResponse.Company> searchList;
    CustomerSearchFragment mInstance;

    private static final String TAG = SearchListAdapter.class.getSimpleName();

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout itemLayout;
        TextView companyNameTxt;
        TextView companyNoTxt;
        TextView firstNameTxt;
        TextView lastNameTxt;
        TextView contactNoTxt;
        TextView locationTxt;


        public ItemViewHolder(View v) {
            super(v);
            itemLayout = (RelativeLayout) v.findViewById(R.id.item_layout);
            companyNameTxt = (TextView) v.findViewById(R.id.tv_company_name);
            companyNoTxt = (TextView) v.findViewById(R.id.tv_company_no);
            firstNameTxt = (TextView) v.findViewById(R.id.txt_first_name);
            lastNameTxt = (TextView) v.findViewById(R.id.txt_last_name);
            contactNoTxt = (TextView) v.findViewById(R.id.tv_contact_no);
            locationTxt = (TextView) v.findViewById(R.id.tv_location);
        }
    }

    public SearchListAdapter(CustomerSearchFragment instance) {
        this.mInstance = instance;
    }

    /*public void add(List<CustomerSearchModel> searchList){
        this.searchList = searchList;
        notifyDataSetChanged();
    }*/
    public void add(List<SearchResponse.Company> searchList) {
        this.searchList = searchList;
        notifyDataSetChanged();
    }


    @Override
    public SearchListAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer_search, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {

        final SearchResponse.Company companyData = searchList.get(position);

        String companyName = mInstance.getString(R.string.company_name) + " - " + cutNull(companyData.getBusinessName());
        String firstName = mInstance.getString(R.string.first_name) + " - " + cutNull(companyData.getFirstName());
        String lastName = mInstance.getString(R.string.last_name) + " - " + cutNull(companyData.getLastName());
        String location = mInstance.getString(R.string.location) + " - " + cutNull(companyData.getCity()) + " " + cutNull(companyData.getState());
        String displayId = mInstance.getString(R.string.company_no) + " - " + cutNull(companyData.getDisplayId());
        holder.companyNameTxt.setText(companyName);
        holder.firstNameTxt.setText(firstName);
        holder.lastNameTxt.setText(lastName);
        holder.locationTxt.setText(location);

        if (companyData.getType().equals("Business")) {
            holder.companyNoTxt.setText(displayId);
        } else /*if(companyData.getType().equals("residential"))*/ {
            holder.contactNoTxt.setText(displayId);
        }

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInstance.postDataToCustomerSearch(companyData);

            }
        });

    }

    @Override
    public int getItemCount() {
        return searchList == null ? 0 : searchList.size();
    }

    private String cutNull(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }
}