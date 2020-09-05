package com.example.spacefarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.spacefarming.entidades.Botijao;
import com.example.spacefarming.frag.CadastroBotijao;
import com.example.spacefarming.frag.InfoBotijao;
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

       
        Intent it = getIntent();
        if (it.getIntExtra("frag", 0) == 1) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            InfoBotijao infoBotijao = new InfoBotijao();
            infoBotijao.setBotijao((Botijao) it.getSerializableExtra("botijao"));
            ft.add(R.id.main_frame2, infoBotijao);
            ft.addToBackStack(null);
            ft.commit();
        } else if (it.getIntExtra("frag", 0) == 2) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.main_frame2, new CadastroBotijao());
            ft.addToBackStack(null);

            ft.commit();
        }


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ibBack) {
            shouldDisplayHomeUp();
            return true;
        }

        return super.onOptionsItemSelected(item);
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


    public void shouldDisplayHomeUp() {
        System.out.println(getSupportFragmentManager().getBackStackEntryCount());
        if (getSupportFragmentManager().getBackStackEntryCount() >1) {
            getSupportFragmentManager().popBackStack();

        } else {
            finish();

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        getSupportFragmentManager().popBackStack();
        return true;
    }
}