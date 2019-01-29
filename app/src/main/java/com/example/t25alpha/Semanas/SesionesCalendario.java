package com.example.t25alpha.Semanas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.t25alpha.R;

import java.util.ArrayList;

public class SesionesCalendario extends AppCompatActivity  {
RecyclerView recycler;
    ArrayList<String> listaDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesiones_calendario);
        recycler = findViewById(R.id.rvSesiones);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        listaDatos = new ArrayList<String>();
        for (int i = 1; i <8; i++){
            listaDatos.add("Semana "+i+" ");
        }
        adaptadorSemanas adapter = new adaptadorSemanas(listaDatos);
        recycler.setAdapter(adapter);
    }
}
