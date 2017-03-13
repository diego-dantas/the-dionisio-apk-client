package com.the.dionisio.apk.client.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import com.the.dionisio.apk.client.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBackLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_login);

        btnBackLogin = (ImageButton) findViewById(R.id.btnBackLogin);

        btnBackLogin.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v == btnBackLogin){
            Intent it = new Intent(this, PreLogin.class);
            startActivity(it);
        }
    }

}
