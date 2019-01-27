package com.example.t25alpha;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button btnUsuario;
    private Button btnIniSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUsuario = (Button) findViewById(R.id.btnCrearUsuario);
        btnIniSesion = (Button) findViewById(R.id.btnIniciarSesion);

    }

    public void btnClickIniciarSesion(View view) {
        Locale localizacion = new Locale("en", "EN");
        Locale.setDefault(localizacion);
        Configuration config = new Configuration();
        config.locale = localizacion;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
    }

    public void btnCLickCrearUsuari(View view) {
        Intent intent = new Intent(view.getContext(), CrearUsuari.class);
        startActivity(intent);
    }

    public void imgIngles(View view) {
        Locale localizacion = new Locale("ja", "JA");
        Locale.setDefault(localizacion);
        Configuration config = new Configuration();
        config.locale = localizacion;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
    }
}
