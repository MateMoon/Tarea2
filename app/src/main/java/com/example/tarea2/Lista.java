package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
    }

    public void Reserva (View view){
        Intent Ingresar = new Intent(this, Reserva.class);
        startActivity(Ingresar);
    }

    public void Locales (View view){
        Intent locales = new Intent(this, Local.class);
        startActivity(locales);
    }

}