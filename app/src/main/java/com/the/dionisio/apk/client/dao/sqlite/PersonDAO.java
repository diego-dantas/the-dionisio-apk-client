package com.the.dionisio.apk.client.dao.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.the.dionisio.apk.client.model.dto.Person;

/**
 * Created by Daniel on 05/05/2017.
 */

public class PersonDAO {
    private SQLiteDatabase db;

    public PersonDAO(Context context){
        DataBase auxBd = new DataBase(context);
        db = auxBd.getWritableDatabase();
    }

    public void createPerson(Person person){
        ContentValues values = new ContentValues();

        values.put("name", person.name);
        values.put("email", person.email);
        values.put("password", person.password);
        values.put("cpf", person.cpf);
        values.put("sex", person.sex);
        values.put("isActive", person.isActive);
        db.insert("person", null,values);
    }

}
