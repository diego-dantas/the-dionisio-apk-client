package com.the.dionisio.apk.client.dao.api;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.model.dto.Entity;
import com.the.dionisio.apk.client.model.dto.Filter;
import com.the.dionisio.apk.client.model.dto.Login;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.resource.Resource;
import com.the.dionisio.apk.client.retrofit.RetrofitFactory;
import com.the.dionisio.apk.client.util.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by igorm on 13/05/2017.
 */

public class RequestLogin
{
    private RetrofitFactory retrofitFactory = new RetrofitFactory();
    public static final String TAG = "LOGIN";

    public void postLogin(Person person, Login login, Context context, String typeLogin)
    {
        try
        {
            Call request = retrofitFactory.getLoginService().postLogin(login);

            request.enqueue(new Callback()
            {
                @Override
                public void onResponse(Call call, Response response)
                {
                    validationLogin(response, person, context, typeLogin);
                }

                @Override
                public void onFailure(Call call, Throwable t)
                {
                    Log.e(TAG, "Failure to communication with the server!");
                }
            });
        }
        catch(Exception error)
        {

        }
    }

    public void refreshToken(Token token, Person person, Filter filter, Context context, String methodHTTP)
    {
        try
        {
            Call request = retrofitFactory.getLoginService().getToken(token.token);

            request.enqueue(new Callback()
            {
                @Override
                public void onResponse(Call call, Response response)
                {
                    validationRefreshToken(response, person, filter, context, methodHTTP);
                }

                @Override
                public void onFailure(Call call, Throwable t)
                {
                    Log.e(TAG, "Failure to communication with the server!");
                }
            });
        }
        catch(Exception error)
        {

        }
    }

    public void validationLogin(Response response, Person person, Context context, String typeLogin)
    {
        Entity entity = (Entity) response.body();

        if(entity != null)
        {
            if(response.isSuccessful())
            {
                Token token = new Token();
                token.token = entity.token;

                Person newPerson = entity.entity;

                Log.i(TAG, "Sucessfull - code: " + response.code() + " username: " + newPerson.email + " token: " + token.token);

                Util.validationResponse.validationPerson(response.code(), newPerson, context);
                Resource.loginResource.methodsWithToken(token, newPerson, null, context, Api.METHOD_GET);
            }
            else
            {
                Util.validationResponse.validationLogin(response.code(), person, null, context, null, typeLogin);
                Log.e(TAG, "Failed - code: " + response.code());
            }
        }
        else
        {
            Util.validationResponse.validationLogin(response.code(), person, null, context, null, typeLogin);
            Log.e(TAG, "Failed, the data does not match, code: " + response.code());
        }
    }

    public void validationRefreshToken(Response response, Person person, Filter filter, Context context, String methodHTTP)
    {
        Token newToken = (Token) response.body();

        if(newToken != null)
        {
            if(response.isSuccessful())
            {
                Log.i(TAG, "Sucessfull - code: " + response.code() + " token: " + newToken.token);

                Resource.loginResource.methodsWithToken(newToken, person, filter, context, methodHTTP);
            }
            else
            {
                Log.e(TAG, "Failed - code: " + response.code());
            }
        }
        else
        {
            Log.e(TAG, "Failed, the data does not match, code: " + response.code());
        }
    }
}
