package com.the.dionisio.apk.client.dao.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        DataBase dataBase = new DataBase(context);
        db = dataBase.getWritableDatabase();
    }

    public void createPerson(Person person){
        ContentValues values = new ContentValues();

        values.put("_idPerson", person._id);
        values.put("name", person.name);
        values.put("email", person.email);
        values.put("password", person.password);
        values.put("cpf", person.cpf);
        values.put("birth", Util.transformDate.getDateIntoString(person.birth));
        values.put("sex", person.sex);
        values.put("picture", person.picture);
        values.put("isActive", person.isActive);

        db.insert("person", null,values);
        db.close();
    }

    public void updatePerson(Person person){
        ContentValues values = new ContentValues();

        values.put("name", person.name);
        values.put("email", person.email);
        values.put("password", person.password);
        values.put("cpf", person.cpf);
        values.put("birth", Util.transformDate.getDateIntoString(person.birth));
        values.put("sex", person.sex);
        values.put("picture", person.picture);
        values.put("isActive", person.isActive);

        db.update("person", values, "_idPerson = ?", new String[]{"" + person._id});
        db.close();
    }

    public void deletePerson(Person person){
        db.delete("person", "_idPerson = " + person._id, null);
        db.close();
    }

    public void searchPerson(Person person){
         String name;
         String email;
         String password;
         String birth;
         String cpf;
         String sex;
         String picture;
         String isActive;

        Cursor findPerson = db.rawQuery("SELECT * FROM person WHERE _idPerson = " + person._id,null);

        if(findPerson.moveToNext())
        {
            name = findPerson.getString(findPerson.getColumnIndex("name"));
            email = findPerson.getString(findPerson.getColumnIndex("email"));
            password = findPerson.getString(findPerson.getColumnIndex("password"));
            birth = findPerson.getString(findPerson.getColumnIndex("birth"));
            cpf = findPerson.getString(findPerson.getColumnIndex("cpf"));
            sex = findPerson.getString(findPerson.getColumnIndex("sex"));
            picture = findPerson.getString(findPerson.getColumnIndex("picture"));
            isActive = findPerson.getString(findPerson.getColumnIndex("isActive"));
        }
        db.close();
    }
}
