package com.example.t25alpha;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button btnUsuario;
    private Button btnIniSesion;
    private TextView olvidarPass;
    private ImageView txtAngles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUsuario = (Button) findViewById(R.id.btnCrearUsuario);
        btnIniSesion = (Button) findViewById(R.id.btnIniciarSesion);
        olvidarPass = (TextView) findViewById(R.id.txtOlvidarCuenta);
        txtAngles = (ImageView) findViewById(R.id.imgAngles);
    }

    public void btnClickIniciarSesion(View view) {
    }

    public void btnCLickCrearUsuari(View view) {
        Intent intent = new Intent(view.getContext(), CrearUsuari.class);
        startActivity(intent);
    }

    public void imgIngles(View view) {
       /* Intent intent = new Intent(String.valueOf(Locale.ENGLISH));
        startActivity(intent);
        Locale locale = new Locale("en_EN");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        txtAngles.getResources().updateConfiguration(config, null);*/
    }

    public void linkOlvidePass(View view) {
        Intent intent = new Intent(view.getContext(), RestablecerContrasena.class);
        startActivity(intent);
    }
}
