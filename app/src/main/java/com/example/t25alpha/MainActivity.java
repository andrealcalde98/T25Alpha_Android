package com.example.t25alpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private Button btnUsuario;
    private Button btnIniSesion;
    private TextView olvidarPass;
    private String LANG_CURRENT = "en";
    private EditText etUsuario;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUsuario = (Button) findViewById(R.id.btnCrearUsuario);
        btnIniSesion = (Button) findViewById(R.id.btnIniciarSesion);
        olvidarPass = (TextView) findViewById(R.id.txtOlvidarCuenta);
        etUsuario = findViewById(R.id.eTUsername);
        etPassword = findViewById(R.id.eTPassword);



        findViewById(R.id.btn_english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LANG_CURRENT.equals("es") || LANG_CURRENT.equals("ca") ) {
                    changeLang(MainActivity.this, "en");
                }
                finish();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.btn_catalan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LANG_CURRENT.equals("es") || LANG_CURRENT.equals("en")) {
                    changeLang(MainActivity.this, "ca");
                }
                finish();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        findViewById(R.id.btn_spanish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LANG_CURRENT.equals("en") || LANG_CURRENT.equals("ca")) {
                    changeLang(MainActivity.this, "es");
                }
                finish();
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }
    public void changeLang(Context context, String lang) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Language", lang);
        editor.apply();
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(newBase);
        LANG_CURRENT = preferences.getString("Language", "en");

        super.attachBaseContext(MyContextWrapper.wrap(newBase, LANG_CURRENT));
    }


    public void btnClickIniciarSesion(View view) {
        if(etUsuario.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this,"Tienes que escribir datos",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(view.getContext(), menuPrincipal.class);
            startActivity(intent);
        }
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

