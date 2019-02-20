package com.example.t25alpha;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.t25alpha.R;
import com.example.t25alpha.Semanas;

import java.util.ArrayList;

public class Main_semanas extends AppCompatActivity {
    private RecyclerView rvMusicas;
    private GridLayoutManager glm;
    private adaptadorSemanas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesiones_calendario);

        rvMusicas = (RecyclerView) findViewById(R.id.rvSesiones);

        glm = new GridLayoutManager(this, 1);
        rvMusicas.setLayoutManager(glm);
        adapter = new adaptadorSemanas(dataSet(),this);
        rvMusicas.setAdapter(adapter);


    }


    private ArrayList<Semanas>dataSet(){
        ArrayList<Semanas> items = new ArrayList<>();
        items.add(new Semanas("Semana 1", R.drawable.ic_hombrepesas));
        items.add(new Semanas("Semana 2", R.drawable.ic_hombrepesas));
        items.add(new Semanas("Semana 3", R.drawable.ic_hombrepesas));
        items.add(new Semanas("Semana 4", R.drawable.ic_hombrepesas));
        items.add(new Semanas("Semana 5", R.drawable.ic_hombrepesas));
        items.add(new Semanas("Semana 6", R.drawable.ic_hombrepesas));
        items.add(new Semanas("Semana 7", R.drawable.ic_hombrepesas));
        return items;

}
    }


