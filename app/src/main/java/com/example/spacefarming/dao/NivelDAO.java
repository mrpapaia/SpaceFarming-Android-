package com.example.spacefarming.dao;

import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.spacefarming.entidades.Botijao;
import com.example.spacefarming.entidades.Nivel;
import com.example.spacefarming.interfaces.InterfaceCallback;
import com.example.spacefarming.interfaces.InterfaceNivelDAO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.spacefarming.services.RetrofitCfg;


public class NivelDAO implements  InterfaceNivelDAO<Nivel>{
    static String TAG="NivelDAO";

    @Override
    public void getById(final InterfaceCallback.ApiCallbackList callback, String idBotijao) {
        Call<List<Nivel>> call = new RetrofitCfg().nivelServices().getByIdBotijao(idBotijao);
        call.enqueue(new Callback<List<Nivel>>() {
            @Override
            public void onResponse(Call<List<Nivel>> call, Response<List<Nivel>> response) {
               callback.onCallback(Arrays.asList(response.body().toArray()));

            }

            @Override
            public void onFailure(Call<List<Nivel>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void add(final InterfaceCallback.ApiCallback callback, Nivel obj) {
        Call<String> call = new RetrofitCfg().nivelServices().add(obj);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onCallback(response.body());
                Log.d(TAG, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void list(final InterfaceCallback.ApiCallbackList callback) {
        Call<List<Nivel>> call = new RetrofitCfg().nivelServices().list();
        call.enqueue(new Callback<List<Nivel>>() {
            @Override
            public void onResponse(Call<List<Nivel>> call, Response<List<Nivel>> response) {
                callback.onCallback(Arrays.asList(response.body().toArray()));
            }

            @Override
            public void onFailure(Call<List<Nivel>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void delete(final InterfaceCallback.ApiCallback callback, String id) {
        Call<String> call = new RetrofitCfg().nivelServices().delete(id);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onCallback(response.body());
                Log.d(TAG, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }
}
