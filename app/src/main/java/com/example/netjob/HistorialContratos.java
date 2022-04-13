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

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;

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
                bindUi();

                Toast.makeText(HistorialContratos.this, "Accediendo a estado de " + contratos.get(position).getLinea1(), Toast.LENGTH_SHORT).show();


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
        Intent intent = new Intent(HistorialContratos.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToBuzon(){
        Intent intent = new Intent(HistorialContratos.this, Buzon.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToBuscar(){
        Intent intent = new Intent(HistorialContratos.this, ListaServicios.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToFavoritos(){
        Intent intent = new Intent(HistorialContratos.this, Favoritos.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToPerfil(){
        Intent intent = new Intent(HistorialContratos.this, PerfilPropio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
        });
    }
}
