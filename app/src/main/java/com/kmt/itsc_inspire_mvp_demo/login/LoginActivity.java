package com.kmt.itsc_inspire_mvp_demo.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.kmt.itsc_inspire_mvp_demo.R;
import com.kmt.itsc_inspire_mvp_demo.home.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    EditText username, password;
    Button btnLogin;
    ProgressBar progressBar;

    LoginContract.LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter(this);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        progressBar = findViewById(R.id.progressBar_cyclic);

        btnLogin.setOnClickListener(v-> loginPresenter.onLoginClicked(username.getText().toString(),
                password.getText().toString()));

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void openHomeActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
