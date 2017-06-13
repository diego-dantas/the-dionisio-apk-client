package com.the.dionisio.apk.client.model.presenter;

import android.content.Context;

import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.model.dto.Filter;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;

/**
 * Created by igorm on 01/06/2017.
 */

public class EventPresenter
{
    public void getEvents(Token token, Person person, Context context)
    {
        if(token.token != null || token.token.isEmpty())
        {
            Api.requestEvent.getEvents(token, person, context);
        }
    }

    public void getEventsWithFilter(Token token, Filter filter, Context context)
    {

    }
}
