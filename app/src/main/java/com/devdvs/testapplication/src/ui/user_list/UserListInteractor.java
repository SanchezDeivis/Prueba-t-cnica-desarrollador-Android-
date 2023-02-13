package com.devdvs.testapplication.src.ui.user_list;

import android.content.Context;

import com.devdvs.testapplication.R;
import com.devdvs.testapplication.src.data.network.ApiClient;
import com.devdvs.testapplication.src.data.network.ApiHelper;
import com.devdvs.testapplication.src.data.network.model.error.ErrorResponse;
import com.devdvs.testapplication.src.data.network.model.user.User;
import com.devdvs.testapplication.src.util.NetworkUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
public class UserListInteractor implements UserListMVP.Interactor {
    private final String TAG = getClass().getSimpleName();
    private UserListMVP.Presenter presenter;
    Context context;

    public UserListInteractor(UserListMVP.Presenter presenter, Context context) {
        this.presenter = presenter;
        this.context=context;
    }

    @Override
    public void getUserList() {
        if (NetworkUtil.isConnected(context)) {
            ApiHelper service = ApiClient.getRetrofit().create(ApiHelper.class);
            Call<List<User>> call = service.getUsers();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call,
                                       Response<List<User>> response) {
                    Gson gson = new GsonBuilder().create();
                    ErrorResponse errorResponse;
                    if (response.isSuccessful()) {
                        sendSuccess(response.body());
                    } else try {
                        if (response.errorBody() != null) {
                            errorResponse = gson.fromJson(response.errorBody().string(),
                                    ErrorResponse.class);
                            sendError(errorResponse.getMessage());
                        } else {
                            sendError("");
                        }
                    } catch (IOException e) {
                        sendError(e.toString());
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    if (t.getCause() != null) {
                        sendError(t.getCause().toString());
                    } else {
                        sendError("");
                    }
                }
            });
        }else {
            sendError(context.getResources().getString(R.string.internet_connection_problems));
        }
    }

    private void sendSuccess(List<User> body) {
        if (body != null && !body.isEmpty()) {
            if (presenter != null) presenter.successfulGettingUserList(body);
        } else {
            if (presenter != null)
                presenter.errorGettingUserList(
                        context.getResources().getString(R.string.error_ocured));
        }
    }

    private void sendError(String error) {
        if (error != null && !error.isEmpty()) {
            if (presenter != null) presenter.errorGettingUserList(error);
        } else {
            if (presenter != null)
                presenter.errorGettingUserList(
                        context.getResources().getString(R.string.error_ocured));
        }
    }

    @Override
    public void onDetach() {
        presenter = null;
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
