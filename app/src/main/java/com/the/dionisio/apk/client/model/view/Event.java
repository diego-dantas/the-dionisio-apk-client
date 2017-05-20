package com.the.dionisio.apk.client.model.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.the.dionisio.apk.client.R;

public class Event extends AppCompatActivity implements View.OnClickListener
{
    private Button btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_event);

        btnLocation = (Button) findViewById(R.id.btnLocaleEvent);
        btnLocation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MapsEvents.class);
        startActivity(intent);

    }
}
