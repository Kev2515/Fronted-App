package com.example.netjob.Utils;

import com.example.netjob.Model.Categoria;
import com.example.netjob.Model.Servicio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface DestacadoService {


    @GET("servicios/destacados")
    Call<List<Servicio>> getServicios(@Header("Authorization") String auth, @Header("Content-Type") String contentType);
}
