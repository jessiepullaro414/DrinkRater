package com.example.jessiepullaro.drinkrater;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jessie on 11/30/17.
 */

public class RatingDBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;

    // db name
    private static final String DATABASE_NAME = "ratingManager";

    // table name
    private static final String TABLE_NAME = "ratingTable";

    // user table column names
    private static final String KEY_ID = "_id";
    private static final String KEY_RATING = "rating";
    private static final String KEY_DESCRIPTION = "description";

    // constructor
    public RatingDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // creating table
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_RATING + " INTEGER, "
                + KEY_DESCRIPTION + " TEXT)";

        db.execSQL(CREATE_USER_TABLE);
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

    // adding new rating
    public void addRating(Rating rating){

        SQLiteDatabase db = this.getWritableDatabase();

        String insertStm = "INSERT INTO " + TABLE_NAME + " VALUES('" +
                rating.getRating() + "', '" + rating.getDescription() + "')";

        db.execSQL(insertStm);

        db.close(); // closing db connection
    }

    // getting single rating record by ID
    public Rating getRating(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        String queryStm = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + " = " + id;

        Cursor c = db.rawQuery(queryStm, null);

        if (c != null) c.moveToFirst();

        Rating rating = new Rating(Integer.parseInt(c.getString(0)), c.getString(1));

        db.close(); // closing db connection

        // return contact
        return rating;
    }

    // deleting single rating record (not needed at the moment)
    //public void deleteUser(int id){
    //  SQLiteDatabase db = this.getWritableDatabase();
    //
    //  String deleteStm = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ID + " = " + id;
    //
    //  db.execSQL(deleteStm);
    //
    //  db.close(); // closing db connection
    //}
}
