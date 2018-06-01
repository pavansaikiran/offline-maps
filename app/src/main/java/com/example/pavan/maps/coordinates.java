package com.example.pavan.maps;

/**
 * Created by pavan on 19/3/18.
 */

public class coordinates {
    String nameofpoint;
    float lat,lon;
    coordinates(String s,float x,float y)
    {
        nameofpoint=s;
        lat=x;
        lon=y;
    }
    String getNameofpoint()
    {
        return nameofpoint;
    }
    float getlat()
    {
        return lat;
    }
    float getlon()
    {
        return lon;
    }

}
