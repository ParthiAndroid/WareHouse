package com.inventry.warehouse.orders.neworder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inventry.warehouse.R;

import java.util.ArrayList;

public class ItemAddAdapter extends RecyclerView.Adapter<ItemAddAdapter.ViewHolder> {


    private ArrayList<Item> mItemDetails;
    NewOrderActivity activity;

    public ItemAddAdapter(NewOrderActivity activity) {
        this.activity = activity;
        mItemDetails = new ArrayList<>();
        //this.ItemDeatails= ItemDeatails;
    }

    public void add(Item item) {
        mItemDetails.add(item);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_added_card_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_itemno.setText(mItemDetails.get(position).getJobItemId());
        holder.tv_qtnsize.setText(mItemDetails.get(position).getItemQuantity());
        holder.tv_height.setText(mItemDetails.get(position).getItemH());
        holder.tv_width.setText(mItemDetails.get(position).getItemW());
        holder.tv_depth.setText(mItemDetails.get(position).getItemD());
        holder.tv_depth.setText(mItemDetails.get(position).getItemD());
        for (int i = 0; i < mItemDetails.get(position).getConditionalNotes().size(); i++) {
            holder.tv_Exception.setText("Exception" + mItemDetails.get(position).getConditionalNotes().get(i).getExceptionName() + "\nLoaction" + mItemDetails.get(position).getConditionalNotes().get(i).getLocationName());

        }
    }

    @Override
    public int getItemCount() {
        return mItemDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_itemno, tv_qtnsize, tv_height, tv_width, tv_depth, tv_Exception;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_itemno = (TextView) itemView.findViewById(R.id.tv_itemno);

            tv_qtnsize = (TextView) itemView.findViewById(R.id.tv_qtnsize);
            tv_height = (TextView) itemView.findViewById(R.id.tv_height);
            tv_width = (TextView) itemView.findViewById(R.id.tv_width);
            tv_depth = (TextView) itemView.findViewById(R.id.tv_depth);

            tv_Exception = (TextView) itemView.findViewById(R.id.tv_Exception);

        }
    }
}