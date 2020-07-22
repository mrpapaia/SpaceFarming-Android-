package com.example.spacefarming.interfaces;

import java.util.List;


import com.example.spacefarming.entidades.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface  UserServices {
    @GET("user/list")
    Call<List<User>> list();

    @GET("user/get/{id}")
    Call <User> getByID(@Path("id") String email);

    @POST("user/add")
    Call<String> add(@Body User user);

    @DELETE("user/delete/{id}")
    Call<String> delete(@Path("id") String email);
}
