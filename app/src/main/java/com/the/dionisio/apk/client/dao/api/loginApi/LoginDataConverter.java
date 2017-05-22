package com.the.dionisio.apk.client.dao.api.loginApi;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.dao.api.ServiceGenerator;
import com.the.dionisio.apk.client.model.dto.Login;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.resource.PersonResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by igorm on 13/05/2017.
 */

public class LoginDataConverter
{
    public static final String TAG = "LOGIN";
    private PersonResource personResource = new PersonResource();

    public void postLogin(Person person, Login login, Context context)
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
                        Person newPerson = entity.entity;

                        token.token = entity.token;

                        Log.i(TAG, "Sucessfull - code: " + response.code() + " username: " + newPerson.email + " token: " + token.token);

                        personResource.createPersonOrUpdatePerson(newPerson, context);
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
            public void onFailure(Call<Entity> call, Throwable t)
            {
                Log.e(TAG, "Failure to communication with the server!");
            }
        });
    }
}
