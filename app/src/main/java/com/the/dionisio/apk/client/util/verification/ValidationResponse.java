package com.the.dionisio.apk.client.util.verification;

import android.content.Context;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.resource.PersonResource;

/**
 * Created by igorm on 20/05/2017.
 */

public class ValidationResponse
{
    public void validationPerson(Integer statusCode, Person person, Context context)
    {
        switch (statusCode)
        {
            case 200:
                PersonResource personResource = new PersonResource();
                if(personResource.treatResponse(person))
                {
                    personResource.createPersonOrUpdatePerson(person, context);
                }
                break;
            case 401:

                break;
            case 404:

                break;
            case 406:

                break;
            case 509:

                break;
            default:

                break;
        }
    }


}
