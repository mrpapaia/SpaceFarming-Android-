package com.example.spacefarming.adapter;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spacefarming.R;
import com.example.spacefarming.entidades.Botijao;

import java.util.List;

public class ListBotijaoAdapter extends RecyclerView.Adapter<ListBotijaoAdapter.BotijaoViewHolder> {
    private  final List<Botijao> list;
    private final Context context;
    private final BotijaoOnClickListener onClickListener;

    public ListBotijaoAdapter(List<Botijao> list, Context context, BotijaoOnClickListener onClickListener) {
        this.list = list;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public BotijaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_list_botijao, parent, false);

        BotijaoViewHolder holder = new BotijaoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BotijaoViewHolder holder, final int position) {
        Botijao botijao = list.get(position);
        holder.tvIdBotijao.setText(botijao.getId());
        holder.tvNivelBotijao.setText(botijao.getNivelAtual().toString());
        if(botijao.getQuantidadeCanecas() <= 2){
            holder.imgBotijao.setImageResource(R.drawable.botijao2);
        }else if(botijao.getQuantidadeCanecas() <=4){
            holder.imgBotijao.setImageResource(R.drawable.botijao4);
        }else if(botijao.getQuantidadeCanecas() <= 6){
            holder.imgBotijao.setImageResource(R.drawable.botijao6);
        }else{
            holder.imgBotijao.setImageResource(R.drawable.botijao8);
        }
        if(onClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickBotijao(holder,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return this.list != null ? this.list.size() : 0;
    }
    public interface BotijaoOnClickListener{
         void onClickBotijao(BotijaoViewHolder holder, int id);
    }
    public static class BotijaoViewHolder extends RecyclerView.ViewHolder{
        TextView tvIdBotijao;
        TextView tvNivelBotijao;
        ImageView imgBotijao;
        private View view;


        public BotijaoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            tvIdBotijao = (TextView) view.findViewById(R.id.tvIdBotijao);
            tvNivelBotijao=(TextView) view.findViewById(R.id.tvNivelBotijao);
            imgBotijao = (ImageView) view.findViewById(R.id.imgBotijao);
        }
    }

}
