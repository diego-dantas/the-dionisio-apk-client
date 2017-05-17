package com.the.dionisio.apk.client.model.presenter;

import android.content.Context;

import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;

/**
 * Created by igorm on 06/05/2017.
 */

public class PersonPresenter
{
    public void getPerson(Token token, Person person)
    {
        //Calling the service of connection of API
        Api.personDataConverter.getDataConverter(token.token,person._id);
    }


    public void createPerson(Person person, Context context)
    {
        //Calling the service of connection of API
        Api.personDataConverter.postPerson(person, context);
    }

    public void updatePerson(Person person)
    {
        //Calling the service of connection of API
        Api.personDataConverter.updatePerson(person);

    }

    public void deletePerson(Person person)
    {
        //Calling the service of connection of API
        Api.personDataConverter.deletePerson(person._id);
    }
}
