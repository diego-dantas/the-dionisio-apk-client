package com.the.dionisio.apk.client.model.API;

import com.the.dionisio.apk.client.model.DTO.Person;

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
