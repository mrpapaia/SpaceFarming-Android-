package com.example.spacefarming.interfaces;

import java.util.List;


import com.example.spacefarming.entidades.Nivel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface  NivelServices {
    @GET("nivel/list")
    Call<List<Nivel>> list();

    @GET("nivel/listByBotijao/{id}")
    Call<List<Nivel>> getByIdBotijao(@Path("id") String idBotijao);

    @POST("nivel/add")
    Call<String> add(@Body Nivel user);

    @DELETE("nivel/delete/{id}")
    Call<String> delete(@Path("id") String email);
}
