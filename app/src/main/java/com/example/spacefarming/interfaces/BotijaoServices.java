package com.example.spacefarming.interfaces;

import java.util.List;

import com.example.spacefarming.entidades.Botijao;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Path;

public interface BotijaoServices {
    @GET("botijao/list")
    Call<List<Botijao>> list();

    @GET("botijao/get/{id}")
    Call <Botijao> getByID(@Path("id") String idBotijao);

    @POST("botijao/add")
    Call<String> add(@Body Botijao botijao);

    @DELETE("botijao/delete/{id}")
    Call<String> delete(@Path("id") String idBotijao);

}
