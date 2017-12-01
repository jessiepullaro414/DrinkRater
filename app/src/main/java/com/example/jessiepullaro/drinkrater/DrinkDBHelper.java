package com.example.jessiepullaro.drinkrater;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jessie on 11/30/17.
 */

public class DrinkDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;

    // db name
    private static final String DATABASE_NAME = "drinkManager";

    // table name
    private static final String TABLE_NAME = "drinkTable";

    // user table column names
    private static final String KEY_ID = "_id";
    private static final String KEY_DRINKTYPE = "drinkType";
    private static final String KEY_DRINKNAME = "drinkName";
    private static final String KEY_ABV = "ABV";

    // constructor
    public DrinkDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // creating table
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_DRINK_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_DRINKTYPE + " TEXT, "
                + KEY_DRINKNAME + " TEXT UNIQUE, "
                + KEY_ABV + " REAL)";

        db.execSQL(CREATE_DRINK_TABLE);
    }

    // upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // create table again
        onCreate(db);
    }

    /////************* All CRUD Operations (Create, Read, Update, and Delete) ***************

    // adding new drink
    public void addDrink(Drink drink){

        SQLiteDatabase db = this.getWritableDatabase();

        String insertStm = "INSERT INTO " + TABLE_NAME + "(" + KEY_DRINKTYPE + ", " + KEY_DRINKNAME + ", " + KEY_ABV + ") VALUES('" +
                drink.getDrinkType() + "', '" + drink.getDrinkName() + "', '" + drink.getABV() + "')";

        db.execSQL(insertStm);

        db.close(); // closing db connection
    }

    // getting single drink record with drink name
    public Drink getDrink(String drinkName){
        SQLiteDatabase db = this.getReadableDatabase();

        String queryStm = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_DRINKNAME + " = " + drinkName;

        Cursor c = db.rawQuery(queryStm, null);

        if (c != null) c.moveToFirst();

        Drink drink = new Drink(c.getString(0), c.getString(1), c.getDouble(2));

        db.close(); // closing db connection

        // return contact
        return drink;
    }


    // deleting single drink record (not needed at the moment)
    //public void deleteUser(Drink drink){
    //  SQLiteDatabase db = this.getWritableDatabase();
    //
    //  String deleteStm = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_DRINKNAME + " = " + drink.getDrinkName();
    //
    //  db.execSQL(deleteStm);
    //
    //  db.close(); // closing db connection
    //}
}
