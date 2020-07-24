package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.spacefarming.R;
import com.example.spacefarming.dao.BotijaoDAO;
import com.example.spacefarming.entidades.Botijao;
import com.example.spacefarming.interfaces.InterfaceCallback;
import com.google.android.material.textfield.TextInputLayout;


public class CadastroBotijao extends Fragment {
    private TextInputLayout tiIdBotijao;
    private TextInputLayout tiCapacidade;
    private Button cadastrar;
    private Button cancelar;
    private Spinner spCanecas;
    private Spinner spRacks;
    private Spinner spPalhetas;

    public CadastroBotijao() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_cadastro_botijao, container, false);
        cancelar = v.findViewById(R.id.btCancelar);
        cadastrar = v.findViewById(R.id.btCadastrar);
        tiIdBotijao = v.findViewById(R.id.tiIdBotijao);
        tiCapacidade = v.findViewById(R.id.tiCapacidadeBotijao);
        spCanecas = v.findViewById(R.id.spCanecas);
        spRacks = v.findViewById(R.id.spRacks);
        spPalhetas = v.findViewById(R.id.spPalhetas);
        cadastrar.setOnClickListener(cadastrar());
        cancelar.setOnClickListener(cancelar());


        return v;
    }

    protected View.OnClickListener cadastrar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Botijao botijao = new Botijao(tiIdBotijao.getEditText().getText().toString(),
                        Double.parseDouble(tiCapacidade.getEditText().getText().toString()),
                        0.0,
                        Integer.parseInt(spCanecas.getSelectedItem().toString()),
                        Integer.parseInt(spPalhetas.getSelectedItem().toString()),
                        Integer.parseInt((spRacks.getSelectedItem().toString())));
                BotijaoDAO botijaoDAO = new BotijaoDAO();
                botijaoDAO.add(new InterfaceCallback.ApiCallback() {
                    @Override
                    public void onCallback(Object obj) {
                        Toast.makeText(getContext(), " cadastro com sucesso", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    }
                }, botijao);

            }
        };
    }

    protected View.OnClickListener cancelar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        };
    }
}