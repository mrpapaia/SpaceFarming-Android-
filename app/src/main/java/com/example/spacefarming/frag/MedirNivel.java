package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.spacefarming.R;
import com.example.spacefarming.dao.NivelDAO;
import com.example.spacefarming.entidades.Botijao;
import com.example.spacefarming.entidades.Nivel;
import com.example.spacefarming.entidades.Responsavel;
import com.example.spacefarming.interfaces.InterfaceCallback;
import com.google.android.material.textfield.TextInputLayout;


public class MedirNivel extends Fragment {

    private Botijao botijao;
    private TextInputLayout tiNomeResponsavel;
    private TextInputLayout tiTelefoneResponsavel;
    private TextInputLayout tiEmailResponsavel;
    private TextInputLayout tiNivel;
    private TextInputLayout tiData;
    private Button btConfirmar;
    private Button btCancelar;
    private Nivel nivel;
    private Responsavel responsavel;

    public MedirNivel() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_medir_nivel, container, false);
        tiNomeResponsavel = v.findViewById(R.id.tiNomeResponsavel);
        tiTelefoneResponsavel = v.findViewById(R.id.tiTelefoneResponsavel);
        tiEmailResponsavel = v.findViewById(R.id.tiSenha);
        tiNivel = v.findViewById(R.id.tiNivel);
        tiData = v.findViewById(R.id.tiData);
        btConfirmar = v.findViewById(R.id.btConfirmar);
        btCancelar = v.findViewById(R.id.btCancelar);
        btConfirmar.setOnClickListener(confirmarOnClick());
        btCancelar.setOnClickListener(cancelarOnClick());
        return v;
    }

    public void setBotijao(Botijao botijao) {
        this.botijao = botijao;
    }

    protected View.OnClickListener confirmarOnClick() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                responsavel = new Responsavel(tiNomeResponsavel.getEditText().getText().toString(),
                        tiTelefoneResponsavel.getEditText().getText().toString(),
                        tiEmailResponsavel.getEditText().getText().toString());
                nivel = new Nivel(Double.parseDouble(tiNivel.getEditText().getText().toString()),
                        tiData.getEditText().getText().toString(), responsavel, botijao.getId());
                NivelDAO nivelDAO = new NivelDAO();
                nivelDAO.add(new InterfaceCallback.ApiCallback() {
                    @Override
                    public void onCallback(Object obj) {
                        Toast.makeText(getContext(), " cadastro com sucesso", Toast.LENGTH_SHORT).show();
                        getParentFragmentManager().popBackStack();
                    }
                }, nivel);
            }
        };
    }

    protected View.OnClickListener cancelarOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        };
    }

}