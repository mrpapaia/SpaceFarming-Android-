package com.example.spacefarming.dao;

import android.util.Log;

import java.util.Arrays;
import java.util.List;


import com.example.spacefarming.entidades.User;
import com.example.spacefarming.interfaces.InterfaceCallback;
import com.example.spacefarming.interfaces.InterfaceDAO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.spacefarming.services.RetrofitCfg;

public class UserDAO implements InterfaceDAO<User> {
    static String TAG="UserDAO";
    @Override
    public void getById(final InterfaceCallback.ApiCallback callback, String email) {
        Call<User> call = new RetrofitCfg().userServices().getByID(email);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User User = response.body();
                callback.onCallback(User);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "MSG:" + t.getMessage());
            }
        });

    }
    @Override
    public void add(final InterfaceCallback.ApiCallback callback, User User) {
        Call<String> call = new RetrofitCfg().userServices().add(User);
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
        Call<List<User>> call = new RetrofitCfg().userServices().list();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                callback.onCallback(Arrays.asList(response.body().toArray()));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @Override
    public void delete(final InterfaceCallback.ApiCallback callback, String idUser) {
        Call<String> call = new RetrofitCfg().userServices().delete(idUser);
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
