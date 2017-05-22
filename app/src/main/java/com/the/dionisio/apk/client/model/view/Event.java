package com.the.dionisio.apk.client.model.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.the.dionisio.apk.client.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event extends AppCompatActivity
{
    private static final String TAG = "Maps";
    com.the.dionisio.apk.client.model.dto.Event Event;
    com.the.dionisio.apk.client.model.dto.Event event1;
    com.the.dionisio.apk.client.model.dto.Event event2;
    List<com.the.dionisio.apk.client.model.dto.Event> events = new ArrayList<com.the.dionisio.apk.client.model.dto.Event>();

    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_event);


        Event = new com.the.dionisio.apk.client.model.dto.Event();
        event1 = new com.the.dionisio.apk.client.model.dto.Event();
        event2 = new com.the.dionisio.apk.client.model.dto.Event();

        Event.latitude = "-21.1510028";
        Event.longitude = "-50.8999327";
        Event.title = "ARAÇATUBA";

        event1.latitude = "-21.264134";
        event1.longitude = "-50.4929904";
        event1.title = "BIRIGUI";

        event2.latitude = "-21.2407177";
        event2.longitude = "-50.6871082";
        event2.title = "EXPO";

        events.add(Event);
        events.add(event1);
        events.add(event2);
    }

    public void goLocation(View view)
    {
        Intent intent = new Intent(this, MapsEvents.class);
        intent.putExtra("ListEvent", (Serializable) events);
        startActivity(intent);
    }
}
