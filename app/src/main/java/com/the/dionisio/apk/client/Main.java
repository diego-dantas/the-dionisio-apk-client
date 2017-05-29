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
import android.widget.Toast;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.model.view.MapsEvents;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 25/05/2017.
 */
public class Main extends AppCompatActivity {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView leftNavigationView = (NavigationView) findViewById(R.id.nav_left_view);
        leftNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item)
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
            }
        });

        NavigationView rightNavigationView = (NavigationView) findViewById(R.id.nav_right_view);
        rightNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item)
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
            }
        });
    }

    public void goViewMap()
    {
        Event event;
        Event event1;
        Event event2;
        List<Event> events = new ArrayList<>();

        event = new Event();
        event1 = new Event();
        event2 = new Event();

        event.latitude = "-21.1510028";
        event.longitude = "-50.8999327";
        event.title = "ARAÇATUBA";

        event1.latitude = "-21.264134";
        event1.longitude = "-50.4929904";
        event1.title = "BIRIGUI";

        event2.latitude = "-21.2407177";
        event2.longitude = "-50.6871082";
        event2.title = "EXPO";

        events.add(event);
        events.add(event1);
        events.add(event2);

        Intent intent = new Intent(this, MapsEvents.class);
        intent.putExtra("ListEvent", (Serializable) events);
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
