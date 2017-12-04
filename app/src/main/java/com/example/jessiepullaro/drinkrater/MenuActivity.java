package com.example.jessiepullaro.drinkrater;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

/**
 * Created by jessiepullaro on 11/30/17.
 */

public class MenuActivity extends AppCompatActivity {

    private ExpandableListView reviewList;
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

        reviewList = (ExpandableListView) findViewById(R.id.expandable_listview);
        fab = (FloatingActionButton) findViewById(R.id.myFAB);

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
