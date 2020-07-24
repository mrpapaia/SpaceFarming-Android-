package com.example.spacefarming.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoricoNivelAdapater extends RecyclerView.Adapter<HistoricoNivelAdapater.HistoricoNiveliewHolder> {


    @NonNull
    @Override
    public HistoricoNiveliewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricoNiveliewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class HistoricoNiveliewHolder extends RecyclerView.ViewHolder {
        TextView tvIdBotijao;
        TextView tvNivelBotijao;
        ImageView imgBotijao;
        private View view;

        public HistoricoNiveliewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
