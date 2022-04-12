package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.netjob.Model.Servicio;
import com.example.netjob.databinding.ActivityListaServiciosBinding;

import java.util.ArrayList;
import java.util.List;

public class ListaServicios extends AppCompatActivity {

    ActivityListaServiciosBinding binding;

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaServiciosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Servicio> servicios = new ArrayList<>();

        servicios.add(new Servicio("Albañil","Prueba 1", R.drawable.albaniles));
        servicios.add(new Servicio("Fontanero","Prueba 1", R.drawable.albaniles));
        servicios.add(new Servicio("Mecanico","Prueba 1", R.drawable.albaniles));
        servicios.add(new Servicio("Plumero","Prueba 1", R.drawable.albaniles));
        servicios.add(new Servicio("Cocinero","Prueba 1", R.drawable.albaniles));
        servicios.add(new Servicio("Profesor","Prueba 1", R.drawable.albaniles));

        ServicioAdapter gridAdapter = new ServicioAdapter(ListaServicios.this, R.layout.servicio, servicios);
        binding.servicioOfrecido.setAdapter(gridAdapter);

        binding.servicioOfrecido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bindUi();

                Toast.makeText(ListaServicios.this, "Accediendo a servicio de " + servicios.get(position).getLinea1(), Toast.LENGTH_SHORT).show();

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

            private void goToInicio() {
                Intent intent = new Intent(ListaServicios.this, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            private void goToBuzon() {
                Intent intent = new Intent(ListaServicios.this, Buzon.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            private void goToBuscar() {
                Intent intent = new Intent(ListaServicios.this, ListaServicios.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            private void goToFavoritos() {
                Intent intent = new Intent(ListaServicios.this, Favoritos.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            private void goToPerfil() {
                Intent intent = new Intent(ListaServicios.this, PerfilPropio.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}

