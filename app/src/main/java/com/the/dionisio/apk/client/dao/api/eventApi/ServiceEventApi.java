package com.the.dionisio.apk.client.dao.api.eventApi;

import com.the.dionisio.apk.client.model.dto.Event;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by igorm on 29/05/2017.
 */

public interface ServiceEventApi
{
    @GET("/event")
    Call<Events> getEvents(@Header("X-Auth-Token") String token);

    @GET("/event/{id}")
    Call<Event> getEvent(@Header("X-Auth-Token") String token, @Path("id") String id);
}
