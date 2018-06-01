package com.example.pavan.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class finalpage extends AppCompatActivity {
    static int listposmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        DijkstrasAlgorithm.dijkstra(Main2Activity.adjacencyMatrix,Main2Activity.place.indexOf(Main2Activity.loc),Main2Activity.place.indexOf(Main2Activity.des),Main2Activity.place);
        wordadapter adapter= new wordadapter (this,DijkstrasAlgorithm.pathString);
        ListView l=(ListView) findViewById(R.id.listview);
        l.setAdapter(adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                listposmap=i;
                startActivity(new Intent(getApplicationContext(),MapsActivityforlistview.class));



            }
        });
        TextView t=(TextView)findViewById(R.id.mindisttext);
        t.setText("MIN DISTANCE : "+DijkstrasAlgorithm.dist+" miles");
        Button b=(Button)findViewById(R.id.mapbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            }
        });
    }
}
