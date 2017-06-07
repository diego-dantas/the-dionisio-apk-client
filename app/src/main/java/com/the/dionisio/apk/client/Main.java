package com.the.dionisio.apk.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.the.dionisio.apk.client.dao.api.eventApi.Events;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.view.DetailedEvent;
import com.the.dionisio.apk.client.model.view.MapsEvents;
import com.the.dionisio.apk.client.model.view.fragments.EventListAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Daniel on 25/05/2017.
 */
public class Main extends AppCompatActivity
{
    //Components of person
    private CircleImageView urlPersonImage;
    private TextView txtPersonName, txtPersonEmail;
    private Person person;

    //Components of events
    private DrawerLayout drawer;
    private ListView listViewEvent;
    private EventListAdapter adapterCustom;
    private Events listEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listEvents = (Events) getIntent().getSerializableExtra("EVENTS");

        listViewEvent = (ListView) findViewById(R.id.listViewEvent);

        adapterCustom = new EventListAdapter(this, listEvents.events);
        listViewEvent.setAdapter(adapterCustom);

        listViewEvent.setOnItemClickListener((parent, view, position, id) ->
                goDetailedEvent((Event) view.getTag()));

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView leftNavigationView = (NavigationView) findViewById(R.id.nav_left_view);
        leftNavigationView.setNavigationItemSelectedListener(item ->
        {
            int id = item.getItemId();

            if (id == R.id.nav_ticket)
            {
                Toast.makeText(getApplicationContext(), "Ticket", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.nav_settings)
            {
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
            }

            drawer.closeDrawer(GravityCompat.START);
            return true;
        });

        View header = leftNavigationView.getHeaderView(0);

        urlPersonImage = (CircleImageView) header.findViewById(R.id.urlPersonImage);
        txtPersonName = (TextView) header.findViewById(R.id.txtPersonName);
        txtPersonEmail = (TextView) header.findViewById(R.id.txtPersonEmail);

        populatePerson();

        NavigationView rightNavigationView = (NavigationView) findViewById(R.id.nav_right_view);
        rightNavigationView.setNavigationItemSelectedListener(item ->
        {
            int id = item.getItemId();

            if (id == R.id.filter_date)
            {
                Toast.makeText(getApplicationContext(), "Filter Date", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.filter_locale)
            {
                Toast.makeText(getApplicationContext(), "Filter Locale", Toast.LENGTH_SHORT).show();
            }
            else if (id == R.id.filter_genre)
            {
                Toast.makeText(getApplicationContext(), "Filter Genre", Toast.LENGTH_SHORT).show();
            }

            drawer.closeDrawer(GravityCompat.END);
            return true;
        });
    }

    public void populatePerson()
    {
        person = (Person) getIntent().getSerializableExtra("PERSON");

        txtPersonName.setText(person.name);
        txtPersonEmail.setText(person.email);
        if(person.picture != null && !person.picture.isEmpty())
        {
            Glide.with(this).load(person.picture).into(urlPersonImage);
        }
    }

    public void goDetailedEvent(Event event)
    {
        Intent intent = new Intent(this, DetailedEvent.class);
        intent.putExtra("EVENT", event);
        startActivity(intent);
    }

    public void goViewMap()
    {

        Intent intent = new Intent(this, MapsEvents.class);
        intent.putExtra("ListEvents", (Serializable) listEvents.events);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (drawer.isDrawerOpen(GravityCompat.END))
        {
            drawer.closeDrawer(GravityCompat.END);
        }
        else
        {
            super.onBackPressed();
            System.exit(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.action_openRight)
        {
            drawer.openDrawer(GravityCompat.END);
            return true;
        }
        else if (id == R.id.action_openMap)
        {
            goViewMap();
        }

        return super.onOptionsItemSelected(item);
    }
}
