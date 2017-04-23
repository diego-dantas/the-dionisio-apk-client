package com.the.dionisio.apk.client.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.model.API.DataConverter;
import com.the.dionisio.apk.client.model.DTO.Person;
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
        //p.set_id("58db0dc712137c2f282ef4d8");
        //p.setName("Testedecriação");
        //p.setEmail("kgiuig@ada.com");
        //p.setPassword("gafdga");

        //Calling the service of connection of API
        DataConverter dc = new DataConverter();
        //dc.getDataConverter("58dc5d5c12137c0dcd76b91f");
        //dc.postDataConverter(p);
        //dc.deleteDataConverter(p);
        //dc.updateDataConverter(p);
    }

    public void goCreateAccount(View v)
    {
        Util.moviment.go(this, CreateAccount.class);
    }

    public void goLogin(View v)
    {
        Util.moviment.go(this, Login.class);
    }
}
