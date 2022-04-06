package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.netjob.Model.Categoria;
import com.example.netjob.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Categoria> categorias = new ArrayList<>();

        categorias.add(new Categoria("Albañiles", R.drawable.albaniles));
        categorias.add(new Categoria("Cuidadores", R.drawable.ancianos));
        categorias.add(new Categoria("Electricistas", R.drawable.electricistas));
        categorias.add(new Categoria("Fontaneros", R.drawable.fontaneros));
        categorias.add(new Categoria("Jardineros", R.drawable.jardineros));
        categorias.add(new Categoria("Profesores", R.drawable.profesor_particular));

        CategoriaAdapter gridAdapter = new CategoriaAdapter(Home.this, R.layout.categoria, categorias);
        binding.gridView.setAdapter(gridAdapter);


        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bindUi();

                Toast.makeText(Home.this, "Buscando " + categorias.get(position).getName(), Toast.LENGTH_SHORT).show();


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
                Intent intent = new Intent(Home.this, Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            private void goToBuzon() {
                Intent intent = new Intent(Home.this, Buzon.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            private void goToBuscar() {
                Intent intent = new Intent(Home.this, ListaServicios.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            private void goToFavoritos() {
                Intent intent = new Intent(Home.this, Favoritos.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }

            private void goToPerfil() {
                Intent intent = new Intent(Home.this, PerfilPropio.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }


        });
    }
}

