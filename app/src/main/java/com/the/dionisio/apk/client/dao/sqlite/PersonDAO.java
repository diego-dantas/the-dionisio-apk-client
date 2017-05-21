package com.the.dionisio.apk.client.dao.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

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
        contextView = context;
    }

    public void createPerson(Person person)
    {
        ContentValues values = getContentValues(person);
        db = getDataBase();
        try
        {
            db.insert("person", null,values);
        }
        catch (Exception e)
        {

        }
        db.close();

        GenreDAO genre = new GenreDAO(contextView);
        genre.createGenre(person);

        Presenter.login.resultLoginOk(person, contextView);
    }

    public void updatePerson(Person person)
    {
        ContentValues values = getContentValues(person);
        db = getDataBase();
        try
        {
            db.update("person", values, "_idPerson = ?", new String[]{"" + person._id});
        }
        catch (Exception e)
        {

        }
        db.close();
    }

    public void deletePerson(Person person)
    {
        db = getDataBase();

        try
        {
            db.delete("person", "_idPerson = " + person._id, null);
        }
        catch (Exception e)
        {

        }

        db.close();
    }

    public Person findPersonBy_id(Person person)
    {
         try
         {
             Cursor findPerson = db.rawQuery("SELECT * FROM person WHERE _idPerson = " + person._id,null);
             db = getDataBase();
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
         }
         catch (Exception e)
         {

         }
        db.close();

        return person;
    }

    public Boolean findPersonByEmail(Person person)
    {
        Boolean result = false;
        try
        {
            String [] parametros ={person.email};
            db = getDataBase();
            Cursor findPerson = db.rawQuery("SELECT * FROM person WHERE email = ?",parametros);

            if (findPerson != null) {
                findPerson.moveToFirst();
                if (findPerson.getInt (0) == 0) {

                    result =  true;
                }
                else
                {

                    result = false;
                }
            }
        }
        catch (Exception e)
        {
            result = false;
        }
        db.close();
        return result;

    }


    @NonNull
    private ContentValues getContentValues(Person person) {
        ContentValues values = new ContentValues();
        values.put("name", person.name);
        values.put("email", person.email);
        values.put("password", person.password);
        values.put("cpf", person.cpf);
        values.put("birth", Util.transformDate.getDateIntoString(person.birth));
        values.put("sex", person.sex);
        values.put("picture", person.picture);
        values.put("isActive", ((person.isActive) ? 1 : 0));
        return values;
    }

    /***
     * Abre o banco com o contexto da classe [contextView]
     * @return
     */
    public SQLiteDatabase getDataBase(){
        DataBase dataBase = new DataBase(contextView);
        return dataBase.getWritableDatabase();

    }
}
