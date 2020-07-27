package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacefarming.R;
import com.example.spacefarming.adapter.HistoricoAbastecimentoAdapater;
import com.example.spacefarming.dao.AbastecerDAO;
import com.example.spacefarming.entidades.Abastecer;
import com.example.spacefarming.interfaces.InterfaceCallback;

import java.util.ArrayList;
import java.util.List;


public class HistoricoAbastecimento extends Fragment {
    private RecyclerView recyclerView;
    private String idBotijao;
    private ArrayList<Abastecer> listAbastecimento;

    public HistoricoAbastecimento() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_historico_list, container, false);
        recyclerView = v.findViewById(R.id.rvHist);
        listAbastecimento = new ArrayList<>();
        AbastecerDAO abastecerDAO = new AbastecerDAO();

        abastecerDAO.getById(new InterfaceCallback.ApiCallbackList() {
            @Override
            public void onCallback(List<Object> list) {
                for (Object abastecimento : list) {
                    listAbastecimento.add((Abastecer) abastecimento);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                    recyclerView.setHasFixedSize(true);
                    HistoricoAbastecimentoAdapater adapater = new HistoricoAbastecimentoAdapater(listAbastecimento, getContext());
                    recyclerView.setAdapter(adapater);
                }
            }
        }, this.idBotijao);

        return v;
    }

    public void setIdBotijao(String id) {
        idBotijao = id;
    }
}