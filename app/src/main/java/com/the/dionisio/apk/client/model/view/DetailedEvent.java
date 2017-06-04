package com.the.dionisio.apk.client.model.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.the.dionisio.apk.client.R;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.util.Util;

public class DetailedEvent extends AppCompatActivity
{
    private Event event;
    private TextView txtNameEvent, txtDescriptionEvent, txtDateStartEvent, txtDateEndEvent;
    private ImageView imageBannerEvent;

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

        event = (Event) getIntent().getSerializableExtra("EVENT");
        populateEvent();
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
        //intent.putExtra("ListEvent", (Serializable) events);
        startActivity(intent);
    }

    public void backDetailedEvent(View view)
    {
        Util.moviment.backView(this);
    }
}
