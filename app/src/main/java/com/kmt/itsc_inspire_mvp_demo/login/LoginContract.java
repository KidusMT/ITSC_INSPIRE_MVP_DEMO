package com.kmt.itsc_inspire_mvp_demo.login;

public interface LoginContract {

    interface LoginView {
        void showLoading();

        void hideLoading();

        void openHomeActivity();
    }

    interface LoginPresenter {
        void onLoginClicked(String username, String password);
    }
}
