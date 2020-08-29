package com.example.myapplication.model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.classes.Pessoa;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_user extends AppCompatActivity {
    private EditText nome, email,  senha, perfil;
    private Button botao_cadastrar;
    DatabaseReference myRef;
    Pessoa user;

    private FirebaseDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        nome = (EditText) findViewById(R.id.nome_user);
        email = (EditText) findViewById(R.id.email_user);
        senha = (EditText) findViewById(R.id.senha_user);
        perfil = (EditText) findViewById(R.id.perfil_user);
        botao_cadastrar = (Button) findViewById(R.id.btncad_usuario);

        database  =  FirebaseDatabase.getInstance();
        myRef= database.getReference();

        user = new Pessoa();

        botao_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeVal = nome.getText().toString();
                String emailVal = email.getText().toString();
                String senhaVal =  senha.getText().toString();
                String perfilVal = perfil.getText().toString();

                cad_user(nomeVal, emailVal, senhaVal, perfilVal);
            }
        });
    }

    public void cad_user(String nome, String email, String senha, String perfil){

        String key = myRef.child("user").push().getKey();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        user.setPerfil(perfil);

        myRef.child("user").child(key).setValue(user);
        Toast.makeText(this, "Usuário inserido",Toast.LENGTH_SHORT).show();

    }
}
