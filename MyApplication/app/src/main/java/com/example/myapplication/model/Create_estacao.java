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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_estacao extends AppCompatActivity {
    private EditText nome, descricao, proprietario, localizacao;
    private Button btn_estacao;

    DatabaseReference ref_estacao;
    Estacao estacao;

    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_estacao);
        nome = (EditText) findViewById(R.id.nome_estacao);
        descricao = (EditText) findViewById(R.id.descricao_estacao);
        proprietario = (EditText) findViewById(R.id.proprietario_estacao);
        localizacao = (EditText) findViewById(R.id.localizacao_estacao);
        btn_estacao = (Button) findViewById(R.id.btncad_estacao);

        database  =  FirebaseDatabase.getInstance();
        ref_estacao= database.getReference();

        estacao = new Estacao();

        btn_estacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeVal = nome.getText().toString();
                String descricaoVal = descricao.getText().toString();
                String propVal =  proprietario.getText().toString();
                String locVal = localizacao.getText().toString();

                cad_estacao(nomeVal, descricaoVal, propVal, locVal);
            }
        });

    }

    public void cad_estacao(String nome, String descricao, String proprietario, String localizacao){

        String key = ref_estacao.child("estacao").push().getKey();
        estacao.setNome(nome);
        estacao.setDescricao(descricao);
        estacao.setProprietatio(proprietario);
        estacao.setLocalizacao(localizacao);

        ref_estacao.child("estacao").child(key).setValue(estacao);
        Toast.makeText(this, "Estação inserida",Toast.LENGTH_SHORT).show();

    }
}