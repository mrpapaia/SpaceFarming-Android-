package com.example.spacefarming.services;



import com.example.spacefarming.interfaces.AbastecerServices;
import com.example.spacefarming.interfaces.BotijaoServices;
import com.example.spacefarming.interfaces.NivelServices;
import com.example.spacefarming.interfaces.UserServices;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class RetrofitCfg {
    private Retrofit retrofit;

    public RetrofitCfg() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://spacefarming.mrpapaia.tech:8080/farm02/rest/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public BotijaoServices botijaoServices() {
        return this.retrofit.create(BotijaoServices.class);
    }

    public NivelServices nivelServices() {
        return this.retrofit.create(NivelServices.class);
    }

    public UserServices userServices() {
        return this.retrofit.create(UserServices.class);
    }

    public AbastecerServices abastecerServices() {
        return this.retrofit.create(AbastecerServices.class);
    }

}
