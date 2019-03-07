package com.example.t25alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Staturday extends AppCompatActivity {
    private EditText etPes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staturday);
        etPes = findViewById(R.id.etPeso);
    }

    public void onClickDatosSemanales(View view) {
        String var_peso = etPes.getText().toString();
        if(var_peso.isEmpty()){
            Toast.makeText(this,"No hi ha cap dada a pes",Toast.LENGTH_SHORT).show();
        }
        else {
            int numero = Integer.parseInt(var_peso);
            Intent intent = new Intent(this,Grafico.class);
            intent.putExtra("variable_peso",numero);
            startActivity(intent);
        }
    }
}
