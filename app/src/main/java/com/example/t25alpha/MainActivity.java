package com.example.t25alpha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    private Button btMostrar;
    private Button btAgregar;
    private Cursor validacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUsuario = (Button) findViewById(R.id.btnCrearUsuario);
        btnIniSesion = (Button) findViewById(R.id.btnIniciarSesion);
        olvidarPass = (TextView) findViewById(R.id.txtOlvidarCuenta);
        btMostrar = (Button) findViewById(R.id.btnMostrar);
        etUsuario = findViewById(R.id.eTUsername);
        etPassword = findViewById(R.id.eTPassword);
        btAgregar = findViewById(R.id.btnMostrar);

      /*  final BDProjecte bdprojecte = new BDProjecte(getApplicationContext());

        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BDModelo modelo = new BDModelo();
                bdprojecte.buscarUsuarios(modelo,etUsuario.getText().toString());
                etPassword.setText(modelo.getPassword());
            }
        });*/

        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BDMain.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LANG_CURRENT.equals("es") || LANG_CURRENT.equals("ca")) {
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
        BDProjecte bdprojecte = new BDProjecte(getApplicationContext());
        SQLiteDatabase db=bdprojecte.getWritableDatabase();
        String usuario = etUsuario.getText().toString();
        String password = etPassword.getText().toString();
        validacion=db.rawQuery("SELECT usuario,password FROM USUARIOS WHERE USUARIO='"+usuario+"'AND PASSWORD='"+password+"'",null);
            if(validacion.moveToFirst()) {
                String usua = validacion.getString(0);
                String pass = validacion.getString(1);
                if(usuario.equals(usua)&&password.equals(pass)){
                    Intent intent = new Intent(this, menuPrincipal.class);
                    startActivity(intent);

                    etUsuario.setText("");
                    etPassword.setText("");
                }
            }
            else{
                Toast.makeText(this, "USUARIO I/O CONTRASEÑA INCORRECTOS", Toast.LENGTH_SHORT).show();
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

