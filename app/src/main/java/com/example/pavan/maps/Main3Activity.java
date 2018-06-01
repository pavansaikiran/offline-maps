package com.example.pavan.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);





        /*float[][] adjacencyMatrix = {{0,0,0,0,0,0,0,0,0,0},{ 0,0, 4, 1, 1, 1, 1, 1, 8, 0},
                { 0,4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0,1, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0,1, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0,1, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0,1, 0, 4, 0, 10, 0, 2, 0, 0 },
                { 0,1, 0, 0, 14, 0, 2, 0, 1, 6 },
                { 0,8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0,0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        DijkstrasAlgorithm.dijkstra(adjacencyMatrix,Main2Activity.place.indexOf(Main2Activity.loc),Main2Activity.place.indexOf(Main2Activity.des),Main2Activity.place);
        startActivity(new Intent(this,finalpage.class));*/
    }
    public void action(View v)
    {
        /*float[][] adjacencyMatrix = {{0,0,0,0,0,0,0,0,0,0},{ 0,0, 4, 1, 1, 1, 1, 1, 8, 0},
                { 0,4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0,1, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0,1, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0,1, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0,1, 0, 4, 0, 10, 0, 2, 0, 0 },
                { 0,1, 0, 0, 14, 0, 2, 0, 1, 6 },
                { 0,8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0,0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        DijkstrasAlgorithm.dijkstra(adjacencyMatrix,Main2Activity.place.indexOf(Main2Activity.loc),Main2Activity.place.indexOf(Main2Activity.des),Main2Activity.place);
        startActivity(new Intent(this,finalpage.class))*/;

    }
}
