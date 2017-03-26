package com.the.dionisio.apk.client.model.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dantas on 3/25/17.
 */

public interface ServiceAPI {

    AddressAPI addressApi = new AddressAPI();
    public static final String BASE_URL= addressApi.getAddressAPI();

    @GET("people/{id}")
    Call<CatalogAPI> getPeople(@Path("id") String id);
}
