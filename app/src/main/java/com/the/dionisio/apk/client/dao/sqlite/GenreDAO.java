package com.the.dionisio.apk.client.dao.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.the.dionisio.apk.client.model.dto.Person;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 16/05/2017.
 */

public class GenreDAO
{
    private SQLiteDatabase db;
    private Context contextView;

    public GenreDAO(Context context)
    {
        DataBase dataBase = new DataBase(context);
        db = dataBase.getWritableDatabase();
        contextView = context;
    }

    public void createGenre(Person person)
    {
        for(String genre : person.genres)
        {
            ContentValues values = new ContentValues();

            values.put("_idPerson", person._id);
            values.put("genre", genre);

            db.insert("genre", null, values);
        }

        db.close();
        Toast.makeText(contextView, "Successfully registered! ", Toast.LENGTH_SHORT).show();
    }

    public void updateGenre(Person person)
    {
        ContentValues values = new ContentValues();

        values.put("genre", String.valueOf(person.genres));

        db.update("genre", values, "_idPerson = ?", new String[]{"" + person._id});
        db.close();
    }

    public void deleteGenre(Person person)
    {
        db.delete("genre", "_idPerson = " + person._id, null);
        db.close();
    }

    public List<String> searchGenre(Person person)
    {
        List<String> genre = new ArrayList<>();

        Cursor findGenre = db.rawQuery("SELECT * FROM genre WHERE _idPerson = " + person._id, null);

        while(findGenre.moveToNext())
        {
            genre.add(findGenre.getString(findGenre.getColumnIndex("genre")));
        }

        db.close();

        return genre;
    }
}
