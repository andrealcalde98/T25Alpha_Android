package com.example.t25alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Staturday extends AppCompatActivity {
    private EditText etPes, etMuneca, etCintura, etTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staturday);
        etPes = findViewById(R.id.etPeso);
        etMuneca = findViewById(R.id.etMuneca);
        etCintura = findViewById(R.id.etCintura);
        etTiempo = findViewById(R.id.etTiempo);
    }

    public void onClickDatosSemanales(View view) {
        String var_peso = etPes.getText().toString();
        String var_muneca = etMuneca.getText().toString();
        String var_cintura = etCintura.getText().toString();
        String var_tiempo = etTiempo.getText().toString();
        int var_peso_num = Integer.parseInt(etPes.getText().toString());
        int var_muneca_num = Integer.parseInt(etMuneca.getText().toString());
        int var_cintura_num = Integer.parseInt(etCintura.getText().toString());
        int var_tiempo_num = Integer.parseInt(etTiempo.getText().toString());
        if(var_peso.isEmpty() || var_muneca.isEmpty() || var_cintura.isEmpty() || var_tiempo.isEmpty()){
            Toast.makeText(this,"NO HI HA CAP DADA A PES",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this,Grafico.class);
            intent.putExtra("variable_peso",var_peso_num);
            intent.putExtra("variable_muneca",var_muneca_num);
            intent.putExtra("variable_cintura",var_cintura_num);
            intent.putExtra("variable_tiempo",var_tiempo_num);
            startActivity(intent);
        }
    }
}
