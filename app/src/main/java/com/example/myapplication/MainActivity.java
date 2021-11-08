package com.example.myapplication;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import com.example.myapplication.model.Sportfactory;
import com.example.myapplication.model.iSportDa;


@SuppressLint("NewApi")
public class MainActivity extends Activity {

    public static int width, hight, fontsize, fonttitle;
    Button exit;
    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CustomGridViewAdapter customGridAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Define the size of layout
        Display display = getWindowManager().getDefaultDisplay();
        int widths = display.getWidth();
        int heights = display.getHeight();

        width = widths / 7;
        hight = heights / 20 ;
        fontsize = 13;
        fonttitle = 23;
        // exit button
        exit = (Button) findViewById(R.id.buttonend);
        exit.setTextSize(TypedValue.COMPLEX_UNIT_SP, fontsize);
        Drawable dre = getResources().getDrawable(R.drawable.exit);
        Bitmap bitmape = ((BitmapDrawable) dre).getBitmap();
        Drawable de = new BitmapDrawable(getResources(),
                Bitmap.createScaledBitmap(bitmape, widths / 20, heights / 15,true));
        exit.setBackgroundDrawable(de);

        /*** To end exit the program***/
        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        int Id1 = R.drawable.football;
        int Id2 = R.drawable.basketball;
        int Id3 = R.drawable.baseball;
        int Id4 = R.drawable.usafootball;
        int Id5 = R.drawable.volleyball;
        int Id6 = R.drawable.tabletennis;
        int Id7 = R.drawable.tennis;

        gridArray.add(new Item(BitmapFactory.decodeResource(this.getResources(), Id1), "  FootBall"));
        gridArray.add(new Item(BitmapFactory.decodeResource(this.getResources(), Id2), "   BasketBall"));
        gridArray.add(new Item(BitmapFactory.decodeResource(this.getResources(), Id3), "BaseBall"));
        gridArray.add(new Item(BitmapFactory.decodeResource(this.getResources(), Id4), "USFootball "));
        gridArray.add(new Item(BitmapFactory.decodeResource(this.getResources(), Id5), "VolleyBall"));
        gridArray.add(new Item(BitmapFactory.decodeResource(this.getResources(), Id6), "Table Tennis"));
        gridArray.add(new Item(BitmapFactory.decodeResource(this.getResources(), Id7), " Tennis "));


            Sportfactory factory = new Sportfactory();
            iSportDa objSport = factory.getModel();

        gridView = (GridView) findViewById(R.id.gridView1);
        customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid,gridArray);
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,int position, long id) {

                // FootBall
                if (position == 0) {

                    String[] football = objSport.getcategories(position);
                    saveUserInformation(football[0], football[1],football[2]);
                    Intent prevIntent = new Intent(MainActivity.this,
                            MainActivity2.class);
                    startActivity(prevIntent);

                }

                //BasketBall
                if (position == 1) {

                    String[] basketBall = objSport.getcategories(position);
                    saveUserInformation(basketBall[0], basketBall[1],basketBall[2]);
                    Intent prevIntent = new Intent(MainActivity.this,
                            MainActivity2.class);
                    startActivity(prevIntent);

                }

                //BaseBall
                if (position == 2) {

                    String[] baseBall = objSport.getcategories(position);
                    saveUserInformation(baseBall[0], baseBall[1],baseBall[2]);
                    Intent prevIntent = new Intent(MainActivity.this,
                            MainActivity2.class);
                    startActivity(prevIntent);

                }

                //American Football
                if (position == 3) {

                    String[] usFootball = objSport.getcategories(position);
                    saveUserInformation(usFootball[0], usFootball[1],usFootball[2]);
                    Intent prevIntent = new Intent(MainActivity.this,
                            MainActivity2.class);
                    startActivity(prevIntent);

                }

                //VolleyBall
                if (position == 4) {

                    String[] volleyBall = objSport.getcategories(position);
                    saveUserInformation(volleyBall[0], volleyBall[1],volleyBall[2]);
                    Intent prevIntent = new Intent(MainActivity.this,
                            MainActivity2.class);
                    startActivity(prevIntent);

                }


                //Table Tennis
                if (position == 5) {

                    String[] tTennis = objSport.getcategories(position);
                    saveUserInformation(tTennis[0], tTennis[1],tTennis[2]);
                    Intent prevIntent = new Intent(MainActivity.this,
                            MainActivity2.class);
                    startActivity(prevIntent);

                }

                //Tennis
                if (position == 6) {

                    String[] tennis = objSport.getcategories(position);
                    saveUserInformation(tennis[0], tennis[1],tennis[2]);
                    Intent prevIntent = new Intent(MainActivity.this,
                            MainActivity2.class);
                    startActivity(prevIntent);

                }
            }
        });

    }
    private void saveUserInformation(String title, String description,String rules) {

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("title", title).putString("Description", description).putString("rules",rules).apply();
    }
    private void getUserInformation() {

        SharedPreferences sharedPreferences = getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE);
        String title = sharedPreferences.getString("title", null);
        String description = sharedPreferences.getString("Description", null);
        String rules = sharedPreferences.getString("rules", null);
    }

}

