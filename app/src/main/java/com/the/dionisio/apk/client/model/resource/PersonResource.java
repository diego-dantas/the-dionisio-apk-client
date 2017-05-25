package com.the.dionisio.apk.client.model.resource;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.dao.sqlite.PersonDAO;
import com.the.dionisio.apk.client.model.dto.Person;

/**
 * Created by igorm on 20/05/2017.
 */

public class PersonResource
{
    public void  createPersonOrUpdatePerson(Person person, Context context)
    {
        PersonDAO personDAO = new PersonDAO(context);

        if(personDAO.findPersonByEmail(person))
        {
            personDAO.createPerson(person);
        }
        else
        {
            personDAO.updatePerson(person);
        }
    }

    public Boolean treatResponse(Person person)
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
            Log.e("PERSON", "Person handling log is not valid!");
        }

        return false;
    }
}
