package com.example.systemgms.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public Session(Context context){
        //initiate shared preference
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();

    }
    public void setString(String key,String Value){
        editor.putString(key, Value);
        editor.apply();
    }
    public String getString(String key){
        return sharedPreferences.getString(key,"");
    }
}
