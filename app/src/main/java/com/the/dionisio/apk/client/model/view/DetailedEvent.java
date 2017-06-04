package com.the.dionisio.apk.client.model.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.model.dto.Batch;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.util.Util;

public class DetailedEvent extends AppCompatActivity
{
    private Event event;
    private TextView txtNameEvent, txtDescriptionEvent, txtDateStartEvent, txtDateEndEvent;
    private ImageView imageBannerEvent;
    private Spinner spinnerSector;
    private RadioButton radioManEvent, radioWomanEvent;
    private ArrayAdapter<String> adapterSector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_event);

        txtNameEvent = (TextView) findViewById(R.id.txtNameEvent);
        txtDescriptionEvent = (TextView) findViewById(R.id.txtDescriptionEvent);
        txtDateStartEvent = (TextView) findViewById(R.id.txtDateStartEvent);
        txtDateEndEvent = (TextView) findViewById(R.id.txtDateEndEvent);
        imageBannerEvent = (ImageView) findViewById(R.id.imageBannerEvent);
        spinnerSector = (Spinner) findViewById(R.id.spinnerSector);
        radioManEvent = (RadioButton) findViewById(R.id.radioManEvent);
        radioWomanEvent = (RadioButton) findViewById(R.id.radioWomanEvent);
        adapterSector = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterSector.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSector.setAdapter(adapterSector);

        event = (Event) getIntent().getSerializableExtra("EVENT");
        populateEvent();

        for(Batch bacth : event.batches)
        {
            adapterSector.add(bacth.sector);
        }

        /*spinnerSector.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(this, "Sector: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show());*/
    }

    public void populateEvent()
    {
        txtNameEvent.setText(event.name);
        txtDescriptionEvent.setText(event.description);
        txtDateStartEvent.setText(Util.transformDate.getDateAndHourIntoString(event.dateTimeRange.start));
        txtDateEndEvent.setText(Util.transformDate.getDateAndHourIntoString(event.dateTimeRange.end));

        if(event.urlBanners != null)
        {
            Glide.with(this).load(event.urlBanners.get(0)).into(imageBannerEvent);
        }
    }

    public void goLocation(View view)
    {
        Intent intent = new Intent(this, MapsEvents.class);
        intent.putExtra("EVENT", event);
        startActivity(intent);
    }

    public void backDetailedEvent(View view)
    {
        Util.moviment.backView(this);
    }
}
