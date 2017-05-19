package com.the.dionisio.apk.client.model.presenter;

import android.content.Context;
import java.util.List;
import com.the.dionisio.apk.client.ViewMain;
import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.util.Util;

/**
 * Created by igorm on 18/05/2017.
 */

public class LoginPresenter
{
    public void startLogin(Person person)
    {
        Api.loginDataConverter.postLogin(person);
    }

    public Person findPerson(List<Person> people, Person person)
    {
        for(Person p : people)
        {
            if(p.email.equals(person.email))
            {
                person = p;
            }
        }

        return person;
    }

    public void resultLoginOk(Person person, Context context)
    {
        String name = person.name;
        String email = person.email;
        String password = person.password;
        String image_url = person.picture;
        String birth = Util.transformDate.getDateIntoString(person.birth);
        String sex = person.sex;

        Util.moviment.goViewClearWithData(context, ViewMain.class, name, email, password, image_url, birth, sex);
    }
}
