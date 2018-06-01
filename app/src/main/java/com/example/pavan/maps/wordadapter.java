package com.example.pavan.maps;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pavan on 1/3/18.
 */

public class wordadapter extends ArrayAdapter<String> {

    public wordadapter(Activity context, ArrayList<String> places)
    {
        super(context,0,places);
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



        String w= DijkstrasAlgorithm.pathString.get(position);
        View listitemview=convertView;
     if(listitemview==null)
            listitemview= LayoutInflater.from(getContext()).inflate(R.layout.activity_linearlayoutforlistview,parent,false);
        TextView t =  (TextView) listitemview.findViewById(R.id.textid);
        t.setText(w);

        return listitemview;
    }
}
