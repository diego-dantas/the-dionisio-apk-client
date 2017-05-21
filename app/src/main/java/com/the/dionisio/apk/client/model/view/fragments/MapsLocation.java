package com.the.dionisio.apk.client.model.view.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.the.dionisio.apk.client.model.dto.EventDTO;
import com.the.dionisio.apk.client.model.view.Event;
import java.util.ArrayList;
import java.util.List;

public class MapsLocation extends SupportMapFragment implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener
{
    private static final String TAG = "Maps";
    private GoogleMap mMap;
    private LocationManager locationManager;
    private String lat;
    private String log;
    private String title;
    MarkerOptions markerLocation = new MarkerOptions();
    List<EventDTO> eventDTOs;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getMapAsync(this);


        eventDTOs = (List<EventDTO>) getActivity().getIntent().getSerializableExtra("ListEvent");


        //markerLocation = markerEvet(eventDTOs).get(0);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        try{

            // locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            //  Criteria criteria = new Criteria();

            //  String provaider = locationManager.getBestProvider(criteria, true);
            //  Toast.makeText(getActivity(), "Provider " + provaider, Toast.LENGTH_LONG).show();

            mMap = googleMap;
            mMap.getUiSettings().setZoomControlsEnabled(true);
            markerEvet(eventDTOs);


            //mMap.setOnMapClickListener(this);

            // mMap.setMyLocationEnabled(true);

            //  mMap.setOnMarkerClickListener(this);
        }catch(SecurityException ex){
            Log.e(TAG, "Error: ", ex);
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.getIcon();

        AlertDialog.Builder al
                = new AlertDialog.Builder(getContext());
        al.setMessage("vamos brincar: ");
        al.setNeutralButton("Ok", null);
        al.show();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent i = new Intent(getContext(), Event.class);
        i.putExtra("LOCAL", marker.getTitle().toString());
        i.putExtra("LATLOG", marker.getPosition().toString());
        startActivity(i);
        return false;
    }


    public void markerEvet(List<EventDTO> listEvent){
        double lati, longi;
        MarkerOptions marker = new MarkerOptions();


        for(EventDTO ev : listEvent){
            lati = Double.parseDouble(ev.latitude);
            longi = Double.parseDouble(ev.longitude);
            title = ev.title;
            Log.i(TAG, "Latitude " + lati + " Longitude" + longi + " title " + title);

            LatLng location = new LatLng(lati, longi);
            marker.position(location);
            marker.title(title);
            mMap.addMarker(marker);

        }


    }



}
