package com.inventry.warehouse.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefStorage implements AppConstants {

    static SharedPreferences sp;

    public static String EMAIL_ID = "emailId";
    private static String PWD = "pwd";
    public static String USER_ID = "userId";
    private static String AUTH_KEY = "authkey";
    public static String LOGGED_KEY = "loggedKey";
    public static String IS_MASTER_DATA_ADDED = "IsMasterDataAdded";
    public static String IS_LOGGED_IN = "IsLoggedIn";


    public static void init(Context context){
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setUserLoginCredentials(Context context,
                                               /*String eMail,
                                               String pwd,*/
                                               String userId,
                                               String loggedKey, boolean isLoggedIn) {
        //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        //sp.edit().putString(EMAIL_ID, eMail).apply();
        //sp.edit().putString(PWD, pwd).apply();
        sp.edit().putString(USER_ID, userId).apply();
        sp.edit().putString(LOGGED_KEY, loggedKey).apply();
        sp.edit().putBoolean(IS_LOGGED_IN, isLoggedIn);

    }

    public static boolean isLoggedIn() {
        return sp.getBoolean(IS_LOGGED_IN, false);
    }

    public static void setAuthKey(String authKey) {
        sp.edit().putString(AUTH_KEY, authKey).apply();
    }

    public static String getAuthKey() {
        return sp.getString(AUTH_KEY, "");
    }

    public static void setIsMasterDataAdded(boolean isAdded) {
        sp.edit().putBoolean(IS_MASTER_DATA_ADDED, isAdded).apply();
    }

    public static boolean IsMasterDataAlreadyAdded() {
        return sp.getBoolean(IS_MASTER_DATA_ADDED, false);
    }

    public static String getValue(Context context, String key) {
        return sp.getString(key, EMPTY);
    }

    /*public static void setUserSessionCredentials(Context context,
                                                 String eMail,
                                                 String pwd,
                                                 String userId,
                                                 boolean isLoggedIn) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putString(_EMAIL_ID, eMail).apply();
        sp.edit().putString(_PWD, pwd).apply();
        sp.edit().putString(__USER_ID, userId).apply();
        sp.edit().putBoolean(IS_LOGGED_IN, isLoggedIn).apply();

    }*/


    /*public void setGCMToken(Context mRegistrationIntentService, String tokens) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mRegistrationIntentService);
        sp.edit().putString(mToken, tokens).apply();

    }

    public static String getGCMToken(Context registerActivity) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(registerActivity);
        return sp.getString(mToken, "");
    }

    public static String getValue(Context context, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getString(key, EMPTY);
    }

    public static boolean isLoggedIn(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(IS_LOGGED_IN, false);
    }

    public static void setContinuityStatus(Context context, boolean isContiniutyInitiated) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(IS_CONTINUITY_INITIATED, isContiniutyInitiated).apply();
    }

    public static void setUserType(Context context, String type) {
        if (type == null)
            type = "trail";
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putString(USER_SESSION_STATUS, type).apply();
    }


    public static boolean isContinuityInitiated(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(IS_CONTINUITY_INITIATED, false);
    }

    public static void clearAllPreferences(Context context) {
        SharedPreferences.Editor rem = PreferenceManager.getDefaultSharedPreferences(context).edit();
        rem.clear();
        rem.apply();
    }

    public static void setCurrentLocale(Context context, String locale) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putString(LOCALE, locale).apply();
    }

    public static String getCurrentLocale(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getString(LOCALE, "en");
    }*/
}
