package com.the.dionisio.apk.client.dao.api;

import com.the.dionisio.apk.client.dao.api.loginApi.LoginDataConverter;
import com.the.dionisio.apk.client.dao.api.personApi.PersonDataConverter;

/**
 * Created by igorm on 06/05/2017.
 */

public interface Api
{
    PersonDataConverter personDataConverter = new PersonDataConverter();
    LoginDataConverter loginDataConverter = new LoginDataConverter();

    BeforeCreatePerson actionPerson = new BeforeCreatePerson();
}
