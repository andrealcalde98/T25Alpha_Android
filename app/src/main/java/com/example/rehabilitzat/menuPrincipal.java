package com.example.rehabilitzat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void onClickCalendari(View view) {
        Intent intent = new Intent(view.getContext(), Main_semanas.class);
        startActivity(intent);
    }

    public void onClickVideo(View view) {
        Intent intent = new Intent(view.getContext(), Videos.class);
        startActivity(intent);
    }

    public void onClickPerfil(View view) {
        String recuperar_variable_usuario = getIntent().getStringExtra("variable_usuario");
        String recuperar_variable_password = getIntent().getStringExtra("variable_password");
        String recuperar_variable_correo = getIntent().getStringExtra("variable_correo");
        String recuperar_variable_sexe = getIntent().getStringExtra("variable_sexe");
        String recuperar_variable_edad = getIntent().getStringExtra("variable_edad");
        String recuperar_variable_altura = getIntent().getStringExtra("variable_altura");
        Intent intent = new Intent(view.getContext(), PerfilActivity.class);
        intent.putExtra("variable_usuario_final",recuperar_variable_usuario);
        intent.putExtra("variable_password_final",recuperar_variable_password);
        intent.putExtra("variable_correo_final",recuperar_variable_correo);
        intent.putExtra("variable_sexe_final",recuperar_variable_sexe);
        intent.putExtra("variable_edad_final",recuperar_variable_edad);
        intent.putExtra("variable_altura_final",recuperar_variable_altura);
        startActivity(intent);
    }

    public void onClickStaturday(View view) {
        Intent intent = new Intent(this,Staturday.class);
        startActivity(intent);

    }

    public void onClickGrafica(View view) {
        Intent intent = new Intent(this, Grafico.class);
        startActivity(intent);
    }
}
