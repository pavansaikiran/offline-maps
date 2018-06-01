package com.example.pavan.maps;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    static int adjacencyMatrix[][]=new int[131][131];
    static final ArrayList<String> place = new ArrayList<String>();
    static final ArrayList<coordinates> point=new ArrayList<coordinates>();
     static String loc=new String() ;
     static String des= new String() ;
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activity.this);
        builder.setTitle("Warning!!!!");
        builder.setMessage("Do you want to exit ??");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                Toast.makeText(Main2Activity.this, "Press back again to exit", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NO",null);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        InputStream i=getResources().openRawResource(R.raw.maplist);
        BufferedReader br=new BufferedReader(new InputStreamReader(i, Charset.forName("UTF-8")));
        String line;
        try {
            while((line=br.readLine())!=null){
                String tokens[]=line.split(",");
                place.add(tokens[0]);
                point.add(new coordinates(tokens[0],Float.parseFloat(tokens[1]),Float.parseFloat(tokens[2])));
            }


        } catch(Exception e) {
            ;
        }
        ArrayList<String> place2=place;
        ArrayList<String> place3=place;
        final AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.spinner1);
        final AutoCompleteTextView autoCompleteTextView1=(AutoCompleteTextView)findViewById(R.id.spinner2);
        ImageView imageView=(ImageView)findViewById(R.id.arrow1);
        ImageView imageView1=(ImageView)findViewById(R.id.arrow2);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,place2);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,place3);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView1.setAdapter(adapter1);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView1.setThreshold(1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoCompleteTextView.showDropDown();
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoCompleteTextView1.showDropDown();
            }
        });
        Button b=(Button)findViewById(R.id.butt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loc=autoCompleteTextView.getText().toString();
                des=autoCompleteTextView1.getText().toString();
                if(loc==""||!place.contains(loc))
                {
                    if(des==""||!place.contains(des))
                        Toast.makeText(Main2Activity.this, "please enter valid location and destination", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Main2Activity.this, "please enter valid location", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(des==""||!place.contains(des))
                        Toast.makeText(Main2Activity.this, "please enter valid destination", Toast.LENGTH_SHORT).show();
                    else{
                        AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activity.this);
                        builder.setTitle("Are You Sure?");
                        builder.setMessage("From : "+loc+"\nTo : "+des);
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(),finalpage.class));
                            }
                        });
                        builder.setNegativeButton("No",null);
                        AlertDialog alertDialog=builder.create();
                        alertDialog.show();

                }
            }

        }


        });
        InputStream j=getResources().openRawResource(R.raw.adjmat);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(j, Charset.forName("UTF-8")));
        String data;
        try {
            int x=0;
            while((data=bufferedReader.readLine())!=null){
                String tokens[]=data.split(",");
                for(int y=0;y<131;y++){
                    float c=Float.parseFloat(tokens[y]);
                    adjacencyMatrix[x][y]=(int)(c*10);
                }
                x++;

            }
        } catch (Exception e) {
            ;
        }
        //Log.v("gone","index is"+Main2Activity.place.indexOf(Main2Activity.loc)+"des index is"+Main2Activity.place.indexOf(Main2Activity.des)) ;*/



//        DijkstrasAlgorithm.dijkstra(adjacencyMatrix,place.indexOf(loc),place.indexOf(des),place);
        //startActivity(new Intent(this,finalpage.
            ImageView imageView2=(ImageView)findViewById(R.id.from);
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 startActivity(new Intent(getApplicationContext(),MapsActivityimage.class));
                }
            });


    }


}