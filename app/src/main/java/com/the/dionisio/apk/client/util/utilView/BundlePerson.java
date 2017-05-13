package com.the.dionisio.apk.client.util.utilView;

import android.os.Bundle;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.util.Util;

import java.util.List;

/**
 * Created by igorm on 13/05/2017.
 */

public class BundlePerson
{
    public Person getBundle(Bundle bundle, List<String> genres)
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
}
