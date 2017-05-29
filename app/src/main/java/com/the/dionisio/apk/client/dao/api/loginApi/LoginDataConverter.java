package com.the.dionisio.apk.client.dao.api.loginApi;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.dao.api.ServiceGenerator;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.model.dto.Login;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.resource.Resource;
import com.the.dionisio.apk.client.util.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by igorm on 13/05/2017.
 */

public class LoginDataConverter
{
    public static final String TAG = "LOGIN";

    public void postLogin(Person person, Login login, Context context, String typeLogin)
    {
        ServiceLoginApi serviceLoginApi = ServiceGenerator.createService(ServiceLoginApi.class);
        Call<Entity> request = serviceLoginApi.postLogin(login);

        request.enqueue(new Callback<Entity>()
        {
            @Override
            public void onResponse(Call<Entity> call, Response<Entity> response)
            {
                Entity entity = response.body();

                if(entity != null)
                {
                    if(response.isSuccessful())
                    {
                        Token token = new Token();
                        token.token = entity.token;

                        Person newPerson = entity.entity;

                        Log.i(TAG, "Sucessfull - code: " + response.code() + " username: " + person.email + " token: " + token.token);

                        Util.validationResponse.validationPerson(response.code(), newPerson, context);
                        Util.validationResponse.validationLogin(response.code(), newPerson, context, token, null);
                    }
                    else
                    {
                        Util.validationResponse.validationLogin(response.code(), person, context, null, typeLogin);
                        Log.e(TAG, "Failed - code: " + response.code());
                    }
                }
                else
                {
                    Util.validationResponse.validationLogin(response.code(), person, context, null, typeLogin);
                    Log.e(TAG, "Failed, the data does not match, code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Entity> call, Throwable t)
            {
                Log.e(TAG, "Failure to communication with the server!");
            }
        });
    }

    public void refreshToken(Token token, Person person, Event event, Context context, String method)
    {
        ServiceLoginApi serviceLoginApi = ServiceGenerator.createService(ServiceLoginApi.class);
        Call<Token> request = serviceLoginApi.getToken(token.token);

        request.enqueue(new Callback<Token>()
        {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response)
            {
                Token newToken = response.body();

                if(newToken != null)
                {
                    if(response.isSuccessful())
                    {
                        Log.i(TAG, "Sucessfull - code: " + response.code() + " token: " + newToken.token);

                        Resource.loginResource.methodsWithToken(newToken, person, event, context, method);
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

            @Override
            public void onFailure(Call<Token> call, Throwable t)
            {
                Log.e(TAG, "Failure to communication with the server!");
            }
        });
    }
}
