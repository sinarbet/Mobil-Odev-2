package com.example.a14011063;


import android.content.Context;
import android.content.SharedPreferences;


public class LocalDataManager {
    public static final String MyPREFERENCES = "MySettings";

    public void setSharedPreference(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPref.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public String getSharedPreference(Context context, String key, String defaultValue) {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE).getString(key, defaultValue);
    }

    public void clearSharedPreference(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPref.edit();
        edit.clear();
        edit.commit();
    }

    public void removeSharedPreference(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPref.edit();
        edit.remove(key);
        edit.commit();
    }
}
