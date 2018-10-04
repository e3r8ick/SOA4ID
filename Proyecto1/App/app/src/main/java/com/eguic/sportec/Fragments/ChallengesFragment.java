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


public class ChallengesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_challenges, container, false);

        ((BeginActivity) getActivity()).getSupportActionBar().setTitle(R.string.nav_challenges);

        Ion.with(getContext())
                .load("http://192.168.42.100:3000/challenges/all")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if (e == null) {
                            Log.d("retos", result.toString());
                            publicChallenges(view, result);
                        } else {
                            Log.d("exceptionn", e.toString());
                        }
                    }
                });
        return view;
    }

    public void publicChallenges(View view, JsonArray result) {
        JsonObject challenge1 = result.get(0).getAsJsonObject();
        JsonObject challenge2 = result.get(1).getAsJsonObject();
        JsonObject challenge3 = result.get(2).getAsJsonObject();
        TextView sport1 = view.findViewById(R.id.challenge_fragment_sport1);
        TextView teamA1 = view.findViewById(R.id.challenge_fragment_teamA1);
        TextView teamB1 = view.findViewById(R.id.challenge_fragment_teamB1);
        TextView sport2 = view.findViewById(R.id.challenge_fragment_sport2);
        TextView teamA2 = view.findViewById(R.id.challenge_fragment_teamA2);
        TextView teamB2 = view.findViewById(R.id.challenge_fragment_teamB2);
        TextView sport3 = view.findViewById(R.id.challenge_fragment_sport3);
        TextView teamA3 = view.findViewById(R.id.challenge_fragment_teamA3);
        TextView teamB3 = view.findViewById(R.id.challenge_fragment_teamB3);

        sport1.setText(challenge1.get("sport").toString().replace("\"", ""));
        sport2.setText(challenge2.get("sport").toString().replace("\"", ""));
        sport3.setText(challenge3.get("sport").toString().replace("\"", ""));
        teamA1.setText(challenge1.get("teamA").toString().replace("\"", ""));
        teamA2.setText(challenge2.get("teamA").toString().replace("\"", ""));
        teamA3.setText(challenge3.get("teamA").toString().replace("\"", ""));
        teamB1.setText(challenge1.get("teamB").toString().replace("\"", ""));
        teamB2.setText(challenge2.get("teamB").toString().replace("\"", ""));
        teamB3.setText(challenge3.get("teamB").toString().replace("\"", ""));

    }
}
