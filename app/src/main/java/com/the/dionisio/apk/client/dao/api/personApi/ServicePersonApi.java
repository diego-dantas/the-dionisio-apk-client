package com.the.dionisio.apk.client.dao.api.personApi;

import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Validation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Dantas on 3/25/17.
 */

public interface ServicePersonApi
{
    /* Possible method for include the token in request
    @Headers({
            "X-Auth-Token : value of key (token)"
    })*/
    @GET("/person/{id}")
    Call<Person> getPerson(@Path("id") String id);

    @POST("/person")
    Call<Validation> postPerson(@Body Person p);

    @DELETE("/person")
    Call<Validation> deletePerson(@Body String id);

    @PUT("/person")
    Call<Validation> updatePerson(@Body Person p);

}
