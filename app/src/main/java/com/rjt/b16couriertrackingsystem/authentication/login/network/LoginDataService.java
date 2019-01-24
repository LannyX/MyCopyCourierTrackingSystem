package com.rjt.b16couriertrackingsystem.authentication.login.network;

import com.rjt.b16couriertrackingsystem.authentication.login.module.User;

import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginDataService {
    @POST("cst_login.php")
    Call<User> getUserData();
}
