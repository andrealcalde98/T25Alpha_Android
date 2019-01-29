package com.example.t25alpha;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Image;
import android.os.LocaleList;
import android.support.v4.os.LocaleListCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button btnUsuario;
    private Button btnIniSesion;
    private TextView olvidarPass;
    private Button btnEnglish;
    private Button btnCatalan;
    private Button btnSpanish;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUsuario = (Button) findViewById(R.id.btnCrearUsuario);
        btnIniSesion = (Button) findViewById(R.id.btnIniciarSesion);
        olvidarPass = (TextView) findViewById(R.id.txtOlvidarCuenta);
        btnCatalan = (Button) findViewById(R.id.btn_catalan);
        btnSpanish = (Button) findViewById(R.id.btn_spanish);
        btnEnglish = (Button) findViewById(R.id.btn_english);
            }


    public void changeEnglish(View view) {
        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale("en", "EN");
        res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_main);
    }
    public void changeCatalan(View view) {
        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale("ca","ES");
        res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_main);
    }
    public void changeSpanish(View view) {
        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = Locale.getDefault();
        res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_main);
    }

    public void btnClickIniciarSesion(View view) {
        Intent intent = new Intent(view.getContext(), menuPrincipal.class);
        startActivity(intent);
    }

    public void btnCLickCrearUsuari(View view) {
        Intent intent = new Intent(view.getContext(), CrearUsuari.class);
        startActivity(intent);
    }

    public void linkOlvidePass(View view) {
        Intent intent = new Intent(view.getContext(), RestablecerContrasena.class);
        startActivity(intent);
    }


}

