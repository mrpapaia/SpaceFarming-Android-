package com.example.spacefarming.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.spacefarming.R;
import com.example.spacefarming.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class Historico extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabAdapter adapter;
    private String idBotijao;

    public Historico() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_historico, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getChildFragmentManager(), 2);
        HistoricoNivel historicoNivel = new HistoricoNivel();
        historicoNivel.setIdBotijao(idBotijao);
        HistoricoAbastecimento historicoAbastecimento = new HistoricoAbastecimento();
        historicoAbastecimento.setIdBotijao(idBotijao);
        adapter.addFragment(historicoNivel, historicoAbastecimento);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }

    public void setIdBotijao(String idBotijao) {
        this.idBotijao = idBotijao;
    }
}