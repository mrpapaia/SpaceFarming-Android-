package com.example.spacefarming.dao;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.spacefarming.entidades.Botijao;
import com.example.spacefarming.interfaces.InterfaceCallback;
import com.example.spacefarming.interfaces.InterfaceDAO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.spacefarming.services.RetrofitCfg;

public class BotijaoDAO implements InterfaceDAO<Botijao> {

    public void getById(final InterfaceCallback.ApiCallback callback, String idBotijao) {
        Call<Botijao> call = new RetrofitCfg().botijaoServices().getByID(idBotijao);
        call.enqueue(new Callback<Botijao>() {
            @Override
            public void onResponse(Call<Botijao> call, Response<Botijao> response) {
                Botijao botijao = response.body();
                callback.onCallback(botijao);
            }

            @Override
            public void onFailure(Call<Botijao> call, Throwable t) {
                Log.e("Botijao", "MSG:" + t.getMessage());
            }
        });

    }


    @Override
    public void add(final InterfaceCallback.ApiCallback callback, Botijao botijao) {
        Call<String> call = new RetrofitCfg().botijaoServices().add(botijao);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onCallback(response.body());
                Log.d("Botijao", response.body());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("Botijao", t.toString());
            }
        });

    }

    @Override
    public void list(final InterfaceCallback.ApiCallbackList callback) {
        Call<List<Botijao>> call = new RetrofitCfg().botijaoServices().list();
        call.enqueue(new Callback<List<Botijao>>() {
            @Override
            public void onResponse(Call<List<Botijao>> call, Response<List<Botijao>> response) {
                callback.onCallback(Arrays.asList(response.body().toArray()));
            }

            @Override
            public void onFailure(Call<List<Botijao>> call, Throwable t) {
                Log.e("Botijao", t.toString());
            }
        });

    }

    @Override
    public void delete(final InterfaceCallback.ApiCallback callback, String idBotijao) {
        Call<String> call = new RetrofitCfg().botijaoServices().delete(idBotijao);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onCallback(response.body());
                Log.d("Botijao", response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("Botijao", t.toString());
            }
        });
    }


}
