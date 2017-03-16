package com.the.dionisio.apk.client.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;
import com.the.dionisio.apk.client.R;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBackCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_create_account);

        btnBackCreate = (ImageButton) findViewById(R.id.btnBackCreate);

        btnBackCreate.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == btnBackCreate){
            Intent itBackCreate = new Intent(this, PreLogin.class);
            itBackCreate.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(itBackCreate);
        }
    }

}
