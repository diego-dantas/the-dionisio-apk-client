package com.the.dionisio.apk.client.dao.api.personApi;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.dao.api.ServiceGenerator;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.dto.Validation;
import com.the.dionisio.apk.client.model.presenter.Presenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dantas on 3/25/17.
 */

public class PersonDataConverter {

    public static final String TAG = "Person";

    public void getPerson(Token token, Person person, Context context)
    {
        ServicePersonApi ServicePersonApi = ServiceGenerator.createService(ServicePersonApi.class);
        Call<CatalogApi> request = ServicePersonApi.getPerson(token.token, person._id);

        request.enqueue(new Callback<CatalogApi>()
        {
            @Override
            public void onResponse(Call<CatalogApi> call, Response<CatalogApi> response)
            {
                CatalogApi catalogApi = response.body();

                if(catalogApi != null)
                {
                    if(response.isSuccessful())
                    {
                        for(Person p : catalogApi.getPeoples())
                        {
                            Log.i(TAG, "Sucessfull - code: " + response.code() + " username: " + p.name + "; _id: " + p.email);
                        }

                        Presenter.personAction.updatePersonSQLite(catalogApi.getPeoples().get(0), context);
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
            public void onFailure(Call<CatalogApi> call, Throwable t)
            {
                Log.e(TAG, "Failure to communication with the server! alteração de texto");
            }
        });
    }

    public void postPerson(Person person, Context context)
    {
        ServicePersonApi ServicePersonApi = ServiceGenerator.createService(ServicePersonApi.class);
        Call<Validation> request = ServicePersonApi.postPerson(person);

        request.enqueue(new Callback<Validation>()
        {
            @Override
            public void onResponse(Call<Validation> call, Response<Validation> response)
            {
                String[] _id;
                Validation validation = response.body();

                if(validation != null)
                {
                    if(response.isSuccessful())
                    {
                        Log.i(TAG, "Sucessfull - code: " + response.code() + " additional: " + validation.additional);
                        _id = validation.additional.toString().split("=");
                        person._id = _id[1].trim();

                        Presenter.personAction.createPersonSQLite(person, context);
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

    public void deletePerson(String id)
    {
        ServicePersonApi ServicePersonApi = ServiceGenerator.createService(ServicePersonApi.class);
        Call<Validation> request = ServicePersonApi.deletePerson(id);

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

    public void updatePerson(Person person)
    {
        ServicePersonApi ServicePersonApi = ServiceGenerator.createService(ServicePersonApi.class);
        Call<Validation> request = ServicePersonApi.updatePerson(person);

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
