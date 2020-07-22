package com.example.spacefarming.dao;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import com.example.spacefarming.entidades.Abastecer;

import com.example.spacefarming.interfaces.InterfaceCallback;
import com.example.spacefarming.interfaces.InterfaceNivelDAO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.spacefarming.services.RetrofitCfg;


public class AbastecerDAO implements InterfaceNivelDAO<Abastecer> {
    private static String TAG="AbastecerDAO";

    @Override
    public void getById(final InterfaceCallback.ApiCallbackList callback, String idBotijao) {
        Call<List<Abastecer>> call = new RetrofitCfg().abastecerServices().getByIdBotijao(idBotijao);
        call.enqueue(new Callback<List<Abastecer>>() {
            @Override
            public void onResponse(Call<List<Abastecer>> call, Response<List<Abastecer>> response) {
                callback.onCallback(Arrays.asList(response.body().toArray()));
                Log.d("TESTE",response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Abastecer>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void add(final InterfaceCallback.ApiCallback callback, Abastecer obj) {
        Call<String> call = new RetrofitCfg().abastecerServices().add(obj);
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
        Call<List<Abastecer>> call = new RetrofitCfg().abastecerServices().list();
        call.enqueue(new Callback<List<Abastecer>>() {
            @Override
            public void onResponse(Call<List<Abastecer>> call, Response<List<Abastecer>> response) {
                callback.onCallback(Arrays.asList(response.body().toArray()));
            }

            @Override
            public void onFailure(Call<List<Abastecer>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void delete(final InterfaceCallback.ApiCallback callback, String id) {
        Call<String> call = new RetrofitCfg().abastecerServices().delete(id);
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
