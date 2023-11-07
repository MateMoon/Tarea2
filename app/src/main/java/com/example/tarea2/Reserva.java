package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Reserva extends AppCompatActivity {

    daoContacto dao;
    Adaptador adapter;
    ArrayList<Contacto> lista;
    Contacto c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        dao= new daoContacto(Reserva.this);
        lista=dao.verTodo();
        adapter=new Adaptador(this, lista, dao);
        ListView list =  findViewById(R.id.lista);
        Button insertar = findViewById(R.id.btn_insertar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Dialodo para ver vista previa de registro
            }
        });
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Dialogo para agregar
                Dialog dialog = new Dialog(Reserva.this);
                dialog.setTitle("Nuevo Registro");
                dialog.setCancelable(true);
                dialog.setContentView(R.layout.dialogo);
                dialog.show();
                final EditText nombre = dialog.findViewById(R.id.et_nombre);
                final EditText apellido = dialog.findViewById(R.id.et_apellido);
                final EditText email = dialog.findViewById(R.id.et_email);
                final EditText telefono = dialog.findViewById(R.id.et_telefono);
                final EditText mascota = dialog.findViewById(R.id.et_mascota);
                Button guardar = dialog.findViewById(R.id.btn_agregar);
                guardar.setText("Agregar");
                Button cancelar = dialog.findViewById(R.id.btn_cancelar);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            c = new Contacto(nombre.getText().toString(),
                                    apellido.getText().toString(),
                                    email.getText().toString(),
                                    telefono.getText().toString(),
                                    mascota.getText().toString());
                            dao.insertar(c);
                            lista=dao.verTodo();
                            adapter.notifyDataSetChanged();
                            dialog.dismiss();
                        }catch (Exception e){
                            Toast.makeText(getApplication(), "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }
}