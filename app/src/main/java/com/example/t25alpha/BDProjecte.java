package com.example.t25alpha;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BDProjecte extends SQLiteOpenHelper {
    private static final String NOM_BD="Reabilitat";
    private static final int VERSION_BD=1;
    private static final String TAULA_BD="CREATE TABLE CAMPOS(USUARIO TEXT PRIMARY KEY, PASSWORD TEXT)";

    public BDProjecte(Context context){
        super(context,NOM_BD,null,VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAULA_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CAMPOS"+TAULA_BD);
        db.execSQL(TAULA_BD);
    }

    public void agregarCampos(String usuario, String password){
        SQLiteDatabase bd=getWritableDatabase();
        if(bd!=null){
            bd.execSQL("INSERT INTO CAMPOS VALUES('"+usuario+"','"+password+"')");
            bd.close();
        }
    }

    public List<BDModelo> mostrarUsuarios(){
        SQLiteDatabase bd=getWritableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM CAMPOS",null);
        List<BDModelo> usuarios= new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                usuarios.add(new BDModelo(cursor.getString(0),cursor.getString(1)));
            }while (cursor.moveToNext());
        }
        return usuarios;
    }

    public void buscarUsuarios(BDModelo modelo, String usuario){
        SQLiteDatabase bd=getWritableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM CAMPOS WHERE USUARIO='"+usuario+"'",null);
        if(cursor.moveToFirst()){
            do {
                modelo.setPassword(cursor.getString(1));
            }while (cursor.moveToNext());
        }
    }
}
