package com.example.spacefarming.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacefarming.R;
import com.example.spacefarming.entidades.Abastecer;

import java.util.List;

public class HistoricoAbastecimentoAdapater extends RecyclerView.Adapter<HistoricoAbastecimentoAdapater.HistoricoAbastecerviewHolder> {
    private final List<Abastecer> list;
    private final Context context;

    public HistoricoAbastecimentoAdapater(List<Abastecer> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public HistoricoAbastecerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_historico_abastecimento, parent, false);
        HistoricoAbastecerviewHolder holder = new HistoricoAbastecerviewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull HistoricoAbastecerviewHolder holder, int position) {
        Abastecer abastecer = list.get(position);
        holder.tvIdBotijao.setText(abastecer.getBotijao());
        holder.tvNivelAnterior.setText(abastecer.getNivelAnterior().toString());
        holder.tvNivelAtual.setText(abastecer.getNivelAtual().toString());
        holder.tvNomeResponsavel.setText(abastecer.getResponsavel().getNome());
        holder.tvEmailResponsavel.setText(abastecer.getResponsavel().getEmail());
        holder.tvTelefoneResponsavel.setText(abastecer.getResponsavel().getTelefone());
        holder.tvNomeFornecedor.setText(abastecer.getFornecedor().getNome());
        holder.tvTelefoneFornecedor.setText(abastecer.getFornecedor().getTelefone());
        holder.tvEndereco.setText(abastecer.getFornecedor().getEndereco());
        holder.tvPreco.setText(abastecer.getPrecoLitro().toString());
        holder.tvData.setText(abastecer.getData());
    }

    @Override
    public int getItemCount() {
        return this.list != null ? this.list.size() : 0;
    }

    public static class HistoricoAbastecerviewHolder extends RecyclerView.ViewHolder {
        TextView tvIdBotijao;
        TextView tvNivelAnterior;
        TextView tvNivelAtual;
        TextView tvNomeResponsavel;
        TextView tvTelefoneResponsavel;
        TextView tvEmailResponsavel;
        TextView tvData;
        TextView tvNomeFornecedor;
        TextView tvTelefoneFornecedor;
        TextView tvEndereco;
        TextView tvPreco;
        private View view;


        public HistoricoAbastecerviewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            tvIdBotijao = view.findViewById(R.id.tvIdBotijao2);
            tvNivelAnterior = view.findViewById(R.id.tvNivelAnterior);
            tvNivelAtual = view.findViewById(R.id.tvNivelAtual);
            tvNomeResponsavel = view.findViewById(R.id.tvNomeResponsavel);
            tvTelefoneResponsavel = view.findViewById(R.id.tvTelefoneResponsavel);
            tvEmailResponsavel = view.findViewById(R.id.tvEmailResponsavel);
            tvData = view.findViewById(R.id.tvData);
            tvNomeFornecedor = view.findViewById(R.id.tvNomeFornecedor);
            tvTelefoneFornecedor = view.findViewById(R.id.tvTelefoneFornecedor);
            tvEndereco = view.findViewById(R.id.tvEnderecoFornecedor);
            tvPreco = view.findViewById(R.id.tvPrecoLitro);

        }
    }
}
