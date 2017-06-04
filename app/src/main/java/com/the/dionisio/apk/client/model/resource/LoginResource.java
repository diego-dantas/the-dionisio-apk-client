package com.the.dionisio.apk.client.model.resource;

import android.content.Context;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.presenter.Presenter;

/**
 * Created by igorm on 27/05/2017.
 */

public class LoginResource
{
    public void methodsWithToken(Token token, Person person, Context context, String methodHttp)
    {
        switch(methodHttp)
        {
            case "get":
                if(token != null)
                {
                    Presenter.eventAction.getEvents(token, person, context);
                }
                break;
            case "put":
                if(person != null && token != null)
                {
                    Presenter.personAction.updatePersonApi(token, person, context);
                }
                break;
            case "delete":
                if(person != null && token != null)
                {
                    Presenter.personAction.deletePersonApi(token, person, context);
                }
                break;
            default:
                break;
        }
    }
}
