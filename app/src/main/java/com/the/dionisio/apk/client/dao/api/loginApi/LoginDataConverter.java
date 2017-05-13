package com.the.dionisio.apk.client.dao.api.loginApi;

import android.util.Log;

import com.the.dionisio.apk.client.dao.api.ServiceGenerator;
import com.the.dionisio.apk.client.dao.api.personApi.ServicePersonApi;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.dto.Validation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by igorm on 13/05/2017.
 */

public class LoginDataConverter
{
    public static final String TAG = "LOGIN";

    public void postLogin(Person person)
    {
        ServiceLoginApi serviceLoginApi = ServiceGenerator.createService(ServiceLoginApi.class);
        Call<Token> request = serviceLoginApi.postLogin(person.email, person.password);

        request.enqueue(new Callback<Token>()
        {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response)
            {
                Token token = response.body();

                if(token != null)
                {
                    if(response.isSuccessful())
                    {
                        Log.i(TAG, "Sucessfull - code: " + response.code() + " token: " + token.token);
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
