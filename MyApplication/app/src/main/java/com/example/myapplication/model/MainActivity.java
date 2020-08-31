package com.example.myapplication.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button CadastrarUser = findViewById(R.id.cad_usuario);
        Button CadastrarSensor = findViewById(R.id.cad_sensor);
        Button CadastrarEstacao = findViewById(R.id.cad_estacao);
        Button listarSensor = findViewById(R.id.listarSensor);

        CadastrarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, Create_user.class);
                startActivity(it);
            }
        });

        CadastrarSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, Create_sensor.class);
                startActivity(it);
            }
        });

        CadastrarEstacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, Create_estacao.class);
                startActivity(it);
            }
        });
        listarSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, List_sensor.class);
                startActivity(it);
            }
        });

    }
}