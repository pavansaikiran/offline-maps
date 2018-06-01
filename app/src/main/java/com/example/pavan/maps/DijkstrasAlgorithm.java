package com.example.pavan.maps;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by pavan on 6/3/18.
 */



/**
 * Created by pavan on 6/3/18.
 */

public class DijkstrasAlgorithm {
    static float dist;
    static ArrayList <String> pathString;
    static ArrayList<LatLng> mappoints;
    private static final int NO_PARENT = -1;

   public static void dijkstra(int[][] adjacencyMatrix,
                                int startVertex, int endvertex, ArrayList<String> places)
    {
        int nVertices = adjacencyMatrix[0].length;

        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];

        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0;

        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not
        // have a parent
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all
        // vertices
        int x=0;
        for (int i = 1; i < nVertices; i++)
        {

            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                if (!added[vertexIndex] &&
                        shortestDistances[vertexIndex] < shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    x=nearestVertex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            // Mark the picked vertex as
            // processed
            if(nearestVertex!=-1)
            added[nearestVertex] = true;
            else{
                nearestVertex=x;

            }

            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents,endvertex,places);
    }

    // A utility function to print
    // the constructed distances
    // array and shortest paths
    private static void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents,int endvertex,ArrayList<String> places)
    {
        int nVertices = distances.length;


        if (endvertex != startVertex)
        {
            pathString=new ArrayList<String>();
            mappoints=new ArrayList<LatLng>();
            dist=(float)((float)distances[endvertex]/(float)10);
            printPath(endvertex, parents,places);
        }

    }

    // Function to print shortest path
    // from source to currentVertex
    // using parents array
    private static void printPath(int currentVertex,
                                  int[] parents,ArrayList<String> places)
    {
        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents,places);
        pathString.add(places.get(currentVertex));
        LatLng l=new LatLng(Main2Activity.point.get(currentVertex).getlat(),Main2Activity.point.get(currentVertex).getlon());
        mappoints.add(l);
    }

    public static void main(String[] args)
    {

    }
}
