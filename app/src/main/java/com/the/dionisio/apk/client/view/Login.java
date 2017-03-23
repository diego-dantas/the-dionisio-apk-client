package com.the.dionisio.apk.client.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import com.the.dionisio.apk.client.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBackLogin;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_login);

        btnBackLogin = (ImageButton) findViewById(R.id.btnBackLogin);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);

        btnBackLogin.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v == btnBackLogin){
            Intent itBackLogin = new Intent(this, PreLogin.class);
            itBackLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(itBackLogin);
        }

        if (v == forgotPassword){
            Intent itForgotPassword = new Intent(this, ForgotPassword.class);
            startActivity(itForgotPassword);
        }
    }
}
