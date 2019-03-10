package com.example.t25alpha;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {

    EditText nomCogmon, correu, sexe, edat, altura, contrasenya;
    TextView web;
    Button edita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        contrasenya = findViewById(R.id.etContrasena2);
        altura = findViewById(R.id.etAltura2);
        edat = findViewById(R.id.etEdad2);
        sexe = findViewById(R.id.etSexo2);
        correu = findViewById(R.id.etCorreo2);
        nomCogmon = findViewById(R.id.etNombreApellidos2);
        nomCogmon.setEnabled(false);
        edita = (Button) findViewById(R.id.btnEdita);
        web = findViewById(R.id.txt_web);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.rehabilitat.cat"));
                startActivity(intent);
            }
        });

        final BDProjecte bdprojecte = new BDProjecte(getApplicationContext());

        edita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdprojecte.editarDatos(nomCogmon.getText().toString(),correu.getText().toString(),sexe.getText().toString(),
                        edat.getText().toString(),altura.getText().toString(),contrasenya.getText().toString());
                Toast.makeText(getApplicationContext(),"DADES MODIFICADES CORRECTAMENT",Toast.LENGTH_SHORT).show();
            }
        });
        mostrarPerfil();
      // editarPerfil();
    }

    public void mostrarPerfil(){
        String recuperar_variable_usuario = getIntent().getStringExtra("variable_usuario_final");
        nomCogmon.setText(recuperar_variable_usuario);
        String recuperar_variable_correo = getIntent().getStringExtra("variable_correo_final");
        correu.setText(recuperar_variable_correo);
        String recuperar_variable_sexe = getIntent().getStringExtra("variable_sexe_final");
        sexe.setText(recuperar_variable_sexe);
        String recuperar_variable_edad = getIntent().getStringExtra("variable_edad_final");
        edat.setText(recuperar_variable_edad);
        String recuperar_variable_altura = getIntent().getStringExtra("variable_altura_final");
        altura.setText(recuperar_variable_altura);
        String recuperar_variable_password = getIntent().getStringExtra("variable_password_final");
        contrasenya.setText(recuperar_variable_password);
    }

    public void editarPerfil(){
        String restablecer_usuario = getIntent().getStringExtra("restablecer_usuario");
        nomCogmon.setText(restablecer_usuario);
        String restablecer_correo = getIntent().getStringExtra("restablecer_correo");
        correu.setText(restablecer_correo);
        String restablecer_sexe = getIntent().getStringExtra("restablecer_sexe");
        sexe.setText(restablecer_sexe);
        String restablcer_edad = getIntent().getStringExtra("restablecer_edad");
        edat.setText(restablcer_edad);
        String restablecer_altura = getIntent().getStringExtra("restablecer_altura");
        altura.setText(restablecer_altura);
        String restablcer_password = getIntent().getStringExtra("restablecer_password");
        contrasenya.setText(restablcer_password);

    }





}
