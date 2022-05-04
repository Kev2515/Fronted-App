package com.example.netjob.Utils;

import com.example.netjob.Model.Categoria;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface CategoriaService {


    @GET("servicios/categoria?id=2")
    Call<List<Categoria>> getCategorias(@Header("Authorization") String auth, @Header("Content-Type") String contentType);

}
