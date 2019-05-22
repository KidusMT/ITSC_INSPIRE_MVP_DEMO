package com.kmt.itsc_inspire_mvp_demo.ui.login;

public interface LoginContract {

    interface LoginView {
        void showLoading();

        void hideLoading();

        void openHomeActivity();

        void showMessage(String message);
    }

    interface LoginPresenter {
        void onLoginClicked(String username, String password);
    }
}
