package com.example.netjob;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netjob.Model.DestacadoAdapter;
import com.example.netjob.Model.Servicio;
import com.example.netjob.Utils.Apis;
import com.example.netjob.Utils.ServicioService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaServicios extends AppCompatActivity implements AdapterView.OnItemClickListener {

    RecyclerView recycler;
    List<Servicio> servicios = new ArrayList<>();
    ServicioService servicioService;
    int id;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicios);

        servicioService = Apis.getServicioService();

        recycler= findViewById(R.id.recycler);

        token = getIntent().getStringExtra("token");
        id = getIntent().getIntExtra("id", 0);

        ListarServicios();

        //parametro = getIntent().getStringExtra("parametro");

        /*
        if (category == null) {
            ListarServicioPorParametro();
        } else {
            ListarCategoriaPorCategoria();
        }
         */
    }

    public void ListarServicios(){
        Call<List<Servicio>> call=servicioService.getServiciosPorParametro(id ,"Bearer "+ token, "application/json" );
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                servicios = response.body();
                DestacadoAdapter ServicioAdapter = new DestacadoAdapter((servicios));
                RecyclerView recyclerViewDestacados = findViewById(R.id.recycler);
                recyclerViewDestacados.setAdapter(ServicioAdapter);
                recyclerViewDestacados.setLayoutManager(new LinearLayoutManager(ListaServicios.this, LinearLayoutManager.VERTICAL, false));
                Log.d("Servicio ejemplo", servicios.toString());
                //Log.d("status", response.toString());
            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {
                //Log.d("response", t.getMessage());
            }
        });

    }

    /*
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
*/


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
        Intent intent = new Intent(this, Home.class);
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

