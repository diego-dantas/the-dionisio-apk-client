package com.the.dionisio.apk.client.dao.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.the.dionisio.apk.client.model.dto.Person;

/**
 * Created by Daniel on 16/05/2017.
 */

public class GenreDAO {
    private SQLiteDatabase db;

    public GenreDAO(Context context){
        DataBase dataBase = new DataBase(context);
        db = dataBase.getWritableDatabase();
    }

    public void createGenre(Person person, Context context){
        ContentValues values = new ContentValues();

        values.put("_idPerson", person._id);
        values.put("genre", String.valueOf(person.genres));

        db.insert("genre", null, values);
        db.close();
        Toast.makeText(context, "Successfully registered! ", Toast.LENGTH_SHORT).show();
    }

    public void updateGenre(Person person){
        ContentValues values = new ContentValues();

        values.put("genre", String.valueOf(person.genres));

        db.update("genre", values, "_idPerson = ?", new String[]{"" + person._id});
        db.close();
    }

    public void deleteGenre(Person person){
        db.delete("genre", "_idPerson = " + person._id, null);
        db.close();
    }

    public void searchGenre(Person person){
        String genre;

        Cursor findGenre = db.rawQuery("SELECT * FROM genre WHERE _idPerson = " + person._id, null);

        if(findGenre.moveToNext())
        {
            genre = findGenre.getString(findGenre.getColumnIndex("genre"));
        }
        db.close();
    }
}
