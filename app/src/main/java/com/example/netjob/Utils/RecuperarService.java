package com.example.netjob.Utils;

import com.example.netjob.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RecuperarService {

    @POST("account/reset-password/init")
    Call<User> postRecuperar(@Body User user);
}
