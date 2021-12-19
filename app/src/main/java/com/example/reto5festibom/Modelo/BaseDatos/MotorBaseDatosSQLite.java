package com.example.reto5festibom.Modelo.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MotorBaseDatosSQLite extends SQLiteOpenHelper {

    public MotorBaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TABLA FAVORITOS
        db.execSQL("CREATE TABLE favoritos (id INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        /*
        db.execSQL("INSERT INTO favoritos VALUES (1, 'Amigos','Puedes compartir con tus amigos')");
        db.execSQL("INSERT INTO favoritos VALUES (2, 'Parejas','Lo mejor para tú pareja')");
        db.execSQL("INSERT INTO favoritos VALUES (3, 'Cumpleaños','Eventos especiales')");
        */

        //TABLA PRODUCTOS
        db.execSQL("CREATE TABLE productos (imagen INT, titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO productos VALUES (0, 'Familiar','Lo mejor para tú familia')");
        db.execSQL("INSERT INTO productos VALUES (1, 'Empresarial','Lo mejor para tú empresa')");

        //TABLA SERVICIOS
        db.execSQL("CREATE TABLE servicios (titulo TEXT,descripcion TEXT)");
        //---- Registros
        db.execSQL("INSERT INTO servicios VALUES ( 'Comidas','Toda clase de comidas Tipicas e Internacionales')");
        db.execSQL("INSERT INTO servicios VALUES ( 'Ambientes','Los mejores ambientes y decoración')");
        db.execSQL("INSERT INTO servicios VALUES ( 'Música','Las mejores orquestas y música')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE favoritos");
        db.execSQL("DROP TABLE productos");
        db.execSQL("DROP TABLE servicios");
        onCreate(db);

    }
}
