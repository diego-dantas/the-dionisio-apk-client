package com.the.dionisio.apk.client.model.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.util.Util;

/**
 * Created by Daniel on 03/06/2017.
 */

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void backMenu(View view)
    {
        Util.moviment.backView(this);
    }

}
