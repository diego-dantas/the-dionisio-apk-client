package com.the.dionisio.apk.client.dao.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.util.Util;

/**
 * Created by Daniel on 05/05/2017.
 */

public class PersonDAO {
    private SQLiteDatabase db;

    public PersonDAO(Context context){
        DataBase auxBd = new DataBase(context);
        db = auxBd.getWritableDatabase();
    }

    public void createPerson(Person person, Context context){
        ContentValues values = new ContentValues();

        values.put("name", person.name);
        values.put("email", person.email);
        values.put("password", person.password);
        values.put("cpf", person.cpf);
        //values.put("birth", Util.transformDate.getDateIntoString(person.birth));
        values.put("sex", person.sex);
        values.put("picture", person.picture);
        values.put("isActive", person.isActive);

        db.insert("person", null,values);
        Toast.makeText(context, "Successfully registered! ", Toast.LENGTH_SHORT).show();
    }

}
