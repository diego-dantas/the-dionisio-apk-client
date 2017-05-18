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
    public void getPersonApi(Token token, Person person, Context context)
    {
        //Calling the service of connection of API
        if(token.token != null && person._id != null)
        {
            Api.personDataConverter.getPerson(token, person, context);
        }
    }


    public void createPersonApi(Person person, Context context)
    {
        //Calling the service of connection of API
        if(person != null && context != null)
        {
            Api.personDataConverter.postPerson(person, context);
        }
    }

    public void updatePersonApi(Person person, Context context)
    {
        //Calling the service of connection of API
        if(person != null && context != null)
        {
            Api.personDataConverter.updatePerson(person);
        }
    }

    public void deletePersonApi(Person person, Context context)
    {
        //Calling the service of connection of API
        if(person != null && context != null)
        {
            Api.personDataConverter.deletePerson(person._id);
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
