package com.devdvs.testapplication.crc.ui.user_list;

import android.content.Context;

import com.devdvs.testapplication.crc.data.network.model.user.User;

import java.util.List;

/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
public class UserListPresenter implements UserListMVP.Presenter {

    private final String TAG = getClass().getSimpleName();

    private UserListMVP.View userListView;
    private UserListMVP.Interactor userListInteractor;

    public UserListPresenter(UserListMVP.View listIPSPView, Context ctx) {
        this.userListView = listIPSPView;
        userListInteractor = new UserListInteractor(this, ctx);
    }
    @Override
    public void getUserList() {
        if (userListView != null)
            userListView.showProgress();

        if (userListInteractor != null)
            userListInteractor.getUserList();
    }

    @Override
    public void successfulGettingUserList(List<User> userList) {
        if (userListView != null) {
            userListView.hideProgress();
            userListView.successfulGettingUserList(userList);
        }
    }

    @Override
    public void errorGettingUserList(String error) {
        if (userListView != null) {
            userListView.hideProgress();
            userListView.errorGettingUserList(error);
        }
    }

    @Override
    public void onDetach() {
        userListView = null;

        if (userListInteractor != null)
            userListInteractor.onDetach();

        userListInteractor = null;

        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
