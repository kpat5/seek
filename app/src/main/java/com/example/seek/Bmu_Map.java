package com.example.seek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Bmu_Map extends AppCompatActivity {

    String fromVal;
    int fromInd;
    String toVal;
    int toInd;

    Button search;

    int[][] bmuMap = {
            {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,2,0,0},
            {0,2,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,2,0,0,0,0,0,0,0,0,0,0,3,0},
            {0,0,0,0,2,0,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,2,5,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,2,0,1,0,0,0,0,0,0,0,3},
            {0,0,0,0,0,0,0,5,1,0,3,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,3,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,2,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,2,0,1,3,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,3,1,0,4,2,0},
            {0,0,2,0,0,0,0,0,0,0,0,0,0,0,4,0,6,0},
            {0,0,0,0,3,0,0,0,0,0,0,0,0,0,2,6,0,7},
            {0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,7,0}
    };
    HashMap<Integer,String> map=new HashMap<>();
    public Bmu_Map() {
        map.put(0,"Gate");
        map.put(1,"Ground");
        map.put(2,"Gateway Building");
        map.put(3,"Dhaba");
        map.put(4,"New Building");
        map.put(5,"Faculty Housing");
        map.put(6,"T2");
        map.put(7,"D Cafe (Mess)");
        map.put(8,"Appt C");
        map.put(9,"Appt B");
        map.put(10,"Appt A");
        map.put(11,"Laundry");
        map.put(12,"Old Tower");
        map.put(13,"Falhar");
        map.put(14,"Workshop");
        map.put(15,"Library/Area 51");
        map.put(16,"Volleyball Court");
        map.put(17,"Pond Area");
    }
    static ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
    void dijkstra(@NonNull int[][] bmuMap, int source, HashMap<Integer,String> map)
    {
        int numOfV = bmuMap[0].length;
        int[] distance = new int[numOfV];
        boolean[] visited = new boolean[numOfV];
        for (int i = 0; i < numOfV;i++)
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        distance[source] = 0;
        int[] path = new int[numOfV];
        path[source] = -1;
        for (int i = 1; i < numOfV; i++)
        {

            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int v = 0;v < numOfV;v++)
            {
                if (!visited[v] && distance[v] < shortestDistance)
                {
                    nearestVertex = v;
                    shortestDistance = distance[v];
                }
            }

            visited[nearestVertex] = true;

            for (int v = 0;v < numOfV;v++)
            {
                int edgeDistance = bmuMap[nearestVertex][v];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < distance[v]))
                {
                    path[v] = nearestVertex;
                    distance[v] = shortestDistance +edgeDistance;
                }
            }
        }

        printSolution(source, distance, path,map);
    }
    private static void printSolution(int source, @NonNull int[] distances, int[] path, HashMap<Integer,String> map)
    {
        int numOfV = distances.length;
        System.out.print("Vertex\t\tPath");
        int j=0;
        for (int v = 0;v < numOfV;v++)
        {
            if (v != source)
            {
                System.out.print("\n" + source + " ->\t");
                System.out.print(v + "\t");
                p=0;
                ArrayList<String> temp=new ArrayList<String>();
                list.add(temp);
                printPath(v, path,map,j);
                j++;
            }
        }
    }
    static int p=0;
    static int z=0;
    private static void printPath(int curr,int[] path,HashMap<Integer,String> map,int j)
    {
        if(p==0) {
            z=curr;
            p++;
        }
        if (curr == -1)
        {
            return;
        }
        printPath(path[curr], path,map,j);
        list.get(j).add(map.get(curr));
// 		if(curr==z)
// 		{
// 			System.out.print(map.get(curr));
// 		}
// 		else
// 		{
// 			System.out.print(map.get(curr) + " -> ");
// 		}

    }
    int findRoute(String dest)
    {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).get(list.get(i).size()-1).equals(dest)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmu_map);
//        final Bmu_Map thisView = this;
        final Context context=this;

        search=(Button)findViewById(R.id.searchMap);
        Spinner from=(Spinner) findViewById(R.id.from_map);
        Spinner to=(Spinner) findViewById(R.id.to_map);

        ArrayAdapter<CharSequence> place=ArrayAdapter.createFromResource(this,R.array.places, android.R.layout.simple_spinner_item);
        place.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        from.setAdapter(place);
        to.setAdapter(place);


        LinearLayout mapLayout = (LinearLayout) findViewById(R.id.layoutMap);

        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                fromVal=(String)item;
                fromInd=pos;
                System.out.println(pos);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                from.setSelection(0);
            }
        });
        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                toVal=(String)item;
                toInd=pos;
                System.out.println(pos);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                to.setSelection(1);
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<String> route;
                if(fromVal!=null&&toVal!=null)
                {
                    dijkstra(bmuMap,fromInd,map);
                    int index=findRoute(toVal);
                    route=list.get(index);
                    int num=route.size();
                    final TextView[] myTextViews = new TextView[num]; // create an empty array;
                    for (int i = 0; i < num; i++) {
                        // create a new textview
                    final TextView path = new TextView(context);
                        // set some properties of rowTextView or something
                        path.setText(route.get(i));
                        // add the textview to the linearlayout
                        mapLayout.addView(path);
                        // save a reference to the textview for later
                        myTextViews[i] = path;
                    }
                }
            }
        });
    }
}