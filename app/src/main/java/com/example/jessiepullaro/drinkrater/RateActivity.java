package com.example.jessiepullaro.drinkrater;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SeekBar;

/**
 * Created by jessiepullaro on 12/3/17.
 */

public class RateActivity extends AppCompatActivity {

    private SeekBar rateSetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        rateSetter = (SeekBar) findViewById(R.id.seekBar3);
        rateSetter.setOnSeekBarChangeListener(seekBar1);


    }

    public void backToMenu(View view){
        Intent i = new Intent(RateActivity.this, MenuActivity.class);
        startActivity(i);
    }


    private SeekBar.OnSeekBarChangeListener seekBar1 = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    }
