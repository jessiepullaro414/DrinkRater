package com.example.jessiepullaro.drinkrater;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jessiepullaro on 11/30/17.
 */

public class MenuActivity extends AppCompatActivity {

    private ListView reviewList;
    private FloatingActionButton fab;
//    FloatingActionButton myFab = (FloatingActionButton)  myView.findViewById(R.id.myFAB);
//    myFab.setOnClickListener(new View.OnClickListener() {
//        public void onClick(View v){
//            doMyThing();
//        }
    // Intent i = new Intent(MainActivity.this, TapActivity.class);
    // startActivity(i);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        reviewList = (ListView) findViewById(R.id.list_view);
        fab = (FloatingActionButton) findViewById(R.id.myFAB);

        List<String> array_list = new ArrayList<String>();
        array_list.add("Jameson Original");
        array_list.add("Bourbon County Brand Coffee Stout");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                array_list );

        reviewList.setAdapter(arrayAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void drinkMove (View view){

        Intent i = new Intent(MenuActivity.this, RateActivity.class);
        startActivity(i);

    }
}
