package cat.copernic.rehabilitat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RestablecerContrasena extends AppCompatActivity {
private Button btBuscar;
private EditText etRestablecer;
private Cursor validacion;
    private String LANG_CURRENT = "en";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer_contrasena);
        btBuscar = findViewById(R.id.btnBuscar);
        etRestablecer = findViewById(R.id.eTrestablecerContra);
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

    public void onClickBuscar(View view) {
        BDProjecte bdprojecte = new BDProjecte(getApplicationContext());
        SQLiteDatabase db=bdprojecte.getWritableDatabase();
        String restablecer = etRestablecer.getText().toString();
        validacion=db.rawQuery("SELECT usuario,password,correo,sexe,edad,altura FROM USUARIOS WHERE CORREO='"+restablecer+"'",null);
        if(validacion.moveToLast()) {
            String usua = validacion.getString(0);
            String pass = validacion.getString(1);
            String corr = validacion.getString(2);
            String sex = validacion.getString(3);
            String eda = validacion.getString(4);
            String altu = validacion.getString(5);
            if(restablecer.equals(corr)){

                Intent intent = new Intent(this, PerfilActivity.class);
                intent.putExtra("variable_usuario_final",usua);
                intent.putExtra("variable_password_final",pass);
                intent.putExtra("variable_correo_final",corr);
                intent.putExtra("variable_sexe_final",sex);
                intent.putExtra("variable_edad_final",eda);
                intent.putExtra("variable_altura_final",altu);
                startActivity(intent);

                etRestablecer.setText("");
            }
        }
        else{
            Toast.makeText(this, "EL CORREO NO EXISTE, VUELVE A INTRODUCIR EL CORREO", Toast.LENGTH_SHORT).show();
        }
    }
}