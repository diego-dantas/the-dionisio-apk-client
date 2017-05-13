package com.the.dionisio.apk.client.model.presenter;

import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Validation;

/**
 * Created by igorm on 06/05/2017.
 */

public class PersonPresenter
{
    public void searchPerson(Person person)
    {
        //Calling the service of connection of API
        Api.personDataConverter.getPerson(person._id);
    }


    public void createPerson(Person person)
    {
        //Calling the service of connection of API
        Api.personDataConverter.postPerson(person);
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
