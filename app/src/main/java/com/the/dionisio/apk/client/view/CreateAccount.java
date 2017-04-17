package com.the.dionisio.apk.client.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;

public class CreateAccount extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_create_account);
    }

    public void backCreateAccount(View v)
    {
        Util.moviment.back(this);
    }

    public void goCreateAccountStepGenre(View v)
    {
        Util.moviment.go(this, CreateAccountStepGenre.class);
    }

}
