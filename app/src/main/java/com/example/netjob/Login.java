package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netjob.Model.LoginResponse;
import com.example.netjob.Model.User;
import com.example.netjob.Model.UserLogin;
import com.example.netjob.Utils.Apis;
import com.example.netjob.Utils.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    LoginService loginService;

     EditText username;
     EditText password;
     TextView textView4;
     Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);

    }

    public void Login(View view){

        UserLogin user = new UserLogin();

        if (!username.getText().toString().isEmpty()){
            user.setUsername(username.getText().toString());
        }else{
            username.setText("");
        }

        if (!password.getText().toString().isEmpty()){
            user.setPassword(password.getText().toString());
        }else{
            password.setText("");
        }

        loginService = Apis.getLoginService();
        Call<LoginResponse> call=loginService.postLogin(user);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {


                if (response.code() == 200){
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra("token" , response.body().getToken());
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario no encontrado", Toast.LENGTH_LONG ).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Log.d("Respuesta" , t.getMessage());
            }
        });

    }


    public void RecuperarContraseña(View view) {
        Intent intent = new Intent(Login.this, RecuperarC.class);
        startActivity(intent);
        finish();
    }
}
