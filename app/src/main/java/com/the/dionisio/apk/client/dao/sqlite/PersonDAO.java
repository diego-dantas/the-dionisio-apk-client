package com.the.dionisio.apk.client.dao.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.presenter.Presenter;
import com.the.dionisio.apk.client.util.Util;


/**
 * Created by Daniel on 05/05/2017.
 */

public class PersonDAO
{
    private SQLiteDatabase db;
    private Context contextView;

    public PersonDAO(Context context)
    {
        DataBase dataBase = new DataBase(context);
        db = dataBase.getWritableDatabase();
        contextView = context;
    }

    public void createPerson(Person person)
    {
        ContentValues values = new ContentValues();

        values.put("_idPerson", person._id);
        values.put("name", person.name);
        values.put("email", person.email);
        values.put("password", person.password);
        values.put("cpf", person.cpf);
        values.put("birth", Util.transformDate.getDateIntoString(person.birth));
        values.put("sex", person.sex);
        values.put("picture", person.picture);
        values.put("isActive", ((person.isActive) ? 1 : 0));

        GenreDAO genre = new GenreDAO(contextView);
        genre.createGenre(person);

        db.insert("person", null,values);
        db.close();

        Presenter.login.resultLoginOk(person, contextView);
    }

    public void updatePerson(Person person)
    {
        ContentValues values = new ContentValues();

        values.put("name", person.name);
        values.put("email", person.email);
        values.put("password", person.password);
        values.put("cpf", person.cpf);
        values.put("birth", Util.transformDate.getDateIntoString(person.birth));
        values.put("sex", person.sex);
        values.put("picture", person.picture);
        values.put("isActive", ((person.isActive) ? 1 : 0));

        db.update("person", values, "_idPerson = ?", new String[]{"" + person._id});
        db.close();
    }

    public void deletePerson(Person person)
    {
        db.delete("person", "_idPerson = " + person._id, null);
        db.close();
    }

    public Person findPersonBy_id(Person person)
    {
        Cursor findPerson = db.rawQuery("SELECT * FROM person WHERE _idPerson = " + person._id,null);

        if(findPerson.moveToNext())
        {
            GenreDAO genre = new GenreDAO(contextView);

            person.name = findPerson.getString(findPerson.getColumnIndex("name"));
            person.email = findPerson.getString(findPerson.getColumnIndex("email"));
            person.password = findPerson.getString(findPerson.getColumnIndex("password"));
            person.birth = Util.transformDate.getDateIntoList(findPerson.getString(findPerson.getColumnIndex("birth")));
            person.cpf = findPerson.getString(findPerson.getColumnIndex("cpf"));
            person.sex = findPerson.getString(findPerson.getColumnIndex("sex"));
            person.picture = findPerson.getString(findPerson.getColumnIndex("picture"));
            person.genres = genre.searchGenre(person);
            person.isActive = findPerson.getInt(findPerson.getColumnIndex("isActive")) == 1 ? true : false;
        }

        db.close();

        return person;
    }

    public Boolean findPersonByEmail(Person person)
    {
        Cursor findPerson = db.rawQuery("SELECT * FROM person WHERE email = ?", new String[]{person.email});

        if(findPerson != null)
        {
            while(findPerson.moveToFirst())
            {
                db.close();
                return true;
            }
        }

        db.close();
        return false;
    }
}
