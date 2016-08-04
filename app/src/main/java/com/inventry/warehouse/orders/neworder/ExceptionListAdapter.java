package com.inventry.warehouse.orders.neworder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inventry.warehouse.R;

import java.util.ArrayList;

public class ExceptionListAdapter extends RecyclerView.Adapter<ExceptionListAdapter.ItemViewHolder> {


    ArrayList<ConditionalNote> exceptionList;
    NewOrderActivity activity;

    public ExceptionListAdapter(NewOrderActivity activity) {
        this.activity= activity;
        exceptionList = new ArrayList<>();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout itemLayout;
        TextView tv_exception;
        TextView tv_location;
        ImageView iv_delete;

        public ItemViewHolder(View v) {
            super(v);
            itemLayout = (RelativeLayout) v.findViewById(R.id.item_layout);
            tv_exception = (TextView) v.findViewById(R.id.tv_exception);
            tv_location = (TextView) v.findViewById(R.id.tv_location);
            iv_delete = (AppCompatImageView)v.findViewById(R.id.iv_delete);
        }
    }


    public void add(ConditionalNote exception) {
        exceptionList.add(exception);
        Log.e("List", "Size " + exceptionList.size());
        notifyDataSetChanged();
    }

    public void remove(int position) {
        exceptionList.remove(position);
        Log.e("List", "Size " + exceptionList.size());
        notifyItemRemoved(position);
        activity.removeException(position);
    }


    @Override
    public ExceptionListAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exception, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {

        ConditionalNote exception = exceptionList.get(position);
        holder.tv_exception.setText(exception.getExceptionName());
        holder.tv_location.setText(exception.getLocationName());

        holder.iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exceptionList == null ? 0 : exceptionList.size();
    }

}