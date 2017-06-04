package com.the.dionisio.apk.client.dao.api.eventApi;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.dao.api.ServiceGenerator;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.presenter.Presenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by igorm on 13/05/2017.
 */

public class EventDataConverter
{
    private String TAG = "EVENT";

    public void getEvents(Token token, Person person, Context context)
    {
        ServiceEventApi ServiceEventApi = ServiceGenerator.createService(ServiceEventApi.class);
        Call<Events> request = ServiceEventApi.getEvents(token.token);

        request.enqueue(new Callback<Events>()
        {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response)
            {
                Events events = response.body();

                if(events != null)
                {
                    if(response.isSuccessful())
                    {
                        Log.i(TAG, "Sucessfull - code: " + response.code());

                        for(Event event : events.events)
                        {
                            Log.i(TAG, "Event: " + event.description);
                        }

                        Presenter.loginAction.resultLoginOk(context, person, events, token);
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
            public void onFailure(Call<Events> call, Throwable t)
            {
                Log.e(TAG, "Failure to communication with the server!");
            }
        });
    }
}
