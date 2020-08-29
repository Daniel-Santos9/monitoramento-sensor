package com.example.myapplication.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.classes.Estacao;
import com.example.myapplication.model.classes.Pessoa;
import com.example.myapplication.model.classes.Sensor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_sensor extends AppCompatActivity {
    private EditText nome, tipo_saida, range, velocidade_respota, unidade_medida, localizacao, status;
    private Button btn_sensor;

    DatabaseReference ref_sensor;
    Sensor sensor;

    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sensor);
        nome = (EditText) findViewById(R.id.nome_sensor);
        tipo_saida = (EditText) findViewById(R.id.saida_sensor);
        range = (EditText) findViewById(R.id.alcance_sensor);
        velocidade_respota = (EditText) findViewById(R.id.velocidade_sensor);
        unidade_medida = (EditText) findViewById(R.id.unidade_sensor);
        localizacao = (EditText) findViewById(R.id.localizacao_sensor);
        status = (EditText) findViewById(R.id.status_sensor);
        btn_sensor = (Button) findViewById(R.id.btn_sensor);


        database  =  FirebaseDatabase.getInstance();
        ref_sensor= database.getReference();

        sensor = new Sensor();

        btn_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeVal = nome.getText().toString();
                String tipo_saidaVal = tipo_saida.getText().toString();
                String rangeVal =  range.getText().toString();
                String VelocidadeVal = velocidade_respota.getText().toString();
                String uniMedVal = unidade_medida.getText().toString();
                String locVal = localizacao.getText().toString();
                String statusval = status.getText().toString();

                cad_sensor(nomeVal, tipo_saidaVal, rangeVal, VelocidadeVal, uniMedVal, locVal, statusval);
            }
        });

    }

    public void cad_sensor(String nome, String tipo_saida, String range, String Velocidade, String unidade_medida, String local, String status){

        String key = ref_sensor.child("sensor").push().getKey();
        sensor.setNome(nome);
        sensor.setTipo_saida(tipo_saida);
        sensor.setRange(range);
        sensor.setVelocidade_resposta(Velocidade);
        sensor.setUnidade_medida(unidade_medida);
        sensor.setLocalizacao(local);
        sensor.setStatus(status);


        ref_sensor.child("sensor").child(key).setValue(sensor);
        Toast.makeText(this, "Sensor inserido",Toast.LENGTH_SHORT).show();

    }
}