package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.netjob.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] categoriaName = {"Albañiles", "Cuidadores", "Electricistas", "Fontaneros", "Jardineros", "Profesores particulares"};
        int[] categoriaImage = {R.drawable.albaniles, R.drawable.ancianos, R.drawable.electricistas, R.drawable.fontaneros, R.drawable.jardineros, R.drawable.profesor_particular };

        GridAdapter gridAdapter = new GridAdapter(Home.this, categoriaName, categoriaImage);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Home.this, "Buscando " + categoriaName[position], Toast.LENGTH_SHORT).show();
                

            }
        });
    }
}