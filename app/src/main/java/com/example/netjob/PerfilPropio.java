package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PerfilPropio extends AppCompatActivity {

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_propio);
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

    }
    private void bindUi() {

        Inicio = findViewById(R.id.imageButton);
        Buzon = findViewById(R.id.imageButton1);
        Buscar = findViewById(R.id.imageButton2);
        Favoritos = findViewById(R.id.imageButton3);
        Perfil = findViewById(R.id.imageButton4);
    }
    private void goToInicio(){
        Intent intent = new Intent(PerfilPropio.this, EditarPerfil.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToBuzon(){
        Intent intent = new Intent(PerfilPropio.this, EditarPerfil.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToBuscar(){
        Intent intent = new Intent(PerfilPropio.this, EditarPerfil.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToFavoritos(){
        Intent intent = new Intent(PerfilPropio.this, Favoritos.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToPerfil(){
        Intent intent = new Intent(PerfilPropio.this, BuscarServicio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
