package com.example.spacefarming.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacefarming.R;
import com.example.spacefarming.entidades.Nivel;

import java.util.List;

public class HistoricoNivelAdapater extends RecyclerView.Adapter<HistoricoNivelAdapater.HistoricoNivelviewHolder> {
    private final List<Nivel> list;
    private final Context context;

    public HistoricoNivelAdapater(List<Nivel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public HistoricoNivelviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_historico_nivel, parent, false);
        HistoricoNivelviewHolder holder = new HistoricoNivelviewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull HistoricoNivelviewHolder holder, int position) {
        Nivel nivel = list.get(position);
        holder.tvIdBotijao.setText(nivel.getBotijao());
        holder.tvNivel.setText(nivel.getNivel().toString());
        holder.tvNomeResponsavel.setText(nivel.getResponsavel().getNome());
        holder.tvEmailResponsavel.setText(nivel.getResponsavel().getEmail());
        holder.tvTelefoneResponsavel.setText(nivel.getResponsavel().getTelefone());
        holder.tvData.setText(nivel.getData());
    }

    @Override
    public int getItemCount() {
        return this.list != null ? this.list.size() : 0;
    }

    public static class HistoricoNivelviewHolder extends RecyclerView.ViewHolder {
        TextView tvIdBotijao;
        TextView tvNivel;
        TextView tvNomeResponsavel;
        TextView tvTelefoneResponsavel;
        TextView tvEmailResponsavel;
        TextView tvData;
        private View view;


        public HistoricoNivelviewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            tvIdBotijao = view.findViewById(R.id.tvIdBotijao2);
            tvNivel = view.findViewById(R.id.tvNivel);
            tvNomeResponsavel = view.findViewById(R.id.tvNomeResponsavel);
            tvTelefoneResponsavel = view.findViewById(R.id.tvTelefoneResponsavel);
            tvEmailResponsavel = view.findViewById(R.id.tvEmailResponsavel);
            tvData = view.findViewById(R.id.tvData);
        }
    }
}
