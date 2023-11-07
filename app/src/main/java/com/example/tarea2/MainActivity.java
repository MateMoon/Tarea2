package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {

    ProgressBar pb1;
    Button btn1;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pb1);
        btn1 = findViewById(R.id.btn_ingresar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pb1.setVisibility(View.VISIBLE);

                Timer timer = new Timer();
                TimerTask timertask = new TimerTask() {
                    @Override
                    public void run() {

                        counter++;

                        pb1.setProgress(counter);
                        if (counter == 50) {
                            timer.cancel();

                            Intent Ingresar = new Intent(MainActivity.this, Lista.class);
                            startActivity(Ingresar);
                        }
                    }
                };
                timer.schedule(timertask,50,50);
            }
        });
    }
}