package com.inventry.warehouse.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DialogUtils {

    public interface DialogListener {

        void onItemListClicked(Dialog dialog);

        void onAddNewItemClicked(Dialog dialog);

        void onSyncClicked(Dialog dialog);
    }
    
    public interface NoticeDialogListener{
        void onOkClicked(DialogInterface mDialog);
        void onCancelClicked(DialogInterface mDialog);
    }


    /*public static void showDialog(Context context, final DialogListener listener) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.menu_dialog);
        dialog.setCancelable(true);
        LinearLayout item_list_lyt = (LinearLayout) dialog.findViewById(R.id.item_list_lyt);
        LinearLayout add_item_lyt = (LinearLayout) dialog.findViewById(R.id.add_item_lyt);
        LinearLayout sync_lyt = (LinearLayout) dialog.findViewById(R.id.sync_lyt);
        ImageView img_item_list = (ImageView) dialog.findViewById(R.id.img_item_list);
        ImageView img_add_new_item = (ImageView) dialog.findViewById(R.id.img_add_new_item);
        ImageView img_sync = (ImageView) dialog.findViewById(R.id.img_sync);

        ViewUtil.setSVGResource(context, img_item_list, R.raw.item_list);
        ViewUtil.setSVGResource(context, img_add_new_item, R.raw.add_item);
        ViewUtil.setSVGResource(context, img_sync, R.raw.sync);

        TextView tv1,tv2,tv3;
        tv1 = (TextView)dialog.findViewById(R.id.text1);
        tv2 = (TextView)dialog.findViewById(R.id.text2);
        tv3 = (TextView)dialog.findViewById(R.id.text3);

        tv1.setTypeface(FontsUtil.getRobotoMediumFont());
        tv2.setTypeface(FontsUtil.getRobotoMediumFont());
        tv3.setTypeface(FontsUtil.getRobotoMediumFont());

        dialog.show();

        item_list_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemListClicked(dialog);
            }
        });

        add_item_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddNewItemClicked(dialog);
            }
        });

        sync_lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSyncClicked(dialog);
            }
        });
    }*/


    public static void showAlertDialog(Context mContext, String msg, boolean isCancelNeed, final NoticeDialogListener listener) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);

        // set dialog message
        alertDialogBuilder.setMessage(msg)
                .setCancelable(false);
        alertDialogBuilder.setNegativeButton("Retry Later",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onOkClicked(dialog);
                    }
                });
        if(isCancelNeed){
            alertDialogBuilder.setPositiveButton(android.R.string.cancel,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            listener.onCancelClicked(dialog);
                        }

                    });
        }
        alertDialogBuilder.show();
    }

}
