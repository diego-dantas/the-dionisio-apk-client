package com.the.dionisio.apk.client.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.the.dionisio.apk.client.R;

import java.util.Arrays;

/**
 * Created by igorm on 14/03/2017.
 */

public class LoginFacebook extends Activity {

    private LoginButton btnLoginFacebook;
    private CallbackManager callbackManager;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        callbackManager = CallbackManager.Factory.create();

        btnLoginFacebook = (LoginButton) findViewById(R.id.btnLoginFacebook);

        btnLoginFacebook.setReadPermissions(Arrays.asList("email", "public_profile", "user_friends"));

        btnLoginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                /*Aqui tenho que verificar se o amiguinho já é cadastrado, caso não mando ele para
                cadastro de genero para finalizar o cadastro no aplicativo The Dionisio,
                caso ele já possua um cadastro devo redireciona-lo para a tela principal*/
            }

            @Override
            public void onCancel() {
                //Mensagem de erro caso o amiginho cancele o login com o facebook
                Toast.makeText(getApplicationContext() , R.string.cancel_loginFacebook, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                //Mensagem de erro caso tenha algum problema de conexão com o facebook
                Toast.makeText(getApplicationContext(), R.string.error_loginFacebook, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //As ações do login com facebook vem parar aqui nesse método ao botão de login ser clicado
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        /*Aqui redirecionamos a ação vinda e redirecionamos para o callbackManager
        para que agora possamos decidir o que fazer nos diferente casos*/
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
