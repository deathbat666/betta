package com.example.pc.betta;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.example.pc.betta.FragmentCocina.Fragment_Cocina;
import com.example.pc.betta.FragmentFirstCuarto.FragmentFirst;
import com.example.pc.betta.FragmentGaraje.Fragment_Garaje;
import com.example.pc.betta.FragmentHome_Master.FragmentHome;
import com.example.pc.betta.FragmentLavanderia.Fragment_Lavanderia;
import com.example.pc.betta.FragmentPatio.Fragment_Patio;
import com.example.pc.betta.FragmentSala.Fragment_Sala;
import com.example.pc.betta.FragmentSecondCuarto.FragmentSecond;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener,
        FragmentHome.OnFragmentInteractionListener, FragmentFirst.OnFragmentInteractionListener, FragmentSecond.OnFragmentInteractionListener,
        Fragment_Cocina.OnFragmentInteractionListener,Fragment_Sala.OnFragmentInteractionListener, Fragment_Lavanderia.OnFragmentInteractionListener,
        Fragment_Patio.OnFragmentInteractionListener,Fragment_Garaje.OnFragmentInteractionListener
{

    private DrawerLayout drawerLayout;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

            drawerLayout = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = findViewById(R.id.navigation_view);
            navigationView.setNavigationItemSelectedListener(this);

            MenuItem menuItem = navigationView.getMenu().getItem(0);
            onNavigationItemSelected(menuItem);
            menuItem.setChecked(true);

            drawerLayout.addDrawerListener(this);

            View header = navigationView.getHeaderView(0);
            header.findViewById(R.id.header_title).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, getString(R.string.title_click),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        boolean FragmentTransicion=false;
        Fragment fragment=null;
        switch (menuItem.getItemId()) {
            case R.id.master:
                fragment=new FragmentHome();
                FragmentTransicion=true;
                break;
            case R.id.hijo:
                fragment=new FragmentFirst();
                FragmentTransicion=true;
                break;
            case R.id.invitado:
                fragment= new FragmentSecond();
                FragmentTransicion=true;
                break;
            case R.id.cocina:
                fragment= new Fragment_Cocina();
                FragmentTransicion=true;
                break;
            case R.id.sala:
                fragment= new Fragment_Sala();
                FragmentTransicion=true;
                break;
            case R.id.lavanderia:
                fragment= new Fragment_Lavanderia();
                FragmentTransicion=true;
                break;
            case R.id.garaje:
                fragment= new Fragment_Garaje();
                FragmentTransicion=true;
                break;
            case R.id.patio:
                fragment= new Fragment_Patio();
                FragmentTransicion=true;
                break;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }
        if(FragmentTransicion){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.home_content,fragment)
                    .commit();
            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //el drawer se ha abierto completamente
        Toast.makeText(this, getString(R.string.navigation_drawer_open),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        //el drawer se ha cerrado completamente
    }

    @Override
    public void onDrawerStateChanged(int i) {
        //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/


}
