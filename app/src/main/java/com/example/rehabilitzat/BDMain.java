package com.example.rehabilitzat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class BDMain extends AppCompatActivity {
private RecyclerView recyclerViewBD;
private BDAdaptador adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_bd);

        BDProjecte bdProjecte = new BDProjecte(getApplicationContext());

        recyclerViewBD = (RecyclerView)findViewById(R.id.recyclerbd);
        recyclerViewBD.setLayoutManager(new LinearLayoutManager(this));

        adapter=new BDAdaptador(bdProjecte.mostrarUsuarios());
        recyclerViewBD.setAdapter(adapter);
    }
}
