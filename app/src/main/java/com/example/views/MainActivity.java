package com.example.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    public static ArrayList<Contacto> listContactos = new
            ArrayList<>();
    RecyclerView recycler;

    int SECOND_ACTIVITY_REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.my_recycler_view);
        recycler.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        Contacto con = new Contacto();
        con.setUsuario("Omar Zavala Rodriguez");
        con.setEmail("Omar.ozromega@gmail.com");
        con.setFechaNac("28/04/98");
        con.setTel("445-125-53-57");
        con.setTwiter("@MACHIS98");
        listContactos.add(con);

        Contacto con2 = new Contacto();
        con2.setUsuario("Mariana");
        con2.setEmail("mary.97@gmail.com");
        con2.setFechaNac("08/08/97");
        con2.setTel("445-125-53-57");
        con2.setTwiter("@mary979897");
        listContactos.add(con2);

        MyAdapter adaptador = new MyAdapter(listContactos);
        recycler.setAdapter(adaptador);
        btn = findViewById(R.id.btnAgregarContac);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new
                        Intent(MainActivity.this,
                        MySecondActovity.class);

                startActivityForResult(i, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    // This method is called when the second activity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
                Contacto contacto = new Contacto();
                contacto = (Contacto)data.getExtras().getParcelable("contacto");
                listContactos.add(contacto);
                //listContactos=(ArrayList<Contacto>) getIntent().getSerializableExtra("lista");

                MyAdapter adaptador = new MyAdapter(listContactos);
                recycler.setAdapter(adaptador);

            }
        }
    }
}