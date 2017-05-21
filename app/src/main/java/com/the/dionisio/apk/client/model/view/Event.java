package com.the.dionisio.apk.client.model.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.model.dto.EventDTO;
import com.the.dionisio.apk.client.util.Util;
import java.util.ArrayList;
import java.util.List;

public class Event extends AppCompatActivity
{
    private static final String TAG = "Maps";
    EventDTO eventDTO;
    EventDTO eventDTO1;
    EventDTO eventDTO2;
    List<EventDTO> eventDTOs = new ArrayList<EventDTO>();

    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_event);


        eventDTO = new EventDTO();
        eventDTO1 = new EventDTO();
        eventDTO2 = new EventDTO();

        eventDTO.latitude = "-21.1510028";
        eventDTO.longitude = "-50.8999327";
        eventDTO.title = "ARAÇATUBA";

        eventDTO1.latitude = "-21.264134";
        eventDTO1.longitude = "-50.4929904";
        eventDTO1.title = "BIRIGUI";

        eventDTO2.latitude = "-21.2407177";
        eventDTO2.longitude = "-50.6871082";
        eventDTO2.title = "EXPO";

        eventDTOs.add(eventDTO);
        eventDTOs.add(eventDTO1);
        eventDTOs.add(eventDTO2);
    }

    public void goLocation(View view)
    {
        Util.moviment.goView(this, MapsEvents.class, eventDTOs);
    }
}
