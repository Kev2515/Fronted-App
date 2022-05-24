package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class EditarPerfil extends AppCompatActivity {

    Spinner spinProvincias;

    EditText nombre;
    EditText apellidos;
    EditText correo;
    EditText localidad;
    EditText formacion;
    EditText profesion;

    public Button NuevoServicio;
    public Button MisServicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        nombre = findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        correo = findViewById(R.id.correo);
        localidad = findViewById(R.id.localidad);
        formacion = findViewById(R.id.formacion);
        profesion = findViewById(R.id.profesion);

        NuevoServicio = findViewById(R.id.button);
        MisServicios = findViewById(R.id.BtnMisServicios);

        spinProvincias= (Spinner) findViewById(R.id.spinProvincia);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.provincias_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinProvincias.setAdapter(adapter);
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
        Intent intent = new Intent(this, PerfilPropio.class);
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

    public void BtnNuevoServicio(View view) {
        Intent intent = new Intent(this, Servicio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void BtnMejorarSuscripcion(View view) {
        Intent intent = new Intent(this, FormaPago.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void BtnMisServicios(View view) {
        Intent intent = new Intent(this, MisServicios.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void guardarCambios(View view) {

        Intent intent = new Intent(this, PerfilPropio.class);
        intent.putExtra("nombre", nombre.getText().toString());
        intent.putExtra("apellidos", apellidos.getText().toString());
        intent.putExtra("correo", correo.getText().toString());
        intent.putExtra("localidad", localidad.getText().toString());
        intent.putExtra("formacion", formacion.getText().toString());
        intent.putExtra("profesion", profesion.getText().toString());
        startActivity(intent);

    }
}