package com.devdvs.testapplication.crc.ui.user_list;

import com.devdvs.testapplication.crc.data.network.model.user.User;

import java.util.List;

/**
 * Created by Sánchez Deivis on 12,febrero,2023
 */
public interface UserListMVP {
    interface View{
        void showProgress();
        void hideProgress();
        void successfulGettingUserList(List<User> userList);
        void errorGettingUserList(String error);
    }
    interface Presenter{
        void getUserList();
        void successfulGettingUserList(List<User> userList);
        void errorGettingUserList(String error);
        void onDetach();
    }

    interface Interactor{
        void getUserList();
        void onDetach();
    }
}
