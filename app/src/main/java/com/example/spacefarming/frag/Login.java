package com.example.spacefarming.frag;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.spacefarming.MainActivity;
import com.example.spacefarming.R;
import com.example.spacefarming.Tela2;


public class Login extends Fragment {

    Button btLogin;
    CardView cadastrar;
    public Login() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_login, container, false);
        btLogin = v.findViewById(R.id.btLogin);
        cadastrar =v.findViewById(R.id.cadastrar);
        btLogin.setOnClickListener(onClickLogin());
        cadastrar.setOnClickListener(onClickCadastro());
        return v;
    }


    protected View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), MainActivity.class);
                startActivity(it);
            }
        };
    }

    protected View.OnClickListener onClickCadastro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), Tela2.class);
                it.putExtra("frag",3);
                startActivity(it);
            }
        };
    }
}