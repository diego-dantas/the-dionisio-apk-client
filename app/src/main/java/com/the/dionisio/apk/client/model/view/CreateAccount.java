package com.the.dionisio.apk.client.model.view;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;

/**
 * Created by igorm on 23/04/2017.
 */

public class CreateAccount extends AppCompatActivity
{
    private TextInputLayout inputLayoutNameFullCreateAccount, inputLayoutEmailCreateAccount, inputLayoutPasswordCreateAccount, inputLayoutBirthCreateAccount;
    private EditText inputNameFullCreateAccount, inputEmailCreateAccount, inputPasswordCreateAccount, inputBirthCreateAccount;
    private RadioButton radioManCreateAccount, radioWomanCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_create_account);

        inputLayoutNameFullCreateAccount = (TextInputLayout) findViewById(R.id.inputLayoutNameFullCreateAccount);
        inputLayoutEmailCreateAccount = (TextInputLayout) findViewById(R.id.inputLayoutEmailCreateAccount);
        inputLayoutPasswordCreateAccount = (TextInputLayout) findViewById(R.id.inputLayoutPasswordCreateAccount);
        inputLayoutBirthCreateAccount = (TextInputLayout) findViewById(R.id.inputLayoutBirthCreateAccount);

        inputNameFullCreateAccount = (EditText) findViewById(R.id.inputNameFullCreateAccount);
        inputEmailCreateAccount = (EditText) findViewById(R.id.inputEmailCreateAccount);
        inputPasswordCreateAccount = (EditText) findViewById(R.id.inputPasswordCreateAccount);
        inputBirthCreateAccount = (EditText) findViewById(R.id.inputBirthCreateAccount);
    }

    public void backCreateAccount(View v)
    {
        Util.moviment.backView(this);
    }

    public void goCreateAccountStepGenre(View v)
    {

        if(Util.validationInput.emptyInput(inputNameFullCreateAccount, inputLayoutNameFullCreateAccount) == false)
        {
            return;
        }
        else if(Util.validationInput.emptyInput(inputEmailCreateAccount, inputLayoutEmailCreateAccount) == false)
        {
            return;

        }
        else if(Util.validationInput.emptyInput(inputPasswordCreateAccount, inputLayoutPasswordCreateAccount) == false)
        {
            return;
        }
        else if(Util.validationInput.emptyInput(inputBirthCreateAccount, inputLayoutBirthCreateAccount) == false)
        {
            return;
        }
        else
        {
            Util.moviment.goView(this, CreateAccountStepGenre.class);
        }
    }
}