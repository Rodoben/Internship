package com.example.ronaldbenjamin.saarthironald;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class ChatMainPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ChatPage chatPage;
    private ProfileFragment profileFragment;
    private PaymentFragment paymentFragment;
    private SettingFragment settingFragment;
    private CameraFragment cameraFragment;
    private NotificationFragment notificationFragment;
    private FrameLayout frameLayoutMain;
    private FrameLayout frameLayoutNotif;
    private boolean ifVisible=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       profileFragment=new ProfileFragment();
       paymentFragment=new PaymentFragment();
       cameraFragment=new CameraFragment();
       chatPage=new ChatPage();
       settingFragment=new SettingFragment();
       notificationFragment=new NotificationFragment();
       replaceFragment(chatPage);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ImageButton menuLeft = (ImageButton) findViewById(R.id.imageButton33);
        ImageButton menuRight = (ImageButton) findViewById(R.id.imageButton30);
        frameLayoutMain=(FrameLayout)findViewById(R.id.MainFrame);
        frameLayoutNotif=(FrameLayout)findViewById(R.id.notif_screen);


        menuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });




        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loadNotif();
            }
        });





        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();





        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.MainFrame,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chat_main_page, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {









            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            replaceFragment(profileFragment);


        } else if (id == R.id.address) {
            startActivity(new Intent(getApplicationContext(),Bluetooh_Activity.class));



        } else if (id == R.id.payment) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));


        } else if (id == R.id.settings) {
            replaceFragment(settingFragment);

        }
        else if(id==R.id.camera){
            replaceFragment(cameraFragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }




    public void loadNotif(){
        if(ifVisible!=true){
            frameLayoutMain.setVisibility(View.GONE);
            frameLayoutNotif.setVisibility(View.VISIBLE);
            FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
            notificationFragment=new NotificationFragment();
            fragmentTransaction.replace(R.id.notif_screen,notificationFragment);
            fragmentTransaction.commit();
        }
        else{
            frameLayoutNotif.setVisibility(View.GONE);
            frameLayoutMain.setVisibility(View.VISIBLE);
        }
        ifVisible=!ifVisible;
    }
}
