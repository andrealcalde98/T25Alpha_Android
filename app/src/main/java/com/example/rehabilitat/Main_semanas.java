package com.example.rehabilitat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.rehabilitat.R;

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
        items.add(new Semanas(getString(R.string.semana)+" "+1, R.drawable.pesas));
        items.add(new Semanas(getString(R.string.semana)+" "+2, R.drawable.pesas));
        items.add(new Semanas(getString(R.string.semana)+" "+3, R.drawable.pesas));
        items.add(new Semanas(getString(R.string.semana)+" "+4, R.drawable.pesas));
        items.add(new Semanas(getString(R.string.semana)+" "+5, R.drawable.pesas));
        items.add(new Semanas(getString(R.string.semana)+" "+6, R.drawable.pesas));
        items.add(new Semanas(getString(R.string.semana)+" "+7, R.drawable.pesas));
        return items;

}
    }


