package com.the.dionisio.apk.client.util.view;

import android.os.Bundle;

import com.the.dionisio.apk.client.model.dto.Login;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.util.Util;
import java.util.List;

/**
 * Created by igorm on 13/05/2017.
 */

public class BundlePerson
{
    public Person setBundlePerson(Bundle bundle, List<String> genres)
    {
        Person person = new Person();

        person.name = bundle.getString("NAME");
        person.email = bundle.getString("EMAIL");
        person.password = bundle.getString("PASSWORD");
        person.birth = Util.transformDate.getDateIntoList(bundle);
        person.sex = bundle.getString("SEX");
        person.genres = genres;

        return person;
    }

    public Person setPerson(String email, String password, String name, String img_url)
    {
        Person person = new Person();
        person.email = email;
        person.password = password;
        person.name = name;
        person.picture = img_url;

        return person;
    }

    public Login setLogin(String username, String password)
    {
        Login login = new Login();
        login.username = username;
        login.password = password;

        return login;
    }

    public Person getBundlePerson()
    {
        Person person = new Person();



        return person;
    }
}
