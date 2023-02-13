package com.devdvs.testapplication.crc.data.network;

import com.devdvs.testapplication.crc.data.network.model.user.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
public interface ApiHelper {
    // User:
    @Headers({"Content-Type: application/vnd.api+json"})
    @GET("users")
    Call<List<User>> getUsers();

}
