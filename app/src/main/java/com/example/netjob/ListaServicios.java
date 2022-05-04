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

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;

    GridView listaServicios;
    List<Servicios> servicios = new ArrayList<>();
    ServicioAdapter servicioAdapter;
    ServicioService servicioService;
    String category;
    String parametro;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicios);

        Inicio = findViewById(R.id.imageButton);
        Buzon = findViewById(R.id.imageButton1);
        Buscar = findViewById(R.id.imageButton2);
        Favoritos = findViewById(R.id.imageButton3);
        Perfil = findViewById(R.id.imageButton4);

        servicioService = Apis.getServicioService();

        listaServicios = findViewById(R.id.servicioOfrecido);
        listaServicios.setOnItemClickListener(this);

        token = getIntent().getStringExtra("token");
        category = getIntent().getStringExtra("id");
        parametro = getIntent().getStringExtra("parametro");

        if (category == null) {
            ListarServicioPorParametro();
        } else {
            ListarCategoriaPorCategoria();
        }
    }
    public void ListarCategoriaPorCategoria(){
        Call<List<Servicios>> call=servicioService.getServiciosPorCategoria(category, "Bearer "+ token, "application/json" );
        call.enqueue(new Callback<List<Servicios>>() {
            @Override
            public void onResponse(Call<List<Servicios>> call, Response<List<Servicios>> response) {
                servicios = response.body();
                servicioAdapter = new ServicioAdapter(ListaServicios.this, R.layout.activity_lista_servicios, servicios);
                listaServicios.setAdapter(servicioAdapter);
                Log.d("Servicios por categoria", response.body().toString());
                Log.d("status", response.toString());
            }

            @Override
            public void onFailure(Call<List<Servicios>> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });

    }

    public void ListarServicioPorParametro(){
        Call<List<Servicios>> call=servicioService.getServiciosPorParametro(parametro, "Bearer "+ token, "application/json");
        call.enqueue(new Callback<List<Servicios>>() {
            @Override
            public void onResponse(Call<List<Servicios>> call, Response<List<Servicios>> response) {
                servicios = response.body();
                servicioAdapter = new ServicioAdapter(ListaServicios.this, R.layout.activity_lista_servicios, servicios);
                listaServicios.setAdapter(servicioAdapter);
                Log.d("parametro", parametro);
                Log.d("response", response.body().toString());
                Log.d("status", response.toString());
            }

            @Override
            public void onFailure(Call<List<Servicios>> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.d("position", String.valueOf(position));
        Intent intent = new Intent(ListaServicios.this, DetalleServicio.class);
        intent.putExtra("id", servicios.get(position).getId());
        intent.putExtra("token" , token);

        startActivity(intent);
        finish();
    }
}

