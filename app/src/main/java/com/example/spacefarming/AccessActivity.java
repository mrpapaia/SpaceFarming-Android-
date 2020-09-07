package com.example.spacefarming;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.spacefarming.frag.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccessActivity extends AppCompatActivity {
    private static String TAG = "access";
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
        if (checklogin() == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framceAccess, new Login());
            ft.commit();
        } else {
            Intent it = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(it);
        }
    }

    public FirebaseUser checklogin() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }


}