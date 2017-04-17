package com.the.dionisio.apk.client.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;

public class ForgotPassword extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_forgot_password);
    }

    public void backForgotPassword(View v)
    {
        Util.moviment.back(this);
    }
}
