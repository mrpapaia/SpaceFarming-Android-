package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.spacefarming.R;
import com.example.spacefarming.entidades.Botijao;


public class ControleNivel extends Fragment {
    private Botijao botijao;
    private Button btMedirNivel;
    private Button btAbastecerBotijao;
    private TextView tvNivelAtual;


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
        tvNivelAtual = v.findViewById(R.id.tvNivelAtual);
        tvNivelAtual.setText(botijao.getNivelAtual().toString());

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
                MedirNivel medirNivel = new MedirNivel();
                medirNivel.setBotijao(botijao);
                ft.replace(R.id.main_frame2, medirNivel);
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
                AbastecerBotijao abastecerBotijao = new AbastecerBotijao();
                abastecerBotijao.setBotijao(botijao);
                ft.replace(R.id.main_frame2, abastecerBotijao);
                ft.addToBackStack(null);
                ft.commit();
            }
        };
    }

    public void setBotijao(Botijao botijao) {
        this.botijao = botijao;
    }

}