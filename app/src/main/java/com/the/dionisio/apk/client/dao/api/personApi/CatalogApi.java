package com.the.dionisio.apk.client.dao.api.personApi;

import com.the.dionisio.apk.client.model.dto.Person;
import java.util.List;

/**
 * Created by dantas on 5/17/17.
 */

public class CatalogApi
{
    private List<Person> people;

    public List<Person> getPeoples()
    {
        return this.people;
    }
}
