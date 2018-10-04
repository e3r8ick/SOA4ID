package com.eguic.sportec.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eguic.sportec.Activitys.BeginActivity;
import com.eguic.sportec.R;
import com.squareup.picasso.Picasso;


public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ((BeginActivity) getActivity()).getSupportActionBar().setTitle("Profile");

        SharedPreferences prefs = LoadPreferences();

        ImageView userPicture = view.findViewById(R.id.profile_fragment_picture);
        TextView userName = view.findViewById(R.id.profile_fragment_get_name);
        TextView userEmail = view.findViewById(R.id.profile_fragment_get_email);
        TextView userSports = view.findViewById(R.id.profile_fragment_get_sports);
        TextView userTeams = view.findViewById(R.id.profile_fragment_get_teams);
        //imagen del eprfil
        Picasso.get().load(prefs.getString("fb_profileURL", null)).into(userPicture);
        //setea los valores de face
        userName.setText(prefs.getString("fb_first_name", null) + " " + prefs.getString("fb_last_name", null));
        userEmail.setText(prefs.getString("fb_email", null));


        return view;
    }

    private SharedPreferences LoadPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getContext());
    }
}
