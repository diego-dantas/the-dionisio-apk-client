package com.the.dionisio.apk.client.dao.api;

import com.the.dionisio.apk.client.model.cleaningUp.Person;

import java.util.List;

/**
 * Created by Dantas on 3/25/17.
 */


public class CatalogAPI {

    private List<Person> people;

    public List<Person> getPeoples(){
        return this.people;
    }
}
