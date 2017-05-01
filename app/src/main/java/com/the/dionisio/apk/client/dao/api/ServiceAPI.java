package com.the.dionisio.apk.client.dao.api;

import com.the.dionisio.apk.client.model.dto.Person;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Dantas on 3/25/17.
 */

public interface ServiceAPI {


    @GET("person/{id}")
    Call<CatalogAPI> getPeople(@Path("id") String id);

    @POST("person")
    Call<CatalogAPI> postPeople(@Body Person p);

    @DELETE("person")
    Call<CatalogAPI> deletePerson();

    @PUT("person")
    Call<CatalogAPI> updatePerson(@Body Person p);

    @HTTP(method = "DELETE", path = "person, hasBody = true")
    Call<CatalogAPI>  deletepe(@Body Person p);


}
