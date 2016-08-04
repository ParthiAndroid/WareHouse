package com.inventry.warehouse.util;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inventry.warehouse.R;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class ViewUtil {

    /**
     * @author : -
     * @Created : -
     * @updated : -
     * @LastUpdated : -
     * @details : 1. updates the image with svg resource 2. Keyboard Hide/Show 3. Custom Toast
     */

    public synchronized static void setSVGResource(Context context, ImageView view, int resourceId) {
        if (view != null) {
            view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            SVG svg = SVGParser.getSVGFromResource(context.getResources(), resourceId);
            view.setImageDrawable(svg.createPictureDrawable());
        }

    }

    public static void hideKeyBoard(Activity context) {
        View view = context.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showCustomToast(Activity mContext,String message){
        LayoutInflater inflater = mContext.getLayoutInflater();
        View customToastroot =inflater.inflate(R.layout.custom_toast, null);
        TextView msg_txt = (TextView)customToastroot.findViewById(R.id.msg_txt);
        msg_txt.setText(message);
        Toast customToast = new Toast(mContext);
        customToast.setView(customToastroot);
        customToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.show();
    }
}
