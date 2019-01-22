package com.rjt.b16couriertrackingsystem.authentication.login;

import android.content.SharedPreferences;

public interface UserLoginContract {

    interface UserLoginView{
        void showMsg(String msg);
    }

    interface UserLoginPresenter{
        void requestData(String email, String password, SharedPreferences sharedPreferences);
    }

}
