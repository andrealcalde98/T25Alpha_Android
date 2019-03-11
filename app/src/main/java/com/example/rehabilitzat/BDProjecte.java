package com.example.rehabilitzat;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BDProjecte extends SQLiteOpenHelper {
    private static final String NOM_BD="ControlBD";
    private static final int VERSION_BD=1;
    private static final String TAULA_BD="CREATE TABLE USUARIOS(USUARIO TEXT PRIMARY KEY, CORREO TEXT, SEXE TEXT, EDAD TEXT, ALTURA TEXT, PASSWORD TEXT)";

    public BDProjecte(Context context){
        super(context,NOM_BD,null,VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAULA_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USUARIOS"+TAULA_BD);
        db.execSQL(TAULA_BD);
    }

    public void agregarCampos(String usuario,String correo, String sexe, String edad, String altura,String password){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO USUARIOS VALUES('"+usuario+"','"+correo+"','"+sexe+"','"+edad+"','"+altura+"','"+password+"')");
            bd.close();
        }
    }

    public List<BDModelo> mostrarUsuarios(){
        SQLiteDatabase bd=getWritableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM USUARIOS",null);
        List<BDModelo> usuarios= new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                usuarios.add(new BDModelo(cursor.getString(0),cursor.getString(1)
                ,cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getString(5)));
            }while (cursor.moveToNext());
        }
        return usuarios;
    }

    public void editarDatos(String usuario,String correo, String sexe, String edad, String altura,String password){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("UPDATE USUARIOS SET CORREO='"+correo+"',SEXE='"+sexe+"',EDAD='"+edad+"',ALTURA='"+altura+"',PASSWORD='"+password+"'WHERE USUARIO='"+usuario+"'");
            bd.close();
        }
    }
}
