package com.the.dionisio.apk.client.model.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;

/**
 * Created by igorm on 23/04/2017.
 */

public class CreateAccount extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_create_account);
    }

    public void backCreateAccount(View v)
    {
        Util.moviment.backView(this);
    }

    public void goCreateAccountStepGenre(View v)
    {
        Util.moviment.goView(this, CreateAccountStepGenre.class);
    }

}
