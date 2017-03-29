package com.the.dionisio.apk.client.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.model.API.DataConverter;
import com.the.dionisio.apk.client.model.DTO.Person;

import android.view.*;
import android.widget.*;

public class PreLogin extends Activity implements View.OnClickListener{

    private Button btnPreLogin, btnPreCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_login);

        btnPreLogin = (Button) findViewById(R.id.btnPreLogin);
        btnPreCreateAccount = (Button) findViewById(R.id.btnPreCreateAccount);

        btnPreLogin.setOnClickListener(this);
        btnPreCreateAccount.setOnClickListener(this);


        Person p = new Person();
        p.setName("Nome");
        p.setEmail("email");
        p.setPassword("senha");

        //Calling the service of connection of API
        DataConverter dc = new DataConverter();
        //dc.getDataConverter("58db0f4c12137c2f282ef4df");
        //dc.postDataConverter(p);

    }

    public void onClick(View v){
        if(v == btnPreLogin){
            Intent itLogin = new Intent(this, Login.class);
            startActivity(itLogin);
        }
        if(v == btnPreCreateAccount){
            Intent itCreate = new Intent(this, CreateAccount.class);
            startActivity(itCreate);
        }
    }
}
