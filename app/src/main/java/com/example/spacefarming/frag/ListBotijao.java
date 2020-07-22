package com.example.spacefarming.frag;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spacefarming.ListBotijaoAdapter;
import com.example.spacefarming.Tela2;
import com.example.spacefarming.R;
import com.example.spacefarming.dao.BotijaoDAO;
import com.example.spacefarming.entidades.Botijao;
import com.example.spacefarming.interfaces.InterfaceCallback;

import java.util.ArrayList;
import java.util.List;


public class ListBotijao extends Fragment {

    private final List<Botijao> listBotijao = new ArrayList<>();
    private RecyclerView recyclerView;

    public ListBotijao() {
        // Required empty public constructor
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_list_botijao, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);

        BotijaoDAO bot = new BotijaoDAO();
        bot.list(new InterfaceCallback.ApiCallbackList() {
            @Override
            public void onCallback(List<Object> list) {
                for (Object botijao : list) {
                    listBotijao.add((Botijao) botijao);
                }
                System.out.println(listBotijao);
                RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(),2);
                recyclerView.setLayoutManager(manager);
                //recyclerView.setHasFixedSize(true);
                ListBotijaoAdapter adapter= new ListBotijaoAdapter(listBotijao,getActivity().getApplicationContext(), onClickListener());
                recyclerView.setAdapter(adapter);
            }
        });
        return v;
    }


    protected ListBotijaoAdapter.BotijaoOnClickListener onClickListener() {
        return new ListBotijaoAdapter.BotijaoOnClickListener() {
            @Override
            public void onClickBotijao(ListBotijaoAdapter.BotijaoViewHolder holder, int id) {
               Intent it = new Intent(getActivity().getApplicationContext(), Tela2.class);
                it.putExtra("frag",1);
                it.putExtra("botijao", listBotijao.get(id));
                startActivity(it);


            }
        } ;
    }

}