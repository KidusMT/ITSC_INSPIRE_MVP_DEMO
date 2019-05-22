package com.kmt.itsc_inspire_mvp_demo.data;

import com.kmt.itsc_inspire_mvp_demo.data.model.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthClient {

    @POST("auth/token")
    Call<String> login(@Body LoginRequest request);
}
