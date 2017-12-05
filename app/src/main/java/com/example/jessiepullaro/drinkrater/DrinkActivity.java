package com.example.jessiepullaro.drinkrater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


/**
 * Created by jessiepullaro on 12/3/17.
 */

public class DrinkActivity extends AppCompatActivity {

    private EditText name;
    private EditText type;
    private EditText abv;
    private Drink newDrink;
    private DrinkDBHelper drinkAdd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        name = (EditText) findViewById(R.id.editText3);
        type = (EditText) findViewById(R.id.editText5);
        abv = (EditText) findViewById(R.id.editText6);
        newDrink = new Drink("","", 0.0);
        drinkAdd = new DrinkDBHelper(this);

    }

    public void addToDB(View view){
        String nameInput = String.valueOf(name.getText().toString());
        Log.d("name",nameInput);
        String typeInput = String.valueOf(type.getText().toString());
        Log.d("Type", typeInput);
        Double abvInput = Double.valueOf(abv.getText().toString());

        newDrink.setDrinkName(nameInput);
        newDrink.setDrinkType(typeInput);
        newDrink.setABV(abvInput);

        drinkAdd.addDrink(newDrink);

        Intent i = new Intent(DrinkActivity.this, MenuActivity.class);
        startActivity(i);

    }
}
