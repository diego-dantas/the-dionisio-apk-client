package com.the.dionisio.apk.client.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.the.dionisio.apk.client.R;

public class CreateAccountStepGenre extends AppCompatActivity {

    private ImageButton btnBackCreateGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_create_account_step_genre);

        btnBackCreateGenre = (ImageButton) findViewById(R.id.btnBackCreateGenre);
    }

    public void backCreateGenre(View v){
        Intent itBackCreateGenre = new Intent(this, CreateAccount.class);
        itBackCreateGenre.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(itBackCreateGenre);
    }
}
