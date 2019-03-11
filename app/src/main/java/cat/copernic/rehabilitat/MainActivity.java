package cat.copernic.rehabilitat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private Button btnUsuario;
    private Button btnIniSesion;
    private TextView olvidarPass;
    private String LANG_CURRENT = "en";
    private EditText etUsuario;
    private EditText etPassword;
    private Cursor validacion;
    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUsuario = (Button) findViewById(R.id.btnCrearUsuario);
        btnIniSesion = (Button) findViewById(R.id.btnIniciarSesion);
        olvidarPass = (TextView) findViewById(R.id.txtOlvidarCuenta);
        etUsuario = findViewById(R.id.eTUsername);
        etPassword = findViewById(R.id.eTPassword);
        logo = (ImageView) findViewById(R.id.image_logo);
        //rotacion();

        findViewById(R.id.btn_english).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LANG_CURRENT.equals("es") || LANG_CURRENT.equals("ca")) {
                    changeLang(getBaseContext(), "en");
                    updateResources(getBaseContext(), "en");
                }
                recreate();
                startActivity(new Intent(MainActivity.this, MainActivity.class));

            }
        });

        findViewById(R.id.btn_catalan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LANG_CURRENT.equals("es") || LANG_CURRENT.equals("en")) {
                    changeLang(getBaseContext(), "ca");
                    updateResources(getBaseContext(), "ca");
                }
                recreate();
                startActivity(new Intent(MainActivity.this, MainActivity.class));

            }
        });

        findViewById(R.id.btn_spanish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LANG_CURRENT.equals("en") || LANG_CURRENT.equals("ca")) {
                    changeLang(MainActivity.this, "es");
                    updateResources(getBaseContext(), "es");
                }
                recreate();
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
        LANG_CURRENT = preferences.getString("Language", "ca");

        super.attachBaseContext(MyContextWrapper.wrap(newBase, LANG_CURRENT));
    }

    private static boolean updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return true;
    }


    public void btnClickIniciarSesion(View view) {
        BDProjecte bdprojecte = new BDProjecte(getApplicationContext());
        SQLiteDatabase db=bdprojecte.getWritableDatabase();
        String usuario = etUsuario.getText().toString();
        String password = etPassword.getText().toString();
        validacion=db.rawQuery("SELECT usuario,password,correo,sexe,edad,altura FROM USUARIOS WHERE USUARIO='"+usuario+"'AND PASSWORD='"+password+"'",null);
            if(validacion.moveToFirst()) {
                String usua = validacion.getString(0);
                String pass = validacion.getString(1);
                String corr = validacion.getString(2);
                String sex = validacion.getString(3);
                String eda = validacion.getString(4);
                String altu = validacion.getString(5);
                if(usuario.equals(usua)&&password.equals(pass)){
                    rotacion();
                    Intent intent = new Intent(this, menuPrincipal.class);
                    intent.putExtra("variable_usuario",usua);
                    intent.putExtra("variable_password",pass);
                    intent.putExtra("variable_correo",corr);
                    intent.putExtra("variable_sexe",sex);
                    intent.putExtra("variable_edad",eda);
                    intent.putExtra("variable_altura",altu);
                    startActivity(intent);

                    etUsuario.setText("");
                    etPassword.setText("");
                }
            }
            else{
                Toast.makeText(this, R.string.usuario_incorrecto, Toast.LENGTH_SHORT).show();
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

    public void rotacion(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotacion);
        animation.setFillAfter(true);
        logo.startAnimation(animation);

    }
    }


