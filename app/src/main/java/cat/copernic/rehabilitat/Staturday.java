package cat.copernic.rehabilitat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.File;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Staturday extends AppCompatActivity {
    private EditText etPes, etMuneca, etCintura, etTiempo;
    private final String CARPETA_RAIZ="misImagenesPrueba/";
    private final String RUTA_IMAGEN=CARPETA_RAIZ+"misFotos";

    final int COD_SELECCIONA=10;
    final int COD_FOTO=20;

    Button botonCargar;
    ImageView imagen;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staturday);
        etPes = findViewById(R.id.etPeso);
        etMuneca = findViewById(R.id.etMuneca);
        etCintura = findViewById(R.id.etCintura);
        etTiempo = findViewById(R.id.etTiempo);

        imagen = findViewById(R.id.IMG);
        botonCargar = findViewById(R.id.camara);

        if(validaPermisos()){
            botonCargar.setEnabled(true);

        }else {
            botonCargar.setEnabled(false);
        }
    }

    private boolean validaPermisos() {

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if((checkSelfPermission(CAMERA)== PackageManager.PERMISSION_GRANTED)&&
                (checkSelfPermission(WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
            return true;
        }

        if((shouldShowRequestPermissionRationale(CAMERA)) ||
                (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))){
             cargarDialogoRecomendacion();
        }else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
        }

        return false;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){
            if(grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                botonCargar.setEnabled(true);
            }else{
                solicitarPermisosManual();
            }
        }

    }

     private void solicitarPermisosManual() {
        final CharSequence[] opciones={"si","no"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(Staturday.this);
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")){
                    Intent intent=new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri=Uri.fromParts("package",getPackageName(),null);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Los permisos no fueron aceptados",Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder diag = new AlertDialog.Builder(Staturday.this);
        diag.setTitle("Permisos Desactivados");
        diag.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        diag.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
                }
            }
        });
        diag.show();
    }

    public void onclick(View view) {
        cargarImagen();
    }

    private void cargarImagen() {

        final CharSequence[] opciones={getString(R.string.tomarfoto),getString(R.string.carregaIMG),getString(R.string.surt)};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(Staturday.this);
        alertOpciones.setTitle(getString(R.string.escogeOpcion));
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Fer Foto") || opciones[i].equals("Hacer Foto") || opciones[i].equals("Take Photo")){
                    tomarFotografia();
                }else{
                    if (opciones[i].equals("Carrega Imatge") || opciones[i].equals("Sube Foto") || opciones[i].equals("Add Photo")){
                        Intent intent=new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        //intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent,":)"),COD_SELECCIONA);
                    }else{
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();

    }
    private void tomarFotografia() {
        File fileImagen=new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);
        boolean isCreada=fileImagen.exists();
        String nombreImagen="";
        if(isCreada==false){
            isCreada=fileImagen.mkdirs();
        }

        if(isCreada==true){
            nombreImagen=(System.currentTimeMillis()/1000)+".jpg";
        }


        path=Environment.getExternalStorageDirectory()+
                File.separator+RUTA_IMAGEN+File.separator+nombreImagen;
        File imagen = new File(path);


        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            String authorities=getApplicationContext().getPackageName()+".provider";
            Uri imageUri= FileProvider.getUriForFile(this,authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else
        {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent,COD_FOTO);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){

            switch (requestCode){
                case COD_SELECCIONA:
                    Uri miPath=data.getData();
                    imagen.setImageURI(miPath);
                    break;

                case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("R","Path: "+path);
                                }
                            });

                Bitmap bitmap= BitmapFactory.decodeFile(path);

                //Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                imagen.setImageBitmap(bitmap);
                    break;
            }


       }
    }

    public void onClickDatosSemanales(View view) {
        String var_peso = etPes.getText().toString();
        String var_muneca = etMuneca.getText().toString();
        String var_cintura = etCintura.getText().toString();
        String var_tiempo = etTiempo.getText().toString();
        int var_peso_num = Integer.parseInt(etPes.getText().toString());
        int var_muneca_num = Integer.parseInt(etMuneca.getText().toString());
        int var_cintura_num = Integer.parseInt(etCintura.getText().toString());
        int var_tiempo_num = Integer.parseInt(etTiempo.getText().toString());
        if(var_peso.isEmpty() || var_muneca.isEmpty() || var_cintura.isEmpty() || var_tiempo.isEmpty()){
            Toast.makeText(this,"NO HI HA CAP DADA A PES",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this,Grafico.class);
            intent.putExtra("variable_peso",var_peso_num);
            intent.putExtra("variable_muneca",var_muneca_num);
            intent.putExtra("variable_cintura",var_cintura_num);
            intent.putExtra("variable_tiempo",var_tiempo_num);
            startActivity(intent);
        }
    }
}