package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Registro_activity extends AppCompatActivity {


    EditText edFechaCumple, edNombre, edCorreo, edDireccion, edTelefono, edContraseña;

    Button btnEnviar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        edNombre = findViewById(R.id.edNombre);
        edCorreo = findViewById(R.id.edCorreo);
        edDireccion = findViewById(R.id.edDireccion);
        edTelefono = findViewById(R.id.edTelefono);
        edFechaCumple = findViewById(R.id.edFechaCumple);
        edContraseña = findViewById(R.id.edContraseña);

        btnEnviar = findViewById(R.id.btnEnviar);

        edFechaCumple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enviar();
            }
        });
    }


    private void Enviar (){

        String nombre = edNombre.getText().toString();
        String correo = edCorreo.getText().toString();
        String direccion =  edDireccion.getText().toString();
        String telefono = edTelefono.getText().toString();
        String cumple = edFechaCumple.getText().toString();
        String contra = edContraseña.getText().toString();


        if (nombre.isEmpty() || correo.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || cumple.isEmpty() || contra.isEmpty()) {

            Toast.makeText(this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
        } else {
            Registro();

        }

    }

    private void Registro(){

        AlertDialog.Builder alert = new AlertDialog.Builder(Registro_activity.this);
        alert.setTitle("¿Sus datos son correctos?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String nombreUsuario = edNombre.getText().toString();
                        Intent intent = new Intent(Registro_activity.this, Bienvenida_activity.class);
                        intent.putExtra("nombreUsuario", nombreUsuario);

                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Registro_activity.this, "Click en No", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }


    private void showDatePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(Registro_activity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edFechaCumple.setText(year+"-"+(month+1)+"-"+dayOfMonth);


            }
        },year,month,dayOfMonth);
        dialog.show();
    }


}