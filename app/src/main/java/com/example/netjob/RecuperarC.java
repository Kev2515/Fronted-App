package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.netjob.Model.User;
import com.example.netjob.Utils.Apis;
import com.example.netjob.Utils.RecuperarService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecuperarC extends AppCompatActivity {

    RecuperarService recuperarService;
    EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_c);

        mail = findViewById(R.id.editText);

    }
    public void RecContraseña (View view) {

        User user = new User();

        if (!mail.getText().toString().isEmpty()) {


            user.setMail(mail.getText().toString());

            recuperarService = Apis.getRecuperarService();
            Call<User> call = recuperarService.postRecuperar(user);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    if (response.code() == 200) {

                        Log.d("Respuesta Recuperar" , String.valueOf(response));


                    } else {

                        Toast.makeText(getApplicationContext(), String.valueOf(response), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Intent intent = new Intent(RecuperarC.this, Login.class);
                    startActivity(intent);
                    finish();


                    Log.d("Error Recuperacion", t.getMessage());

                }
            });
        } else {
            Toast.makeText(getApplicationContext(), " Datos erroneos", Toast.LENGTH_LONG).show();
            Log.d("RespuestaError Registro", "error");

        }
    }
}
