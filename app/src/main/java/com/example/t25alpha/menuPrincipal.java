package com.example.t25alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.t25alpha.Semanas.SesionesCalendario;

public class menuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void onClickCalendari(View view) {
        Intent intent = new Intent(view.getContext(), SesionesCalendario.class);
        startActivity(intent);
    }
}
