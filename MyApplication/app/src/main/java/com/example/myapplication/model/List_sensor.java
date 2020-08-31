package com.example.myapplication.model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.classes.Sensor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class List_sensor extends AppCompatActivity{

    private FirebaseDatabase database;
    DatabaseReference myRef;
    private List<Sensor> listSensor = new ArrayList<Sensor>();
    ArrayAdapter<Sensor> arrayAdapterSensor;
    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sensor);
        lista = findViewById(R.id.listView);

        ListarDados();
    }

    public void ListarDados(){

        database  =  FirebaseDatabase.getInstance();
        myRef = database.getReference();

        System.out.println("passou aqui CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        myRef.child("sensor").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                listSensor.clear();

                for (DataSnapshot objSnapshot : snapshot.getChildren() ){
                    Sensor s = objSnapshot.getValue(Sensor.class);
                    listSensor.add(s);

                    arrayAdapterSensor = new ArrayAdapter(List_sensor.this,android.R.layout.simple_list_item_1, listSensor);
                    lista.setAdapter(arrayAdapterSensor);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}