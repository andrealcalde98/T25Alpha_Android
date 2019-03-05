package com.example.t25alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PerfilActivity extends AppCompatActivity {

    EditText nomCogmon, correu, sexe, edat, altura, contrasenya;

    Button edita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        contrasenya = findViewById(R.id.etContrasena2);
        contrasenya.setEnabled(false);
        altura = findViewById(R.id.etAltura2);
        altura.setEnabled(false);
        edat = findViewById(R.id.etEdad2);
        edat.setEnabled(false);
        sexe = findViewById(R.id.etSexo2);
        sexe.setEnabled(false);
        correu = findViewById(R.id.etCorreo2);
        correu.setEnabled(false);
        nomCogmon = findViewById(R.id.etNombreApellidos2);
        nomCogmon.setEnabled(false);

        findViewById(R.id.btnEdita).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomCogmon.isEnabled();
                correu.isEnabled();
                sexe.isEnabled();
                edat.isEnabled();
                altura.isEnabled();
                contrasenya.isEnabled();

            }
        });

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





}
