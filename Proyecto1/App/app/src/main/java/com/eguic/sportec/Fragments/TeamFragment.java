package com.eguic.sportec.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.eguic.sportec.Activitys.BeginActivity;
import com.eguic.sportec.R;
import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;


public class TeamFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_teams, container, false);

        ((BeginActivity) getActivity()).getSupportActionBar().setTitle("Sports");

        Ion.with(getContext())
                .load("http://192.168.42.100:3000/teams/all")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if (e == null) {
                            Log.d("deportes", result.toString());
                            publicSports(view, result);
                        } else {
                            Log.d("exceptionn", e.toString());
                        }
                    }
                });
        return view;
    }

    public void publicSports(View view, JsonArray result) {
        ImageView userPicture00 = view.findViewById(R.id.sport00);
        ImageView userPicture01 = view.findViewById(R.id.sport01);
        ImageView userPicture02 = view.findViewById(R.id.sport02);
        ImageView userPicture10 = view.findViewById(R.id.sport10);
        ImageView userPicture11 = view.findViewById(R.id.sport11);
        ImageView userPicture12 = view.findViewById(R.id.sport12);
        String url1 = result.get(0).getAsJsonObject().get("picture").toString().replace("\"", "");
        String url2 = result.get(1).getAsJsonObject().get("picture").toString().replace("\"", "");
        String url3 = result.get(2).getAsJsonObject().get("picture").toString().replace("\"", "");
        String url4 = result.get(3).getAsJsonObject().get("picture").toString().replace("\"", "");
        String url5 = result.get(4).getAsJsonObject().get("picture").toString().replace("\"", "");
        String url6 = result.get(5).getAsJsonObject().get("picture").toString().replace("\"", "");
        Picasso.get().load(url1).resize(149, 149).into(userPicture00);
        Picasso.get().load(url2).resize(149, 149).into(userPicture01);
        Picasso.get().load(url3).resize(149, 149).into(userPicture02);
        Picasso.get().load(url4).resize(149, 149).into(userPicture10);
        Picasso.get().load(url5).resize(149, 149).into(userPicture11);
        Picasso.get().load(url6).resize(149, 149).into(userPicture12);

    }
}
