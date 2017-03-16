package com.the.dionisio.apk.client.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.the.dionisio.apk.client.R;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {

    private ImageButton backForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_forgot_password);

        backForgot = (ImageButton) findViewById(R.id.btnBackForgot);

        backForgot.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v == backForgot){
            Intent itBackForgot = new Intent(this, Login.class);
            itBackForgot.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(itBackForgot);
        }
    }
}
