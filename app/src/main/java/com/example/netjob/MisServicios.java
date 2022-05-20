package com.example.netjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.netjob.Model.Servicio;
import com.example.netjob.Model.Servicios;
import com.example.netjob.databinding.ActivityMisServiciosBinding;

import java.util.ArrayList;
import java.util.List;

public class MisServicios extends AppCompatActivity {

    @NonNull ActivityMisServiciosBinding binding;

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;
    public Button NuevoServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMisServiciosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Servicio> servicios = new ArrayList<>();



        ServicioAdapter gridAdapter = new ServicioAdapter(MisServicios.this, R.layout.servicio, servicios);
        binding.servicioContratado.setAdapter(gridAdapter);

        binding.servicioContratado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bindUi();

        bindUi();

        Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInicio();
            }
        });
        Buzon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBuzon();
            }
        });
        Buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBuscar();
            }
        });
        Favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFavoritos();
            }
        });
        Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPerfil();
            }
        });

        NuevoServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { goToNuevoServicio(); }
        });

    }
    private void bindUi() {

        Inicio = findViewById(R.id.imageButton);
        Buzon = findViewById(R.id.imageButton1);
        Buscar = findViewById(R.id.imageButton2);
        Favoritos = findViewById(R.id.imageButton3);
        Perfil = findViewById(R.id.imageButton4);
        NuevoServicio = findViewById(R.id.nuevoServicio);
    }
    private void goToInicio(){
        Intent intent = new Intent(MisServicios.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToBuzon(){
        Intent intent = new Intent(MisServicios.this, Buzon.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToBuscar(){
        Intent intent = new Intent(MisServicios.this, ListaServicios.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToFavoritos(){
        Intent intent = new Intent(MisServicios.this, Favoritos.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToPerfil(){
        Intent intent = new Intent(MisServicios.this, PerfilPropio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToNuevoServicio(){
                Intent intent = new Intent(MisServicios.this, ListaServicios.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
