package com.the.dionisio.apk.client.util.verification;

import android.content.Context;
import android.widget.Toast;

import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.resource.PersonResource;
import com.the.dionisio.apk.client.model.view.CreateAccountStepGenre;
import com.the.dionisio.apk.client.util.Util;

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

    public void validationLogin(Integer statusCode, Person person, Context context, String typeLogin)
    {
        switch (statusCode)
        {
            case 200:

                break;
            case 401:
                if(typeLogin.equals("SOCIAL_NETWORK"))
                {
                    Util.moviment.goViewWithData(context, CreateAccountStepGenre.class, person);
                }
                else
                {
                    Toast.makeText(context, R.string.validation_login, Toast.LENGTH_SHORT).show();
                }
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
