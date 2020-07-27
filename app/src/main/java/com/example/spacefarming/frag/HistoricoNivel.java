package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacefarming.R;
import com.example.spacefarming.adapter.HistoricoNivelAdapater;
import com.example.spacefarming.dao.NivelDAO;
import com.example.spacefarming.entidades.Nivel;
import com.example.spacefarming.interfaces.InterfaceCallback;

import java.util.ArrayList;
import java.util.List;


public class HistoricoNivel extends Fragment {
    private RecyclerView recyclerView;
    private String idBotijao;
    private ArrayList<Nivel> listNivel;

    public HistoricoNivel() {
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
        listNivel = new ArrayList<>();
        NivelDAO nivelDAO = new NivelDAO();

        nivelDAO.getById(new InterfaceCallback.ApiCallbackList() {
            @Override
            public void onCallback(List<Object> list) {
                for (Object nivel : list) {
                    listNivel.add((Nivel) nivel);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                    recyclerView.setHasFixedSize(true);
                    HistoricoNivelAdapater adapater = new HistoricoNivelAdapater(listNivel, getContext());
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