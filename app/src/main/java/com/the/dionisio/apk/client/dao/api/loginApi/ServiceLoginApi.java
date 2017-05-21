package com.the.dionisio.apk.client.dao.api.loginApi;

import com.the.dionisio.apk.client.model.dto.Login;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by igorm on 13/05/2017.
 */

public interface ServiceLoginApi
{
    @POST("/login")
    Call<Entity> postLogin(@Body Login login);
}
