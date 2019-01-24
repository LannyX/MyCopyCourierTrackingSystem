package com.rjt.b16couriertrackingsystem.authentication.login;

import android.content.SharedPreferences;
import android.util.Log;

import com.rjt.b16couriertrackingsystem.authentication.login.module.User;
import com.rjt.b16couriertrackingsystem.authentication.login.network.LoginDataService;
import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserLoginPresenter implements UserLoginContract.UserLoginPresenter {

    public static String TAG = UserLoginPresenter.class.getSimpleName();

    UserLoginContract.UserLoginView view;


    public UserLoginPresenter(UserLogin activity) {
        view = activity;
    }

    @Override
    public void requestData(String email, String password, final SharedPreferences sp) {
        if (validateLoginInput(email, password)) {
            final LoginDataService loginDataService = RetrofitClientInstance.getRetrofitInstance().create(LoginDataService.class);
            Call<User> call = loginDataService.getUserData();
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    //Printing response from server
                    Log.e(TAG, response.toString());
                    Log.e(TAG, response.body().getMsg() + "\tApi: " + response.body().getAppapikey()
                            + "\tEmail: " + response.body().getUseremail()
                            + "\tId: " + response.body().getUserid());

                    //Server does not send user email - store api and id only - email has to hard coded
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("api", response.body().getAppapikey());
                    editor.putString("id", response.body().getUserid());
                    editor.commit();

                    //test shared preferences - works
                    Log.e(TAG, "READ SP: " + sp.getString("api", ""));


                    view.showMsg(response.body().getMsg());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });
        }
    }

    private boolean validateLoginInput(String email, String password) {
        boolean result = false;
        if (email.isEmpty() || password.isEmpty()) {
            view.showMsg("Please fill in empty fields");
        } else {
            result = true;
        }
        return result;
    }
}
