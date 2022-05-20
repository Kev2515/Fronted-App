package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.netjob.Model.Servicio;
import com.example.netjob.Model.Servicios;
import com.example.netjob.Utils.Apis;
import com.example.netjob.Utils.ServicioService;
import com.example.netjob.databinding.ActivityListaServiciosBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaServicios extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ActivityListaServiciosBinding binding;

    GridView listaServicios;
    List<Servicio> servicios = new ArrayList<>();
    ServicioAdapter servicioAdapter;
    ServicioService servicioService;
    String category;
    String parametro;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicios);

        servicioService = Apis.getServicioService();

        listaServicios = findViewById(R.id.servicioOfrecido);
        listaServicios.setOnItemClickListener(this);

        token = getIntent().getStringExtra("token");
        category = getIntent().getStringExtra("category");
        parametro = getIntent().getStringExtra("parametro");

        if (category == null) {
            ListarServicioPorParametro();
        } else {
            ListarCategoriaPorCategoria();
        }
    }
    public void ListarCategoriaPorCategoria(){
        Call<List<Servicio>> call=servicioService.getServiciosPorCategoria(category, "Bearer "+ token, "application/json" );
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                servicios = response.body();
                servicioAdapter = new ServicioAdapter(ListaServicios.this, R.layout.servicio, servicios);
                listaServicios.setAdapter(servicioAdapter);
                Log.d("Servicios por categoria", response.body().toString());
                Log.d("status", response.toString());
            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });

    }

    public void ListarServicioPorParametro(){
        Call<List<Servicio>> call=servicioService.getServiciosPorParametro(parametro, "Bearer "+ token, "application/json");
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                servicios = response.body();
                servicioAdapter = new ServicioAdapter(ListaServicios.this, R.layout.servicio, servicios);
                listaServicios.setAdapter(servicioAdapter);
                Log.d("parametro", parametro);
                Log.d("response", response.body().toString());
                Log.d("status", response.toString());
            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d("position", String.valueOf(position));
        Intent intent = new Intent(ListaServicios.this, DetalleServicio.class);
        intent.putExtra("id", position);
        intent.putExtra("token" , token);

        startActivity(intent);
        finish();
    }
    public void BtnHome(View view) {
        Intent intent = new Intent(this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void BtnBuzon(View view) {
        Intent intent = new Intent(this, Buzon.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void BtnBuscar(View view) {
        Intent intent = new Intent(this, ListaServicios.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void BtnFavoritos(View view) {
        Intent intent = new Intent(this, Favoritos.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void BtnPerfil(View view) {
        Intent intent = new Intent(this, PerfilPropio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

