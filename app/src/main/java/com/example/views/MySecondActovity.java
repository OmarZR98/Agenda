package com.example.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MySecondActovity extends AppCompatActivity {

    EditText txtEmail, txtUsuario, txtTwiter, txtTel, txtFechaNac;
    Button btnSave ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

    }

    public void btnSave_click (View v)
    {
        try {
            txtUsuario = findViewById(R.id.txtUsuario);
            txtEmail = findViewById(R.id.txtEmail);
            txtFechaNac = findViewById(R.id.txtFechaNac);
            txtTel = findViewById(R.id.txtTelefono);
            txtTwiter = findViewById(R.id.txtTwiter);

            Contacto con = new Contacto();
            con.setUsuario(txtUsuario.getText().toString());
            con.setEmail(txtEmail.getText().toString());
            con.setFechaNac(txtFechaNac.getText().toString());
            con.setTel(txtTel.getText().toString());
            con.setTwiter(txtTwiter.getText().toString());

            Toast.makeText(MySecondActovity.this,
                    "Contacto Registrado",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent();
            intent.putExtra("contacto", con);
            setResult(RESULT_OK, intent);
            super.finish();

        }catch (Exception e){
            Toast.makeText(MySecondActovity.this,
                    e.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

}
