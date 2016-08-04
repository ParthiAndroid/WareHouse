package com.inventry.warehouse;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.inventry.warehouse.businesslayer.db.DBHelper;
import com.inventry.warehouse.util.PrefStorage;

public class App extends Application {

    static App instance;
    static Context mContext;

    DBHelper helper;

    public static App getInstance() {
        return instance;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
        instance = this;

        PrefStorage.init(this);

        helper = new DBHelper(this);
    }

    public String getUserName() {
        return PrefStorage.getValue(mContext, PrefStorage.EMAIL_ID);
    }

    public static class PrintLog {

        public static void i(String tag, Object msg) {
            if (BuildConfig.DEBUG)
                if (isDebugMode())
                    Log.i(tag, "==>" + msg);
        }

        public static void d(String tag, Object msg) {
            if (BuildConfig.DEBUG)
                if (isDebugMode())
                    Log.d(tag, "==>" + msg);
        }

        public static void e(String tag, Object msg) {
            if (BuildConfig.DEBUG)
                if (isDebugMode())
                    Log.e(tag, "==>" + msg);
        }

        public static void v(String tag, Object msg) {
            if (BuildConfig.DEBUG)
                if (isDebugMode())
                    Log.v(tag, "==>" + msg);
        }

        public static void w(String tag, Object msg) {
            if (BuildConfig.DEBUG)
                if (isDebugMode())
                    Log.w(tag, "==>" + msg);
        }

    }

    public static boolean isDebugMode() {
        return mContext.getString(R.string.version_type).equals("DebugMode");
    }

}
