package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PerfilPropio extends AppCompatActivity {


    TextView nombre;
    TextView apellidos;
    TextView correo;
    TextView localidad;
    TextView formacion;
    TextView profesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_propio);

        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        correo = findViewById(R.id.correo);
        localidad = findViewById(R.id.localidad);
        formacion = findViewById(R.id.formacion);
        profesion = findViewById(R.id.profesion);


        String dato = getIntent().getStringExtra("nombre");
        nombre.setText("Nombre: " + dato);
        String dato1 = getIntent().getStringExtra("apellidos");
        apellidos.setText("Apellidos: " + dato1);
        String dato2 = getIntent().getStringExtra("correo");
        correo.setText("Correo: " + dato2);
        String dato3 = getIntent().getStringExtra("localidad");
        localidad.setText("Localidad: " + dato3);
        String dato4 = getIntent().getStringExtra("formacion");
        formacion.setText("Formaciòn: " + dato4);
        String dato5 = getIntent().getStringExtra("profesion");
        profesion.setText("Profesiòn: " + dato5);


    }
    public void Historial(View view) {
        Intent intent = new Intent(PerfilPropio.this, HistorialContratos.class);
        startActivity(intent);
        finish();
    }
    public void Standard(View view) {
        Intent intent = new Intent(PerfilPropio.this, PerfilVisitado.class);
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
    public void BtnEditarPerfil(View view) {
        Intent intent = new Intent(this, EditarPerfil.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


}
