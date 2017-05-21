package com.the.dionisio.apk.client.model.presenter;

import android.content.Context;
import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.dao.sqlite.PersonDAO;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;

/**
 * Created by igorm on 06/05/2017.
 */

public class PersonPresenter
{
    public void createPersonApi(Person person, Context context)
    {
        //Calling the service of connection of API
        if(person != null && context != null)
        {
            Api.personDataConverter.postPerson(person, context);
        }
    }

    public void updatePersonApi(Token token, Person person, Context context)
    {
        //Calling the service of connection of API
        if(person != null && context != null)
        {
            Api.personDataConverter.updatePerson(token, person);
        }
    }

    public void deletePersonApi(Token token, Person person, Context context)
    {
        //Calling the service of connection of API
        if(person != null && context != null)
        {
            Api.personDataConverter.deletePerson(token, person);
        }
    }

    public void createPersonSQLite(Person person, Context context)
    {
        PersonDAO personDAO = new PersonDAO(context);
        personDAO.createPerson(person);
    }

    public void updatePersonSQLite(Person person, Context context)
    {
        PersonDAO personDAO = new PersonDAO(context);
        personDAO.updatePerson(person);
    }

    public void deletePersonSQLite(Person person, Context context)
    {
        PersonDAO personDAO = new PersonDAO(context);
        personDAO.deletePerson(person);
    }
}
