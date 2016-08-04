package com.inventry.warehouse.search.sidemark;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inventry.warehouse.BuildConfig;
import com.inventry.warehouse.R;
import com.inventry.warehouse.businesslayer.model.SearchSidemarkResponse;

import java.util.List;

public class SidemarkSearchAdapter extends RecyclerView.Adapter<SidemarkSearchAdapter.ViewHolder> {

    private List<SearchSidemarkResponse.Smark> searchedContents;
    SidemarkSearchFragment mInstance;
    

    public SidemarkSearchAdapter(SidemarkSearchFragment mInstance, List<SearchSidemarkResponse.Smark> searchedContents) {
        this.searchedContents = searchedContents;
        this.mInstance = mInstance;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sidemark_search, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv_smarkname.setText("Smark Name -" + cutNull(searchedContents.get(position).getSmarkName()));
        holder.tv_storagetype.setText("Storage Type - " + cutNull(searchedContents.get(position).getStorageType()));
        holder.tv_pricing.setText("Pricing -" + cutNull(searchedContents.get(position).getPricingValue()));
        holder.tv_transitvalue.setText("Transit Value -" + cutNull(searchedContents.get(position).getReceivingVal()));
        holder.tv_storagevalu.setText("Storage Value -" + cutNull(searchedContents.get(position).getStorageDeliveryVal()));

        holder.container_sidemark_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInstance.postDataToSidemarkSearch(searchedContents.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return searchedContents.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_smarkname, tv_storagetype, tv_pricing, tv_transitvalue, tv_storagevalu;
        CardView container_sidemark_search;
        public ViewHolder(View itemView) {
            super(itemView);

            container_sidemark_search = (CardView)itemView.findViewById(R.id.container_sidemark_search);
            tv_smarkname = (TextView) itemView.findViewById(R.id.tv_smarkname);
            tv_storagetype = (TextView) itemView.findViewById(R.id.tv_storagetype);
            tv_pricing = (TextView) itemView.findViewById(R.id.tv_pricing);
            tv_transitvalue = (TextView) itemView.findViewById(R.id.tv_transitvalue);
            tv_storagevalu = (TextView) itemView.findViewById(R.id.tv_storagevalu);

        }
    }

    private String cutNull(String str) {
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        return str;
    }

}
