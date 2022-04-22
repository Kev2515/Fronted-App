package com.example.netjob.Utils;

import com.example.netjob.Model.LoginResponse;
import com.example.netjob.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegistroService {
    @POST("api/register")
    Call<LoginResponse> postRegister(@Body User user);
}
