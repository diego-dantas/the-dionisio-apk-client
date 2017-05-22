package com.the.dionisio.apk.client.model.resource;

import android.content.Context;
import com.the.dionisio.apk.client.dao.sqlite.PersonDAO;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.presenter.Presenter;

/**
 * Created by igorm on 20/05/2017.
 */

public class PersonResource
{
    public void  createPersonOrUpdatePerson(Person person, Context context)
    {
        PersonDAO personDAO = new PersonDAO(context);

        if(!personDAO.findPersonByEmail(person))
        {
            personDAO.createPerson(person);
            Presenter.login.resultLoginOk(person, context);
        }
        else
        {
            personDAO.updatePerson(person);
            Presenter.login.resultLoginOk(person, context);
        }
    }
}
