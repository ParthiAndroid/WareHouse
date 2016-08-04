package com.inventry.warehouse.util;

import android.content.Context;
import android.graphics.Typeface;

import com.inventry.warehouse.App;


public class FontsUtil {

    //private static final Context mContext = App.getContext();

    public static Typeface getCoprgtlFont(Context mContext) {
        return Typeface.createFromAsset(mContext.getAssets(), "fonts/COPRGTL.TTF");
    }

    public static Typeface getLatoRegularFont(Context mContext) {
        return Typeface.createFromAsset(mContext.getAssets(), "fonts/Lato-RegIta.ttf");
    }

    public static Typeface getRobotoBlackFont(Context mContext) {
        return Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto-Black.ttf");
    }

    public static Typeface getRobotoMediumFont(Context mContext) {
        return Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto-Medium.ttf");
    }

    public static Typeface getSeptemberBdFont(Context mContext) {
        return Typeface.createFromAsset(mContext.getAssets(), "fonts/september_bd.ttf");
    }

    public static Typeface getRobotoRegularFont(Context mContext) {
        return Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto-Regular.ttf");
    }
}
