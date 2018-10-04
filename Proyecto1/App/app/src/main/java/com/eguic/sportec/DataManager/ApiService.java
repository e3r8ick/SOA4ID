package com.eguic.sportec.DataManager;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class ApiService {
    private static String HTTP_SERVER = "192.168.1.11";
    private static String HTTP_PORT = "3000";
    private static String HTTP_PROTOCOL = "http";

    private static String buildEndPoint(String path) {
        return HTTP_PROTOCOL + "://" + HTTP_SERVER + ":" + HTTP_PORT + path;
    }

    static void downloadClothes(Context context, FutureCallback<JsonArray> array) {
        Ion.with(context)
                .load(buildEndPoint("/clothes"))
                .asJsonArray()
                .setCallback(array);
    }

    public static void uploadClothes(Context context, String cloth, FutureCallback<JsonArray> array) {
        Ion.with(context)
                .load(buildEndPoint("/clothes"))
                .setBodyParameter("cloth", cloth)
                .asJsonArray()
                .setCallback(array);

        Log.d("post", "posteao akr");
    }

    public static void getUser(Context context, String email) {
        Ion.with(context)
                .load("http://192.168.1.11:3000/user?email=" + email)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if (e == null) {
                            Log.d("estasi", result.toString());
                            UserInfo.saveUserInfo(result.getAsJsonObject().get("id").toString(),
                                    result.getAsJsonObject().get("name").toString(),
                                    "",
                                    result.getAsJsonObject().get("email").toString());
                            Log.d("estasi2", result.toString());
                        } else {
                            Log.d("exceptionn", e.toString());
                        }
                    }
                });

    }
}
