package com.ghhitech.smisseal.datamanager;

import android.content.Context;
import android.content.SharedPreferences;

import com.ghhitech.smisseal.utils.ApplicationUtils;

public class DataManager {
    private static final String NAME = "SMIS_SEAL";
    private static final String COOKIE = "cookie";

    public static String getCookie() {
        SharedPreferences preferences = ApplicationUtils.getAppContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return preferences.getString(COOKIE, "");
    }
    public static void putCookie( String value) {
        SharedPreferences preferences = ApplicationUtils.getAppContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
        preferences.edit().putString(COOKIE, value).commit();
    }
}
