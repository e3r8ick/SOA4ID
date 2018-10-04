package com.eguic.sportec.DataManager;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import static com.facebook.FacebookSdk.getApplicationContext;

public class UserInfo {


    public static void saveUserInfo(String id, String first_name, String last_name, String email) {
        SharedPreferences prefs = LoadPreferences();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("fb_id", id);
        editor.putString("fb_first_name", first_name);
        editor.putString("fb_last_name", last_name);
        editor.putString("fb_email", email);
        editor.apply(); // This line is IMPORTANT !!!
        Log.d("userInfo", "Shared Name : " + first_name + "\nLast Name : " + last_name + "\nEmail : " + email);
    }

    private static SharedPreferences LoadPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }
}
