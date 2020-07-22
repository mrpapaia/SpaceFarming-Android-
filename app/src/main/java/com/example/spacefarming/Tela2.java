package com.example.spacefarming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;


import com.example.spacefarming.entidades.Botijao;
import com.example.spacefarming.frag.InfoBotijao;
import com.example.spacefarming.frag.CadastroBotijao;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.material.navigation.NavigationView;

public class Tela2 extends AppCompatActivity {
    private Toolbar myToolbar;
    private DrawerLayout dLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        myToolbar = findViewById(R.id.my_toolbar2);
        setSupportActionBar(myToolbar);
        setNavigationDrawer();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent it = getIntent();
        if(it.getIntExtra("frag",0) == 1){

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            InfoBotijao infoBotijao= new InfoBotijao();
            infoBotijao.setBotijao((Botijao) it.getSerializableExtra("botijao"));
            ft.add(R.id.main_frame2, infoBotijao);
            ft.commit();
        }else if(it.getIntExtra("frag",0) == 2){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.main_frame2, new CadastroBotijao());
            ft.commit();
        }


    }

    private void setNavigationDrawer() {
        dLayout = findViewById(R.id.drawer_layout2);

        NavigationView navView = findViewById(R.id.navigation2);
        navView.setItemIconTintList(null);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                return false;
            }
        });
    }

}