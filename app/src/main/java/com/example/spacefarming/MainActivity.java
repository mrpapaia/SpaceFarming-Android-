package com.example.spacefarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.spacefarming.frag.ListBotijao;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    private  DrawerLayout dLayout;
    private Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dLayout.openDrawer(Gravity.LEFT);
            }
        });
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, new ListBotijao());
        ft.commit();

        setNavigationDrawer();
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.translate) {
            Toast.makeText(getApplicationContext(), "Clicou no Tradutor", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private  void setNavigationDrawer() {
        dLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.navigation);
        navView.setItemIconTintList(null);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if(itemId==R.id.hist){
                    Intent it = new Intent(getApplicationContext(), Tela2.class);
                    it.putExtra("frag",4);
                    startActivity(it);
                    dLayout.closeDrawers();
                }else if(itemId==R.id.botijoes){
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.main_frame, new ListBotijao());
                    ft.commit();
                }else if(itemId==R.id.exit) {
                    finish();
                    FirebaseAuth.getInstance().signOut();


                }
                return false;
            }
        });
    }

    public void cadastrarBotijao(View v){
        Intent it = new Intent(getApplicationContext(), Tela2.class);
        it.putExtra("frag",2);
        startActivity(it);
    }
}