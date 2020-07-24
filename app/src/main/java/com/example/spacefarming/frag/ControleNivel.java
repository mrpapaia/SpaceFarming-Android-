package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.spacefarming.R;


public class ControleNivel extends Fragment {
    Button btMedirNivel;
    Button btAbastecerBotijao;


    public ControleNivel() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_controle_nivel, container, false);
        btMedirNivel = v.findViewById(R.id.btMedirNivel);
        btAbastecerBotijao = v.findViewById(R.id.btAbastecer);
        btMedirNivel.setOnClickListener(medirNivelOnClick());
        btAbastecerBotijao.setOnClickListener(abastecerOnClick());
        return v;
    }

    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    protected View.OnClickListener medirNivelOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_frame2, new MedirNivel());
                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }

    protected View.OnClickListener abastecerOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_frame2, new AbastecerBotijao());
                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }
}