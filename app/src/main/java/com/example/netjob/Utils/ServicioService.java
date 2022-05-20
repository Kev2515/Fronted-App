package com.example.netjob.Utils;

import com.example.netjob.Model.Servicio;
import com.example.netjob.Model.Servicios;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ServicioService {

    @GET("/servicios")
    Call<List<Servicio>> getServicios(String category, @Header("Authorization") String auth, @Header("Content-Type") String contentType);

    @GET("/servicios/categoria/{id}")
    Call<List<Servicio>> getServiciosPorCategoria(@Path("id") String category, @Header("Authorization") String auth, @Header("Content-Type") String contentType);

    @GET("/servicios/{id}")
    Call<List<Servicio>> getServiciosPorParametro(@Path("id") String category, @Header("Authorization") String auth, @Header("Content-Type") String contentType);

}
