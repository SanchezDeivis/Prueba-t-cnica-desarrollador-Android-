package com.devdvs.testapplication.src.data.network;

import com.devdvs.testapplication.src.util.ConfigUtil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(ConfigUtil.BASE_URL_API)
                    .build();
        }

        return retrofit;
    }

}
