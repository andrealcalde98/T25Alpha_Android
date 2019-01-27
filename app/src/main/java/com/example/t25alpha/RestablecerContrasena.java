package com.example.t25alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class RestablecerContrasena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer_contrasena);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_crear_usuario:
                Intent intent = new Intent(this,CrearUsuari.class);
                startActivity(intent);
                return true;

            case R.id.menu_iniciar_sesion:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

}
