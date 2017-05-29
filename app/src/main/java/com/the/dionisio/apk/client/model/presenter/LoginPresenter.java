package com.the.dionisio.apk.client.model.presenter;

import android.content.Context;
import com.the.dionisio.apk.client.ViewMain;
import com.the.dionisio.apk.client.dao.api.Api;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.model.dto.Login;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
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

    public void resultLoginOk(Context context, Person person, Token token)
    {
        Util.moviment.goViewClearWithData(context, ViewMain.class, person, token);
    }

    public void refreshTokenApi(Token token, Person person, Event event, Context context, String typeMethod)
    {
        if(context != null && (person != null || event != null))
        {
            Api.loginDataConverter.refreshToken(token, person, event, context, typeMethod);
        }
    }
}
