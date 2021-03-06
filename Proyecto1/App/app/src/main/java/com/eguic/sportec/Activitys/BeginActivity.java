package com.eguic.sportec.Activitys;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eguic.sportec.Fragments.ChallengesFragment;
import com.eguic.sportec.Fragments.HomeFragment;
import com.eguic.sportec.Fragments.LogoutFragment;
import com.eguic.sportec.Fragments.NewsFragment;
import com.eguic.sportec.Fragments.ProfileFragment;
import com.eguic.sportec.Fragments.SportsFragment;
import com.eguic.sportec.Fragments.TeamFragment;
import com.eguic.sportec.R;
import com.squareup.picasso.Picasso;

public class BeginActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    Toolbar mToolbar;
    ActionBar mActionBar;

    private static final int HOME_FRAGMENT_ID = 0;


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

        SharedPreferences prefs = LoadPreferences();

        View headerView = navigationView.getHeaderView(0);
        ImageView drawerImage =  headerView.findViewById(R.id.nav_header_image);
        TextView drawerUsername = headerView.findViewById(R.id.nav_header_name);
        TextView drawerAccount =  headerView.findViewById(R.id.nav_header_email);
        //imagen del eprfil
        Picasso.get().load(prefs.getString("fb_profileURL", null)).into(drawerImage);
        //setea los valores de face
        drawerUsername.setText(prefs.getString("fb_first_name", null)+ " "+  prefs.getString("fb_last_name", null));
        drawerAccount.setText(prefs.getString("fb_email", null));

        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);

        setFragment(HOME_FRAGMENT_ID);
    }

    private SharedPreferences LoadPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
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
                                setFragment(HOME_FRAGMENT_ID);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_profile:
                                menuItem.setChecked(true);
                                setFragment(1);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_news:
                                menuItem.setChecked(true);
                                setFragment(2);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_sports:
                                menuItem.setChecked(true);
                                setFragment(3);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_team_profile:
                                menuItem.setChecked(true);
                                setFragment(4);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_challenges:
                                menuItem.setChecked(true);
                                setFragment(5);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                break;
                            case R.id.nav_log_out:
                                menuItem.setChecked(true);
                                setFragment(6);
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                break;
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
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new ProfileFragment();
                break;
            case 2:
                fragment = new NewsFragment();
                break;
            case 3:
                fragment = new SportsFragment();
                break;
            case 4:
                fragment = new TeamFragment();
                break;
            case 5:
                fragment = new ChallengesFragment();
                break;
            case 6:
                fragment = new LogoutFragment();
                break;
        }

        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();

    }
}
