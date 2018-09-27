package com.eguic.sportec.DataManager;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class ApiService {
    private static String HTTP_SERVER = "3010";

    private static String buildEndPoint(String path){
        return HTTP_SERVER + path;
    }

    static void downloadClothes(Context context, FutureCallback<JsonArray> array){
        Ion.with(context)
                .load(buildEndPoint("/clothes"))
                .asJsonArray()
                .setCallback(array);
    }

    public static void uploadClothes(Context context, String cloth, FutureCallback<JsonArray> array){
        Ion.with(context)
                .load(buildEndPoint("/clothes"))
                .setBodyParameter("cloth",cloth)
                .asJsonArray()
                .setCallback(array);

        Log.d("post","posteao akr");
    }

    static void getUser(Context context, FutureCallback<JsonArray> array){
        Ion.with(context)
                .load(buildEndPoint("/clothes"))
                .asJsonArray()
                .setCallback(array);
    }
}
