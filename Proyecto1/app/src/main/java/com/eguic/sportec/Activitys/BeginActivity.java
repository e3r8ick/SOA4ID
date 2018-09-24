package com.eguic.sportec.Activitys;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eguic.sportec.Fragments.HomeFragment;
import com.eguic.sportec.Fragments.LogoutFragment;
import com.eguic.sportec.Fragments.ProfileFragment;
import com.eguic.sportec.R;

public class BeginActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    ActionBar mActionBar;


    /**
     * contructor
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mActionBar = getSupportActionBar();
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Log.d("preferencias",preferences.getString("userId",""));

        View headerView = navigationView.getHeaderView(0);
        ImageView drawerImage =  headerView.findViewById(R.id.nav_header_image);
        TextView drawerUsername = headerView.findViewById(R.id.nav_header_name);
        TextView drawerAccount =  headerView.findViewById(R.id.nav_header_email);
        Drawable myImage = getResources().getDrawable(R.drawable.soccer);
        Bitmap bitmap = ((BitmapDrawable) myImage).getBitmap();
        // Scale it to 50 x 50
        Drawable d = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 70, 70, true));
        // Set your new, scaled drawable "d
        drawerImage.setImageDrawable(d);
        drawerUsername.setText("Erick");
        drawerAccount.setText("erick@gmail.com");

        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);

        //First fragment
        setFragment(0);

    }

    /**
     * constructor de menÃº
     *
     * @param menu
     * @return si se crea o no
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.setings, menu);
        return true;
    }

    /***
     * Handdler para los setings
     * @param item
     * @return si se selecciona o no
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handler para el menu lateral
     *
     * @param navigationView
     */
    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.nav_home:
                                menuItem.setChecked(true);
                                setFragment(0);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_profile:
                                menuItem.setChecked(true);
                                setFragment(1);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_news:
                                menuItem.setChecked(true);
                                setFragment(2);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_sports:
                                menuItem.setChecked(true);
                                setFragment(3);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_team_profile:
                                menuItem.setChecked(true);
                                setFragment(4);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_challenges:
                                menuItem.setChecked(true);
                                setFragment(5);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_log_out:
                                menuItem.setChecked(true);
                                setFragment(6);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                        }
                        return true;
                    }
                });
    }

    /***
     * Para cambiar de fragment
     * @param position
     */
    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment inboxFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment, inboxFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                ProfileFragment starredFragment = new ProfileFragment();
                fragmentTransaction.replace(R.id.fragment, starredFragment);
                fragmentTransaction.commit();
                break;
            case 6:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                LogoutFragment logoutFragment = new LogoutFragment();
                fragmentTransaction.replace(R.id.fragment, logoutFragment);
                fragmentTransaction.commit();
                break;
        }
    }
}
