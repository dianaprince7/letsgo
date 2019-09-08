package com.example.letsgo;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import android.graphics.Color;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //getting the zoom control ready
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(18), 1000, null);
        mMap.getUiSettings().setZoomControlsEnabled(true);


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-36.91525278,174.79556);
        mMap.addMarker(new MarkerOptions().position(sydney).title("187 Mt Smart Road"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng auckland = new LatLng(-36.90941167,174.800495);
        mMap.addMarker(new MarkerOptions().position(auckland).title("Opp 73 Waitangi Rd"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(auckland));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 1000, null);
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
        mMap.addPolyline(new PolylineOptions()
                .add(sydney)
                .add(auckland)
                .color(Color.RED)


        );


    }
}
