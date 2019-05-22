package com.kmt.itsc_inspire_mvp_demo.ui.login;

import com.kmt.itsc_inspire_mvp_demo.data.AuthClient;
import com.kmt.itsc_inspire_mvp_demo.data.model.LoginRequest;
import com.kmt.itsc_inspire_mvp_demo.ui.AppConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginPresenter implements LoginContract.LoginPresenter {

    LoginContract.LoginView view;
    Retrofit retrofit;

    public LoginPresenter(LoginContract.LoginView loginView) {
        view = loginView;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppConstants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();

    }

    @Override
    public void onLoginClicked(String username, String password) {
        view.showLoading();
        if (username == null || password.isEmpty()) {
            view.showMessage("wrong username and password");
        }

        AuthClient client = retrofit.create(AuthClient.class);
        Call<String> call = client.login(new LoginRequest(username, password));

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                view.openHomeActivity();
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                view.showMessage(t.getMessage());
                view.hideLoading();
            }
        });


    }
}
