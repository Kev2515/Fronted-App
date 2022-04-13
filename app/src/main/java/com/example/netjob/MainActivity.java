package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnInvitado;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUi();

        btnInvitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToInvitado();
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAcceso();
            }
        });
    }


    private void bindUi() {
        btnInvitado = (Button) findViewById(R.id.button);
        btnRegistro = (Button) findViewById(R.id.button2);

    }
    private void goToInvitado(){
        Intent intent = new Intent(MainActivity.this, HistorialContratos.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToAcceso(){
        Intent intent = new Intent(MainActivity.this, Inicio.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
