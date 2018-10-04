package com.eguic.sportec.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eguic.sportec.Activitys.BeginActivity;
import com.eguic.sportec.Activitys.SplashActivity;
import com.eguic.sportec.R;
import com.facebook.login.LoginManager;


public class LogoutFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_logout, container, false);

        ((BeginActivity) getActivity()).getSupportActionBar().setTitle("Logout");

        new AlertDialog.Builder(this.getContext())
                .setTitle(R.string.logout_tittle)
                .setMessage(R.string.logout_message)
                .setPositiveButton(R.string.logout_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        LoginManager.getInstance().logOut();
                        Intent intent = new Intent(LogoutFragment.this.getContext(), SplashActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.logout_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // user doesn't want to logout
                    }
                })
                .show();

        return view;
    }
}
