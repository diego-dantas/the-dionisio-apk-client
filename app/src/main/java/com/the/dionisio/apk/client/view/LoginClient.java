package com.the.dionisio.apk.client.view;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.the.dionisio.apk.client.R;

public class LoginClient extends AppCompatActivity implements View.OnClickListener{

    private EditText edtLogin, edtPassword;
    private Button btnLogIn, btnSingUp, btnCancelModal;
    private TextView txtForgotPassword;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_client);

        txtForgotPassword = (TextView) findViewById(R.id.txtForgotPassword);
        btnCancelModal = (Button) findViewById(R.id.btnCancelModal);
        txtForgotPassword.setOnClickListener(this);
    }

    public void forgotPassword(){
        AlertDialog.Builder forgot = new AlertDialog.Builder(LoginClient.this);
        View viewForgot = getLayoutInflater().inflate(R.layout.forgot_password, null);
        forgot.setView(viewForgot);

        dialog = forgot.create();
        dialog.show();
    }

    public void onClick(View v){
        if(v == txtForgotPassword){
            forgotPassword();
        }
    }
}
