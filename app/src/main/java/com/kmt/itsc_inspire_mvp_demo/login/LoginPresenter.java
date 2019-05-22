package com.kmt.itsc_inspire_mvp_demo.login;

public class LoginPresenter implements LoginContract.LoginPresenter {

    LoginContract.LoginView view;

    public LoginPresenter(LoginContract.LoginView loginView) {
        view = loginView;
    }

    @Override
    public void onLoginClicked(String username, String password) {
        view.showLoading();
        if (username == null || password.isEmpty()) {
            // todo show message
        }

        view.openHomeActivity();
        view.hideLoading();
    }
}
