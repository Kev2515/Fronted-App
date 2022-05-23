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

        NuevoServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { goToNuevoServicio(); }
        });

    }

    private void goToNuevoServicio(){
                Intent intent = new Intent(MisServicios.this, ListaServicios.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
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

    public void BtnServicio(View view) {
        Intent intent = new Intent(this, com.example.netjob.Servicio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
