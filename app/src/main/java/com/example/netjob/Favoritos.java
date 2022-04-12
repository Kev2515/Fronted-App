package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

import com.example.netjob.Model.Favorito;

import java.util.ArrayList;
import java.util.List;

import com.example.netjob.databinding.ActivityFavoritosBinding;


public class Favoritos extends AppCompatActivity {

    ActivityFavoritosBinding binding;

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        binding = ActivityFavoritosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Favorito> favoritos = new ArrayList<>();

        favoritos.add(new Favorito("Albañil","Prueba 2", R.drawable.albaniles));
        favoritos.add(new Favorito("Fontanero","Prueba 2", R.drawable.albaniles));
        favoritos.add(new Favorito("Mecanico","Prueba 2", R.drawable.albaniles));
        favoritos.add(new Favorito("Plumero","Prueba 2", R.drawable.albaniles));
        favoritos.add(new Favorito("Cocinero","Prueba 2", R.drawable.albaniles));
        favoritos.add(new Favorito("Profesor","Prueba 2", R.drawable.albaniles));

        FavoritoAdapter gridAdapter = new FavoritoAdapter(Favoritos.this, R.layout.favorito, favoritos);
        binding.favoritos.setAdapter(gridAdapter);
        binding.favoritos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
            Intent intent = new Intent(Favoritos.this, Home.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToBuzon(){
            Intent intent = new Intent(Favoritos.this, Buzon.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToBuscar(){
            Intent intent = new Intent(Favoritos.this, ListaServicios.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToFavoritos(){
            Intent intent = new Intent(Favoritos.this, Favoritos.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        private void goToPerfil(){
            Intent intent = new Intent(Favoritos.this, PerfilPropio.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        });
    }
}
