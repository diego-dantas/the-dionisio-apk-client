package com.the.dionisio.apk.client.dao.api.loginApi;

import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.dto.Validation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by igorm on 13/05/2017.
 */

public interface ServiceLoginApi
{
    @POST("/login")
    Call<Token> postLogin(@Body String username,
                          @Body String password);
}
