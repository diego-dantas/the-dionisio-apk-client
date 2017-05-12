package com.the.dionisio.apk.client.model.presenter;

import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Validation;

/**
 * Created by igorm on 06/05/2017.
 */

public class PersonPresenter
{
    public void createPerson(Person person)
    {
        //Calling the service of connection of API
        Api.dataConverter.postDataConverter(person);
        //dc.getDataConverter("58dc5d5c12137c0dcd76b91f");
        //dc.deleteDataConverter(p);
        //dc.updateDataConverter(p);
    }
}
