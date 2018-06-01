package com.example.pavan.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivityimage extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_activityimage);
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
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        LatLng l;
        for(coordinates c:Main2Activity.point) {
            l = new LatLng(c.getlat(), c.getlon());
            mMap.addMarker(new MarkerOptions().position(l).title("Marker in " + c.getNameofpoint()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(l, 13));
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
        mMap.setMaxZoomPreference(16);
        mMap.setMinZoomPreference(10);

    }
}
