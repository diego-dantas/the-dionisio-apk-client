package com.the.dionisio.apk.client.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 05/05/2017.
 */

public class DataBase extends SQLiteOpenHelper {
    private static final String NOME_BD = "dbTheDionisio";
    private static final int VERSAO_BD = 1;

    public DataBase(Context ctx){
        super(ctx, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person("
                + "_idPerson integer primary key autoincrement,"
                + "name text not null,"
                + "email text not null,"
                + "password text not null,"
                + "cpf integer,"
                + "sex text,"
                + "isActive text,"
                + "picture text);"
        );

        db.execSQL("create table birth("
                + "_idBirth integer primary key autoincrement,"
                + "_idPerson integer foreign key"
                + "birth text,"
                + "FOREIGN KEY(_idPerson) REFERENCES person(_idPerson)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("drop table ;");
        onCreate(db);
    }
}
