package com.example.t25alpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CrearUsuari extends AppCompatActivity {
private EditText nom,correu,sexe,edad,altura,password;
private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuari);
        nom =(EditText)findViewById(R.id.etNombreApellidos);
        correu =(EditText)findViewById(R.id.etCorreo);
        sexe =(EditText)findViewById(R.id.etSexo);
        edad=(EditText)findViewById(R.id.etEdad);
        altura =(EditText)findViewById(R.id.etAltura);
        password =(EditText)findViewById(R.id.etContrasena);
        btnRegistrar =(Button)findViewById(R.id.btnRegistrarUsuari);

        final BDProjecte bdprojecte = new BDProjecte(getApplicationContext());

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bdprojecte.agregarCampos(nom.getText().toString(), correu.getText().toString(),
                        sexe.getText().toString(), edad.getText().toString(),
                        altura.getText().toString(), password.getText().toString());
                        Toast.makeText(getApplicationContext(), "SE AGREGO CORRECTAMENTE", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
