package com.the.dionisio.apk.client;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.the.dionisio.apk.client.model.dto.Event;
import com.the.dionisio.apk.client.model.dto.Person;
import com.the.dionisio.apk.client.model.view.DetailedEvent;
import com.the.dionisio.apk.client.model.view.MapsEvents;
import com.the.dionisio.apk.client.model.view.PreLogin;
import com.the.dionisio.apk.client.model.view.fragments.EventListAdapter;
import com.the.dionisio.apk.client.model.view.fragments.FilterAdapter;
import com.the.dionisio.apk.client.model.view.fragments.PopulateData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Daniel on 25/05/2017.
 */
public class Main extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener
{
    //Components of person
    private CircleImageView urlPersonImage;
    private TextView txtPersonName, txtPersonEmail;
    private Person person;
    private GoogleApiClient googleApiClient;

    //Components of events
    private DrawerLayout drawer;
    private ListView listViewEvent;
    private EventListAdapter adapterCustom;
    private List<Event> listEvents;

    //Components of filter
    private HashMap<String, List<String>> filter_category;
    private List<String> list_child;
    private ExpandableListView expandable_genre, expandable_date, expandable_locale;
    private FilterAdapter filterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadGoogleClient();

        listEvents = (List<Event>) getIntent().getSerializableExtra("EVENTS");

        listViewEvent = (ListView) findViewById(R.id.listViewEvent);

        adapterCustom = new EventListAdapter(this, listEvents);
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
            switch (item.getItemId())
            {
                case R.id.nav_settings:
                    Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_ticket:
                    Toast.makeText(getApplicationContext(), "Ticket", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_logout:
                    logOut();
                    break;
            }

            drawer.closeDrawer(GravityCompat.START);
            return true;
        });

        View header = leftNavigationView.getHeaderView(0);
        populatePerson(header);

        componentsOfFilter();
    }

    private void loadGoogleClient()
    {
        GoogleSignInOptions signInOptions = new
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
                .build();
    }

    private void logOut()
    {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()) {
                    logOutAccount();
                } else {
                    Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        logOutAccount();
    }

    private void logOutAccount()
    {
        Intent intent = new Intent(this, PreLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void populatePerson(View view)
    {
        urlPersonImage = (CircleImageView) view.findViewById(R.id.urlPersonImage);
        txtPersonName = (TextView) view.findViewById(R.id.txtPersonName);
        txtPersonEmail = (TextView) view.findViewById(R.id.txtPersonEmail);

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
        intent.putExtra("EVENTS", (Serializable) listEvents);
        startActivity(intent);
    }

    public void componentsOfFilter()
    {
        expandable_genre = (ExpandableListView) findViewById(R.id.expandable_genre);
        filter_category = PopulateData.getData(R.string.filter_genre, this);

        list_child = new ArrayList<>(filter_category.keySet());
        filterAdapter = new FilterAdapter(this, filter_category, list_child, R.string.filter_genre);
        expandable_genre.setAdapter(filterAdapter);

        expandable_date = (ExpandableListView) findViewById(R.id.expandable_date);
        filter_category = PopulateData.getData(R.string.filter_date, this);

        list_child = new ArrayList<>(filter_category.keySet());
        filterAdapter = new FilterAdapter(this , filter_category, list_child, R.string.filter_date);
        expandable_date.setAdapter(filterAdapter);

        expandable_locale = (ExpandableListView) findViewById(R.id.expandable_locale);
        filter_category = PopulateData.getData(R.string.filter_locale, this);

        list_child = new ArrayList<>(filter_category.keySet());
        filterAdapter = new FilterAdapter(this , filter_category, list_child, R.string.filter_locale);
        expandable_locale.setAdapter(filterAdapter);
    }

    public void selectedChildTest(View view)
    {
        if(view.getTag() != "CHECK" && view.getTag() == null)
        {
            CheckBox checkBox = (CheckBox) view;
            checkBox.setTextColor(Color.parseColor("#36b30c"));
            view.setTag("CHECK");
        }
        else
        {
            CheckBox checkBox = (CheckBox) view;
            checkBox.setTextColor(Color.parseColor("#000000"));
            view.setTag(null);
        }
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

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult)
    {

    }
}
