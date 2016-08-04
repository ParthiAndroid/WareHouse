package com.inventry.warehouse.orders;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.inventry.warehouse.R;
import com.inventry.warehouse.businesslayer.model.UnSyncedOrder;
import com.inventry.warehouse.util.FontsUtil;

import java.util.HashMap;
import java.util.List;

public class UnSyncedOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;

    private static final String TAG = UnSyncedOrderAdapter.class.getSimpleName();
    List<UnSyncedOrder> itemListData;
    private int lastPosition = -1;
    boolean isChkBoxShow;
    BitmapFactory.Options bmOptions;

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    //private OnLoadMoreListener mOnLoadMoreListener;

    /*public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }*/

    public UnSyncedOrderAdapter(Context context, List<UnSyncedOrder> data) {
        this.mContext = context;
        this.itemListData = data;
        bmOptions = new BitmapFactory.Options();
    }

    public void addAll(List<UnSyncedOrder> data) {
        this.itemListData.addAll(data);
        for (int x = 0; x < data.size(); x++) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            map.put(x, false);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView;
        if (viewType == VIEW_TYPE_ITEM) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_unsynced_order, parent, false);
            return new ItemHolder(itemView);
        } else {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_loadmore, parent, false);
            return new LoadingViewHolder(itemView);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder rawHolder, final int position) {

        if (rawHolder instanceof ItemHolder) {//1
            try {
                ItemHolder holder = (ItemHolder) rawHolder;

                /*String clientName = mContext.getResources().getString(R.string.client) + " " + cutNull(itemListData.get(position).getClientName());
                String barcodeId = mContext.getResources().getString(R.string.barcode_) + " " + cutNull(itemListData.get(position).getBarcodeId());
                String date = mContext.getResources().getString(R.string.date_) + " " + cutNull(itemListData.get(position).getDateAdded());
                String sideMark = mContext.getResources().getString(R.string.side_mark_) + " " + cutNull(itemListData.get(position).getSideMark());

                holder.clientTxt.setText(clientName);
                holder.barcodeTxt.setText(barcodeId);
                holder.dateTxt.setText(date);
                holder.sideMarkTxt.setText(sideMark);*/

                /*holder.clientTxt.setTypeface(FontsUtil.getRobotoMediumFont());
                holder.barcodeTxt.setTypeface(FontsUtil.getRobotoMediumFont());
                holder.dateTxt.setTypeface(FontsUtil.getRobotoMediumFont());
                holder.sideMarkTxt.setTypeface(FontsUtil.getRobotoMediumFont());*/

                /*ViewUtil.setSVGResource(mContext,holder.img_del, R.raw.delete);
                ViewUtil.setSVGResource(mContext,holder.img_sync, R.raw.sync);*/



                String imagePath = itemListData.get(position).getCustomerName();
                Log.e(TAG, "imagePath " + imagePath);

                holder.listItemContainer.setTag(position);
                setAnimation(holder.listItemContainer, position);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (rawHolder instanceof LoadingViewHolder) {
            LoadingViewHolder holder = (LoadingViewHolder) rawHolder;
            holder.progressBar.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return itemListData == null ? 0 : itemListData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemListData.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        CardView listItemContainer;
        ImageView imgSync, imgDelete;
        TextView tv_customer_name,tv_sidemark,tv_Csrname,tv_date;

        public ItemHolder(final View itemView) {
            super(itemView);
            imgDelete = (ImageView)itemView.findViewById(R.id.iv_delete);
            imgSync = (ImageView)itemView.findViewById(R.id.iv_sync);

            tv_customer_name = (TextView)itemView.findViewById(R.id.tv_customer_name);
            tv_sidemark = (TextView)itemView.findViewById(R.id.tv_sidemark);
            tv_Csrname = (TextView)itemView.findViewById(R.id.tv_Csrname);
            tv_date = (TextView)itemView.findViewById(R.id.tv_date);

            tv_customer_name.setTypeface(FontsUtil.getRobotoRegularFont(mContext));
            tv_sidemark.setTypeface(FontsUtil.getRobotoRegularFont(mContext));
            tv_Csrname.setTypeface(FontsUtil.getRobotoRegularFont(mContext));
            tv_date.setTypeface(FontsUtil.getRobotoRegularFont(mContext));
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
        }
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}