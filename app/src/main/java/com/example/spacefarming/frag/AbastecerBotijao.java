package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.spacefarming.R;
import com.example.spacefarming.dao.AbastecerDAO;
import com.example.spacefarming.dao.NivelDAO;
import com.example.spacefarming.entidades.Abastecer;
import com.example.spacefarming.entidades.Botijao;
import com.example.spacefarming.entidades.Fornecedor;
import com.example.spacefarming.entidades.Nivel;
import com.example.spacefarming.entidades.Responsavel;
import com.example.spacefarming.interfaces.InterfaceCallback;
import com.google.android.material.textfield.TextInputLayout;


public class AbastecerBotijao extends Fragment {
    private Botijao botijao;
    private TextInputLayout tiNomeResponsavel;
    private TextInputLayout tiTelefoneResponsavel;
    private TextInputLayout tiEmailResponsavel;
    private TextInputLayout tiNivel;
    private TextInputLayout tiData;
    private TextInputLayout tiNomeFornecedor;
    private TextInputLayout tiTelefoneFornecedor;
    private TextInputLayout tiEnderecoFornecedor;
    private TextInputLayout tiPreco;
    private Button btConfirmar;
    private Button btCancelar;
    private Nivel nivel;
    private Responsavel responsavel;
    private Abastecer abastecer;
    private Fornecedor fornecedor;

    public AbastecerBotijao() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_abaster_botijao, container, false);
        tiNomeResponsavel = v.findViewById(R.id.tiNomeResponsavel);
        tiTelefoneResponsavel = v.findViewById(R.id.tiTelefoneResponsavel);
        tiEmailResponsavel = v.findViewById(R.id.tiSenha);
        tiNomeFornecedor = v.findViewById(R.id.tiNomeFornecedor);
        tiTelefoneFornecedor = v.findViewById(R.id.tiTelefoneFornecedor);
        tiEnderecoFornecedor = v.findViewById(R.id.tiEnderecoFornecedor);
        tiPreco = v.findViewById(R.id.tiPreco);
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
                fornecedor = new Fornecedor(tiNomeFornecedor.getEditText().toString(),
                        tiTelefoneFornecedor.getEditText().getText().toString(),
                        tiEnderecoFornecedor.getEditText().getText().toString());
                nivel = new Nivel(Double.parseDouble(tiNivel.getEditText().getText().toString()),
                        tiData.getEditText().getText().toString(), responsavel, botijao.getId());
                abastecer = new Abastecer(fornecedor, botijao.getNivelAtual(),
                        Double.parseDouble(tiNivel.getEditText().getText().toString()),
                        Double.parseDouble(tiPreco.getEditText().getText().toString()),
                        tiData.getEditText().getText().toString(),
                        responsavel, botijao.getId());
                NivelDAO nivelDAO = new NivelDAO();
                nivelDAO.add(new InterfaceCallback.ApiCallback() {
                    @Override
                    public void onCallback(Object obj) {
                    }
                }, nivel);
                AbastecerDAO abastecerDAO = new AbastecerDAO();
                abastecerDAO.add(new InterfaceCallback.ApiCallback() {
                    @Override
                    public void onCallback(Object obj) {
                        Toast.makeText(getContext(), " sucesso", Toast.LENGTH_SHORT).show();
                        getParentFragmentManager().popBackStack();
                    }
                }, abastecer);
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