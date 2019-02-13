package com.example.t25alpha;

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

    public void onClickPerfil(View view) {
        Intent intent = new Intent(view.getContext(), PerfilActivity.class);
        startActivity(intent);
    }
}
