package com.example.viknox.facebookintegration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    LoginButton bt_login;
    TextView tv_login;
    private FacebookCallback<LoginResult> fbCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            //TODO 1. Get UserName, AuthToken,DoB,Email,PicURL
        }

        @Override
        public void onCancel() {
            Toast
        }

        @Override
        public void onError(FacebookException error) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

    }

    private void initUI() {
        bt_login = (LoginButton) findViewById(R.id.login_button);
        tv_login = (TextView)    findViewById(R.id.tv_hello);
    }

}
