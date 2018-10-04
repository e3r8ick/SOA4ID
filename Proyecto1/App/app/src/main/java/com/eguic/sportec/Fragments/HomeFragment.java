package com.eguic.sportec.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eguic.sportec.Activitys.BeginActivity;
import com.eguic.sportec.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        ((BeginActivity) getActivity()).getSupportActionBar().setTitle(R.string.nav_home);

        Ion.with(getContext())
                .load("http://192.168.42.100:3000/news/all")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if (e == null) {
                            Log.d("noticias", result.toString());
                            publicHome(view, result);
                        } else {
                            Log.d("exceptionn", e.toString());
                        }
                    }
                });
        return view;
    }

    public void publicHome(View view, JsonArray result) {
        JsonObject home1 = result.get(0).getAsJsonObject();
        JsonObject home2 = result.get(1).getAsJsonObject();
        JsonObject home3 = result.get(2).getAsJsonObject();
        TextView sport1 = view.findViewById(R.id.home_fragment_sport1);
        TextView title1 = view.findViewById(R.id.home_fragment_title1);
        TextView subtitle1 = view.findViewById(R.id.home_fragment_subtitle1);
        TextView sport2 = view.findViewById(R.id.home_fragment_sport2);
        TextView title2 = view.findViewById(R.id.home_fragment_title2);
        TextView subtitle2 = view.findViewById(R.id.home_fragment_subtitle2);
        TextView sport3 = view.findViewById(R.id.home_fragment_sport3);
        TextView title3 = view.findViewById(R.id.home_fragment_title3);
        TextView subtitle3 = view.findViewById(R.id.home_fragment_subtitle3);

        sport1.setText(home1.get("sport").toString().replace("\"", ""));
        sport1.setTextSize(15);
        sport2.setText(home2.get("sport").toString().replace("\"", ""));
        sport2.setTextSize(15);
        sport3.setText(home3.get("sport").toString().replace("\"", ""));
        sport3.setTextSize(15);
        title1.setText(home1.get("title").toString().replace("\"", ""));
        title1.setTextSize(40);
        title2.setText(home2.get("title").toString().replace("\"", ""));
        title2.setTextSize(40);
        title3.setText(home3.get("title").toString().replace("\"", ""));
        title3.setTextSize(40);
        subtitle1.setText(home1.get("subtitle").toString().replace("\"", ""));
        subtitle2.setText(home2.get("subtitle").toString().replace("\"", ""));
        subtitle3.setText(home3.get("subtitle").toString().replace("\"", ""));
    }
}

