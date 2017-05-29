package com.the.dionisio.apk.client.model.resource;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.presenter.Presenter;

/**
 * Created by igorm on 20/05/2017.
 */

public class PersonResource
{
    public void  createPersonOrUpdatePerson(Person person, Context context)
    {
        if(Presenter.personAction.findByEmailSQLite(person, context))
        {
            Presenter.personAction.createPersonSQLite(person, context);
        }
        else
        {
            Presenter.personAction.updatePersonSQLite(person, context);
        }
    }

    public Boolean treatCreate(Person person)
    {
        try
        {
            if(person._id != null && person.email != null && person.name != null && person.genres != null)
            {
                return true;
            }
        }
        catch(Exception error)
        {
            Log.e("PERSON", "Person handling in create log is not valid!");
        }

        return false;
    }

    public Boolean treatUpdate(Person person)
    {
        try
        {
            if(person._id != null && person.email == null && person.name != null && person.genres != null)
            {
                return true;
            }
        }
        catch(Exception error)
        {
            Log.e("PERSON", "Person handling in update log is not valid!");
        }

        return false;
    }
}
