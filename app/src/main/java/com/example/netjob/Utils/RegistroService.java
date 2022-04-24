package com.example.netjob.Utils;

import com.example.netjob.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegistroService {

    @POST("register")
    Call<User> postRegister(@Body User user);
}
