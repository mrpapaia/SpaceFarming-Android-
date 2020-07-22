package com.example.spacefarming.interfaces;


import java.util.List;


import com.example.spacefarming.entidades.Abastecer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AbastecerServices {
    @GET("abastecimento/list")
    Call<List<Abastecer>> list();

    @GET("abastecimento/listByBotijao/{id}")
    Call<List<Abastecer>> getByIdBotijao(@Path("id") String idBotijao);

    @POST("abastecimento/add")
    Call<String> add(@Body Abastecer user);

    @DELETE("abastecimento/delete/{id}")
    Call<String> delete(@Path("id") String email);
}
