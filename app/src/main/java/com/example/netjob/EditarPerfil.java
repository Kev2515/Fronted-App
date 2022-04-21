package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class EditarPerfil extends AppCompatActivity {

    TextView localidad;
    Spinner localidades;

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;
    public Button NuevoServicio;
    public Button MisServicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        bindUi();


        localidad=findViewById(R.id.editTextTextPersonName7);
        localidades=findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_item);

        localidades.setAdapter(adapter);
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
        MisServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { goToMisServicios(); }
        });


    }
    private void bindUi() {

        Inicio = findViewById(R.id.imageButton);
        Buzon = findViewById(R.id.imageButton1);
        Buscar = findViewById(R.id.imageButton2);
        Favoritos = findViewById(R.id.imageButton3);
        Perfil = findViewById(R.id.imageButton4);
        NuevoServicio = findViewById(R.id.button);
        MisServicios = findViewById(R.id.button3);
    }
        private void goToInicio(){
            Intent intent = new Intent(EditarPerfil.this, Home.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToBuzon(){
            Intent intent = new Intent(EditarPerfil.this, Buzon.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToBuscar(){
            Intent intent = new Intent(EditarPerfil.this, ListaServicios.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToFavoritos(){
            Intent intent = new Intent(EditarPerfil.this, Favoritos.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToPerfil(){
            Intent intent = new Intent(EditarPerfil.this, PerfilPropio.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToNuevoServicio(){
            Intent intent = new Intent(EditarPerfil.this, ListaServicios.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToMisServicios(){
            Intent intent = new Intent(EditarPerfil.this, MisServicios.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }

