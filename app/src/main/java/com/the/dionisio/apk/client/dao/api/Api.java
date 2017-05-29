package com.the.dionisio.apk.client.dao.api;

import com.the.dionisio.apk.client.dao.api.loginApi.LoginDataConverter;
import com.the.dionisio.apk.client.dao.api.personApi.PersonDataConverter;

/**
 * Created by igorm on 06/05/2017.
 */

public interface Api
{
    String METHOD_GET = "get";
    String METHOD_PUT = "put";
    String METHOD_DELETE = "delete";

    PersonDataConverter personDataConverter = new PersonDataConverter();
    LoginDataConverter loginDataConverter = new LoginDataConverter();
}
