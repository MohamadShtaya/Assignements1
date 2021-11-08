package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.gson.Gson;


public class MainActivity3 extends Activity {
    String title;
    String description;
    String rules;
    ListView listview;
    Button Addbutton;
    EditText GetValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listview = (ListView) findViewById(R.id.listView1);
        Addbutton = (Button) findViewById(R.id.button1);
        GetValue = (EditText) findViewById(R.id.editText1);

        SharedPreferences sharedPreferences2 = getSharedPreferences("myAppPrefs2", Context.MODE_PRIVATE);
        String option = sharedPreferences2.getString("option",null);
        getUserInformation();
        String[] ListElements = new String[0];
        if(option.equals("Description")){
            ListElements = new String[] {
                    description
            };
        }
        else if(option.equals("Rules")){
            ListElements = new String[] {
                    rules
            };
        }
         List< String > list = new ArrayList < String >
                (Arrays.asList(ListElements));
        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs3", Context.MODE_PRIVATE);
        String json1 = sharedPreferences.getString("MyObject", "");
        list.add(json1);

        final ArrayAdapter < String > adapter = new ArrayAdapter < String >
                (MainActivity3.this, android.R.layout.simple_list_item_1,
                        list);

        listview.setAdapter(adapter);
        ArrayList<String> change = new ArrayList<>();

        Addbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                list.add(GetValue.getText().toString());
                change.add(GetValue.getText().toString());
                SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs3", Context.MODE_PRIVATE);

                Object myObject = new Object();
                Gson gson = new Gson();
                String json = gson.toJson(change);
                sharedPreferences.edit().putString("MyObject", json).apply();
                //SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs3", Context.MODE_PRIVATE);

                adapter.notifyDataSetChanged();
            }
        });





    }
    private void saveUserInformation(String title, String description,String rules) {

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("title", title).putString("Description", description).putString("rules",rules).apply();
    }
    private void getUserInformation() {

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);

         title = sharedPreferences.getString("title", null);
         description = sharedPreferences.getString("Description", null);
         rules = sharedPreferences.getString("rules", null);
    }
}

