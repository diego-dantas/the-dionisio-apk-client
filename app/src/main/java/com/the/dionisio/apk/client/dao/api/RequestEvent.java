package com.the.dionisio.apk.client.dao.api;

import android.content.Context;
import android.util.Log;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.model.dto.Filter;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.presenter.Presenter;
import com.the.dionisio.apk.client.retrofit.RetrofitFactory;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by igorm on 13/05/2017.
 */

public class RequestEvent
{
    private RetrofitFactory retrofitFactory = new RetrofitFactory();
    private String TAG = "EVENT";

    public void getEvents(Token token, Person person, Context context)
    {
        try
        {
            Call<List<Event>> request = retrofitFactory.getEventService().getEvents(token.token);

            request.enqueue(new Callback<List<Event>>() {
                @Override
                public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                    validationEvents(response, token, person, context);
                }

                @Override
                public void onFailure(Call<List<Event>> call, Throwable t) {
                    Log.e(TAG, "Failure to communication with the server!");
                }
            });
        }
        catch(Exception error)
        {

        }
    }

    public void validationEvents(Response response, Token token, Person person, Context context)
    {
        List<Event> events = (List<Event>) response.body();

        if(events != null)
        {
            if(response.isSuccessful())
            {
                Log.i(TAG, "Sucessfull - code: " + response.code());

                for(Event event : events)
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

    public void getEventsWithFilter(Token token, Filter filter, Context context)
    {

    }
}
