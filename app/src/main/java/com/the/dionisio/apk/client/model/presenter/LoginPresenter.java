package com.the.dionisio.apk.client.model.presenter;

import android.content.Context;
import com.the.dionisio.apk.client.ViewMain;
import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.model.dto.Login;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.util.Util;

/**
 * Created by igorm on 18/05/2017.
 */

public class LoginPresenter
{
    public void startLogin(Person person, Login login, Context context, String typeLogin)
    {
        Api.loginDataConverter.postLogin(person, login, context, typeLogin);
    }

    public void resultLoginOk(Person person, Context context)
    {
        Util.moviment.goViewClearWithData(context, ViewMain.class, person);
    }
}
