package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.netjob.Model.Contrato;
import com.example.netjob.databinding.ActivityHistorialContratosBinding;

import java.util.ArrayList;
import java.util.List;


public class HistorialContratos extends AppCompatActivity {

    ActivityHistorialContratosBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_contratos);
        binding = ActivityHistorialContratosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        List<Contrato> contratos = new ArrayList<>();

        contratos.add(new Contrato("Albañil","Prueba 3", R.drawable.albaniles));
        contratos.add(new Contrato("Fontanero","Prueba 3", R.drawable.albaniles));
        contratos.add(new Contrato("Mecanico","Prueba 3", R.drawable.albaniles));
        contratos.add(new Contrato("Plumero","Prueba 3", R.drawable.albaniles));
        contratos.add(new Contrato("Cocinero","Prueba 3", R.drawable.albaniles));
        contratos.add(new Contrato("Profesor","Prueba 3", R.drawable.albaniles));

        ContratoAdapter gridAdapter = new ContratoAdapter(HistorialContratos.this, R.layout.contrato, contratos);
        binding.estadoContrato.setAdapter(gridAdapter);
        binding.estadoContrato.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(HistorialContratos.this, "Accediendo a estado de " + contratos.get(position).getLinea1(), Toast.LENGTH_SHORT).show();



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
