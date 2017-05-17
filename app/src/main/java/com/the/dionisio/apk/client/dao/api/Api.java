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
<<<<<<< HEAD
=======

    //BeforeCreatePerson actionPerson = new BeforeCreatePerson();
>>>>>>> dd8c38c8639b2cf4b3b2b7f79cc746f23f8daf59
}
