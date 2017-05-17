package com.the.dionisio.apk.client.model.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.dao.api.personApi.PersonDataConverter;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.dto.Token;
import com.the.dionisio.apk.client.model.presenter.Presenter;
import com.the.dionisio.apk.client.util.Util;

/**
 * Created by igorm on 23/04/2017.
 */

public class PreLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_login);


        Person p = new Person();
        Token token = new Token();
        p._id = "58db0f4c12137c2f282ef4df";
        token.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWVnb2RhbnRhc0B0dXJpbmcuY29tIiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1MDQ1MTkwNTg5LCJleHAiOjE0OTUwNTcxOTB9.9mV6x8Ttkf-rLikSAa5CfuGUuLCnfQEl0GozLYDbOS-nZS4qWxiFGtSRRQhc-ssgmmsZ3LTarA-UAeLeO0AM3w";

        Presenter.personAction.getPerson(token, p);
    }

    public void goCreateAccount(View v)
    {
        Util.moviment.goView(this, CreateAccount.class);
    }

    public void goLogin(View v)
    {
        Util.moviment.goView(this, Login.class);
    }
}
