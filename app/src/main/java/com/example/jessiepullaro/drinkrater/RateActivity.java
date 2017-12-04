package com.example.jessiepullaro.drinkrater;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.SeekBar;
import android.widget.Spinner;

/**
 * Created by jessiepullaro on 12/3/17.
 */

public class RateActivity extends AppCompatActivity {

    private SeekBar rateSetter;
    private Spinner spinner;
    private int rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        rateSetter = (SeekBar) findViewById(R.id.seekBar3);
        rateSetter.setOnSeekBarChangeListener(seekBar1);
        spinner = (Spinner) findViewById(R.id.spinner);
        initAdapter();


    }

    private void initAdapter(){
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.drinks_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void backToMenu(View view){
        //TODO add to DB
        Intent i = new Intent(RateActivity.this, MenuActivity.class);
        startActivity(i);
    }

    public void toDrinks(View view){
        Intent f = new Intent(RateActivity.this, DrinkActivity.class);
        startActivity(f);
    }


    private SeekBar.OnSeekBarChangeListener seekBar1 = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            rate = i;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    }
