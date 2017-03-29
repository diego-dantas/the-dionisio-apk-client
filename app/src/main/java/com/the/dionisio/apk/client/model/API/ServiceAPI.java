package com.the.dionisio.apk.client.model.API;

import com.the.dionisio.apk.client.model.DTO.Person;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Dantas on 3/25/17.
 */

public interface ServiceAPI {


    @GET("person/{id}")
    Call<CatalogAPI> getPeople(@Path("id") String id);

    /*
    @POST("people")
    Call<CatalogAPI> postPeople(@Field("name") String name,
                                @Field("email") String email,
                                @Field("password") String password);*/

    @POST("person")
    Call<CatalogAPI> postPeople(@Body Person p);


}
