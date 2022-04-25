package com.example.netjob.Utils;

import com.example.netjob.Model.LoginResponse;
import com.example.netjob.Model.User;
import com.example.netjob.Model.UserLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("authenticate")
    Call<LoginResponse> postLogin(@Body UserLogin user);}
