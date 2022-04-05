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

public class RecuperarC extends AppCompatActivity {

    private Button btnEnviar;
    private EditText textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_c);

        bindUi();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textEmail.getText().toString();

                if (recuperar(email)) {
                    goToMain();
                }
            }
        });
    }

        private void bindUi() {

            btnEnviar = (Button) findViewById(R.id.button);
            textEmail = (EditText) findViewById(R.id.editText);
        }

    private boolean recuperar(String email){
        if (!isValidaEmail(email)){
            Toast.makeText(this,"Email is not valid, please try again", Toast.LENGTH_LONG).show();
            return false;

        } else {
            return  true;
        }
    }

    private boolean isValidaEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void goToMain(){
        Intent intent = new Intent(RecuperarC.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
