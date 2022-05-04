package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.netjob.Model.Categoria;
import com.example.netjob.Utils.Apis;
import com.example.netjob.Utils.CategoriaService;
import com.example.netjob.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity implements CategoriaService, AdapterView.OnItemClickListener {

    ActivityHomeBinding binding;

    private ImageButton Inicio;
    private ImageButton Buzon;
    private ImageButton Buscar;
    private ImageButton Favoritos;
    private ImageButton Perfil;

    GridView listaCategorias;
    List<Categoria> categorias = new ArrayList<>();
    CategoriaAdapter categoriaAdapter;
    CategoriaService categoriaService;
    EditText buscador;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        categoriaService = Apis.getCategoriaService();
        token = getIntent().getStringExtra("token");

        buscador = findViewById(R.id.buscador);
        listaCategorias= findViewById(R.id.gridView);

        listaCategorias.setOnItemClickListener(this);

        ListarCategorias();

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
    public void BuscarRecetas(View view) {
        if (!buscador.getText().toString().isEmpty()) {
            Intent intent = new Intent(Home.this, ListaServicios.class);
            intent.putExtra("parametro", buscador.getText().toString());
            Log.d("parametro", buscador.getText().toString());
            intent.putExtra("token" , token);
            startActivity(intent);
            finish();
        }
    }

    private void ListarCategorias() {
        Call<List<Categoria>> call=categoriaService.getCategorias("Bearer "+ token,  "application/json");
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                Log.d("status", response.toString());
                categorias = response.body();
                categoriaAdapter = new CategoriaAdapter(Home.this, R.layout.categoria, categorias);
                listaCategorias.setAdapter(categoriaAdapter);
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.d("response", t.getMessage());
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent intent = new Intent(Home.this, ListaServicios.class);
        intent.putExtra("category" , categorias.get(position).getName());
        Log.d("category", categorias.get(position).getName());
        intent.putExtra("token" , token);
        startActivity(intent);
        finish();
    }

    @Override
    public Call<List<Categoria>> getCategorias(String auth, String contentType) {
        return null;
    }
}

