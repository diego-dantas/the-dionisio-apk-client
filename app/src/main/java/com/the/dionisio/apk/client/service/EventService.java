package com.the.dionisio.apk.client.service;

import com.the.dionisio.apk.client.model.dto.Event;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by igorm on 29/05/2017.
 */

public interface EventService
{
    @GET("/event")
    Call<List<Event>> getEvents(@Header("X-Auth-Token") String token);
}
