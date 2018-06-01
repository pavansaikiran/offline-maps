package com.example.pavan.maps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
       /* LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,18));*/
        LatLng l=new LatLng(0,0);
        for(coordinates c:Main2Activity.point) {
            l = new LatLng(c.getlat(), c.getlon());
            mMap.addMarker(new MarkerOptions().position(l).title("Marker in " + c.getNameofpoint()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        }
        for(int i=0;i<131;i++)
        {
            LatLng p=new LatLng(Main2Activity.point.get(i).getlat(),Main2Activity.point.get(i).getlon());
            for(int j=0;j<131;j++)
            {
                if(Main2Activity.adjacencyMatrix[i][j]!=0)
                {
                    LatLng q=new LatLng(Main2Activity.point.get(j).getlat(),Main2Activity.point.get(j).getlon());
                    mMap.addPolyline(new PolylineOptions().add(p,q).width(3));
                }

            }
        }


        for(LatLng c:DijkstrasAlgorithm.mappoints)
        {
            mMap.addMarker(new MarkerOptions().position(c));
            l=c;
        }
        mMap.addPolyline(new PolylineOptions().addAll(DijkstrasAlgorithm.mappoints).width(7).color(Color.RED));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(l,15));

        mMap.setMaxZoomPreference(16);
        mMap.setMinZoomPreference(10);
    }
}
