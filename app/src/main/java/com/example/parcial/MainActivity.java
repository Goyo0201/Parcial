package com.example.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    EditText edCorreoLg, edContraseñaLg;
    Button btnRegistro, btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCorreoLg = findViewById(R.id.edCorreoLg);
        edContraseñaLg = findViewById(R.id.edContraseñaLg);

        btnRegistro = findViewById(R.id.btnRegistro);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Enviar();}
        });


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {ClickRegistrar();}
        });



    }

    public void Enviar() {
        String correo = edCorreoLg.getText().toString();
        String contrasena = edContraseñaLg.getText().toString();


        if (correo.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
        } else {
            ClicIngreso();
        }
    }

    private void ClicIngreso() {
        String nombreUsuario = edCorreoLg.getText().toString();
        Intent intent = new Intent(this, Bienvenida_activity.class);
        intent.putExtra("nombreUsuario", nombreUsuario);
        startActivity(intent);
    }

    private void ClickRegistrar() {
        Intent intent = new Intent(this, Registro_activity.class);
        startActivity(intent);
    }




}