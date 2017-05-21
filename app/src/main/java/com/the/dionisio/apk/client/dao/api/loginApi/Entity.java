package com.the.dionisio.apk.client.dao.api.loginApi;

import com.the.dionisio.apk.client.model.dto.Person;

/**
 * Created by igorm on 20/05/2017.
 */

public class Entity
{
    private String token;
    private Person entity;

    public String getToken()
    {
        return this.token;
    }

    public Person getPerson()
    {
        return this.entity;
    }
}
