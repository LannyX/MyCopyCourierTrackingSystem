package com.rjt.b16couriertrackingsystem.authentication.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rjt.b16couriertrackingsystem.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class UserLogin extends AppCompatActivity implements UserLoginContract.UserLoginView {


    @BindView(R.id.editTextLoginEmail)
    EditText editTextLoginEmail;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.editTextLoginPassword)
    EditText editTextLoginPassword;
    @BindView(R.id.buttonLogin)
    Button buttonLogin;

    UserLoginContract.UserLoginPresenter userLoginPresenter;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
        userLoginPresenter = new UserLoginPresenter(this);
        sp = getSharedPreferences("userFile",MODE_PRIVATE);

        //onViewClicked();

    }

    @OnClick(R.id.buttonLogin)
    public void onViewClicked() {
        userLoginPresenter.requestData(editTextLoginEmail.getText().toString(),
                editTextLoginPassword.getText().toString(),
                sp);
    }

    @Override
    public void showMsg(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Login: " + msg);
        builder.show();
    }
}
