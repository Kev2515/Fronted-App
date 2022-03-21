package com.example.netjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private Button btnLogin;
    private EditText textEmail;
    private EditText textPassword;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindUi();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textEmail.getText().toString();
                String password = textPassword.getText().toString();
               if (login(email, password)) {
                   goToMain();
               }
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRecuperar();
            }
        });
    }

    //prueba 1

    private void bindUi() {
        textEmail = (EditText) findViewById(R.id.editText);
        textPassword = (EditText) findViewById(R.id.editText2);
        btnLogin = (Button) findViewById(R.id.button);
        textView4 = (TextView) findViewById(R.id.textView4);

    }

    private boolean login (String email, String password){
        if (!isValidaEmail(email)){
            Toast.makeText(this,"Email is not valid, please try again", Toast.LENGTH_LONG).show();
            return false;
        } else if (!isValidaPassword(password)){
            Toast.makeText(this,"Password is not valid, 4 characteres or more, please try again", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return  true;
        }
    }

    private boolean isValidaEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidaPassword(String password){
        return password.length() > 4;
    }

    private void goToMain(){
        Intent intent = new Intent(Login.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToRecuperar(){
        Intent intent = new Intent(Login.this, RecuperarC.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
