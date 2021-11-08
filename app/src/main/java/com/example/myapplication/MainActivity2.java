package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity2 extends Activity {

    Button exit, agree;
    int fontsize, size, titlefontsize;
    Spinner coins;
    String Title;
    String description;
    String rules;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        size = (width / 3) - 20;
        fontsize = 20;
        titlefontsize = 30;
        exit =(Button)findViewById(R.id.button3);
        exit.setText("Back ");
        exit.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontsize);
        exit.setGravity(Gravity.CENTER_HORIZONTAL);
        agree = (Button)findViewById(R.id.button4);
        agree.setText("OK ");
        agree.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontsize);
        agree.setGravity(Gravity.CENTER_HORIZONTAL);
        Thread thread = new Thread(new MyTask(5));

        thread.start();

        coins = (Spinner) findViewById(R.id.spinner1);

        /**To Load data from sharedPreferences**/
        getUserInformation();
        List<String> list = new ArrayList<String>();
        list.add("Description");
        list.add("Rules");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coins.setAdapter(dataAdapter);

        coins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                Object item = parent.getItemAtPosition(pos);
                String item2=item.toString();
                if(item2.equals("Description")){

                    SharedPreferences sharedPreferences2 = getSharedPreferences("myAppPrefs2", Context.MODE_PRIVATE);
                    sharedPreferences2.edit().putString("option", item2).apply();
                }
                else if (item2.equals("Rules")){

                    SharedPreferences sharedPreferences2 = getSharedPreferences("myAppPrefs2", Context.MODE_PRIVATE);
                    sharedPreferences2.edit().putString("option", item2).apply();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // To end exit the program
        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent prevIntent = new Intent(MainActivity2.this,
                        MainActivity.class);
                startActivity(prevIntent);
            }
        });


        agree.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            Intent prevIntent = new Intent(MainActivity2.this,
                    MainActivity3.class);
            startActivity(prevIntent);

        });

    }
    private void saveUserInformation(String title, String description,String rules) {

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("title", title).putString("Description", description).putString("rules",rules).apply();
    }
    private void getUserInformation() {

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        Title = sharedPreferences.getString("title", null);
        description = sharedPreferences.getString("Description", null);
        rules = sharedPreferences.getString("rules", null);
    }
    class MyTask implements Runnable{
        int seconds;

        public MyTask(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run() {

            for(int i = 0; i<seconds; i++){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}