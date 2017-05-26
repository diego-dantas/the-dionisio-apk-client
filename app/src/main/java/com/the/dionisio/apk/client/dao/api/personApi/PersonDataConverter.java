package com.the.dionisio.apk.client.dao.api.personApi;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.dao.api.ServiceGenerator;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.dto.Validation;
import com.the.dionisio.apk.client.model.presenter.Presenter;
import com.the.dionisio.apk.client.util.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dantas on 3/25/17.
 */

public class PersonDataConverter {

    public static final String TAG = "PERSON";

    public void postPerson(Person person, Context context, String typeLogin)
    {
        ServicePersonApi ServicePersonApi = ServiceGenerator.createService(ServicePersonApi.class);
        Call<Validation> request = ServicePersonApi.postPerson(person);

        request.enqueue(new Callback<Validation>()
        {
            @Override
            public void onResponse(Call<Validation> call, Response<Validation> response)
            {
                Validation validation = response.body();

                if(validation != null)
                {
                    if(response.isSuccessful())
                    {
                        Log.i(TAG, "Sucessfull - code: " + response.code() + " additional: " + validation.additional);

                        Person newPerson = validation.additional;

                        Util.validationResponse.validationPerson(response.code(), newPerson, context);
                        Presenter.login.startLogin(newPerson ,Util.getBundle.setLogin(person.email, person.password), context, typeLogin);
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
            public void onFailure(Call<Validation> call, Throwable t)
            {
                Log.e(TAG, "Failure to communication with the server!");
            }
        });
    }

    public void deletePerson(Token token, Person person)
    {
        ServicePersonApi ServicePersonApi = ServiceGenerator.createService(ServicePersonApi.class);
        Call<Validation> request = ServicePersonApi.deletePerson(token.token, person._id);

        request.enqueue(new Callback<Validation>()
        {
            @Override
            public void onResponse(Call<Validation> call, Response<Validation> response)
            {
                Validation validation = response.body();

                if(validation != null)
                {
                    if(response.isSuccessful())
                    {
                        Log.i(TAG, "Sucessfull - code: " + response.code() + " additional: " + validation.additional);
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
            public void onFailure(Call<Validation> call, Throwable t)
            {
                Log.e(TAG, "Failure to communication with the server!");
            }
        });
    }

    public void updatePerson(Token token, Person person)
    {
        ServicePersonApi ServicePersonApi = ServiceGenerator.createService(ServicePersonApi.class);
        Call<Validation> request = ServicePersonApi.updatePerson(token.token, person);

        request.enqueue(new Callback<Validation>()
        {
            @Override
            public void onResponse(Call<Validation> call, Response<Validation> response)
            {
                Validation validation = response.body();

                if(validation != null)
                {
                    if(response.isSuccessful())
                    {
                        Log.i(TAG, "Sucessfull - code: " + response.code() + " additional: " + validation.additional);
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
            public void onFailure(Call<Validation> call, Throwable t)
            {
                Log.e(TAG, "Failure to communication with the server!");
            }
        });
    }
}
