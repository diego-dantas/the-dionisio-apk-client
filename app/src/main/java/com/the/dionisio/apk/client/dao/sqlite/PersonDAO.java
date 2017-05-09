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
        DataBase auxBd = new DataBase(context);
        db = auxBd.getWritableDatabase();
    }

    public void createPerson(Person person){
        db.isOpen();
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

    public void createGenre(Person person, Context context){
        db.isOpen();
        ContentValues values = new ContentValues();

        values.put("_idPerson", person._id);
        values.put("genre", String.valueOf(person.genres));

        db.insert("genre", null, values);
        db.close();
        Toast.makeText(context, "Successfully registered! ", Toast.LENGTH_SHORT).show();
    }

    public void updatePerson(Person person){
        db.isOpen();
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

    public void updateGenre(Person person){
        db.isOpen();
        ContentValues values = new ContentValues();

        values.put("genre", String.valueOf(person.genres));

        db.update("genre", values, "_idPerson = ?", new String[]{"" + person._id});
        db.close();
    }

    public void deletePerson(Person person){
        db.isOpen();
        db.delete("person", "_idPerson = " + person._id, null);
        db.close();
    }

    public void deleteGenre(Person person){
        db.isOpen();
        db.delete("genre", "_idPerson = " + person._id, null);
        db.close();
    }

    public void searchPerson(Person person){
        db.isOpen();
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

    public void searchGenre(Person person){
        db.isOpen();
        String genre;

        Cursor findGenre = db.rawQuery("SELECT * FROM genre WHERE _idPerson = " + person._id, null);

        if(findGenre.moveToNext())
        {
            genre = findGenre.getString(findGenre.getColumnIndex("genre"));
        }
        db.close();
    }
}
