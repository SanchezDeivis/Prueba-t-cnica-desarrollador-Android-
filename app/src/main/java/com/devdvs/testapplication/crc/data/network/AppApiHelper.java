package com.devdvs.testapplication.crc.data.network;

import com.devdvs.testapplication.crc.data.network.model.user.User;

import java.util.List;

import retrofit2.Call;

/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
public class AppApiHelper implements ApiHelper{
    @Override
    public Call<List<User>> getUsers() {
        return null;
    }
}
