package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class EditarPerfil extends AppCompatActivity {

    TextView localidad;
    Spinner localidades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        localidad=findViewById(R.id.editTextTextPersonName7);
        localidades=findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_spinner_item);

        localidades.setAdapter(adapter);
    }
}
