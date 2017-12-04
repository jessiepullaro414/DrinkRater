package com.example.jessiepullaro.drinkrater;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jessie on 11/30/17.
 */

public class RatingDBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 2;

    // db name
    private static final String DATABASE_NAME = "drinkManager";

    // table name
    private static final String TABLE_NAME = "ratingTable";
    private static final String FOREIGN_TABLE_NAME_1 = "drinkTable";
    private static final String FOREIGN_TABLE_NAME_2 = "userTable";

    // user table column names
    private static final String KEY_ID = "_id";
    private static final String KEY_RATING = "rating";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_DRINKNAME = "drinkName";
    private static final String KEY_USERNAME = "username";

    // constructor
    public RatingDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // creating table FOREIGN KEY (group_id) REFERENCES supplier_groups(group_id)
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_DRINKNAME + " TEXT, "
                + KEY_USERNAME + " TEXT, "
                + KEY_RATING + " INTEGER, "
                + KEY_DESCRIPTION + " TEXT, "
                + "FOREIGN KEY (" + KEY_DRINKNAME + ") REFERENCES " + FOREIGN_TABLE_NAME_1 + "(" + KEY_DRINKNAME +"),"
                + "FOREIGN KEY (" + KEY_USERNAME + ") REFERENCES " + FOREIGN_TABLE_NAME_2 + "(" + KEY_USERNAME +"))";

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

        String insertStm = "INSERT INTO " + TABLE_NAME + "(" + KEY_DRINKNAME + ", " + KEY_USERNAME + ", "
                + KEY_RATING + ", " + KEY_DESCRIPTION + ") VALUES('" + rating.getDrinkName() + "', '"
                + rating.getUsername() + "', '" + rating.getRating() + "', '" + rating.getDescription() + "')";

        db.execSQL(insertStm);

        db.close(); // closing db connection
    }

    // getting single rating record by ID
    public Rating getRating(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        String queryStm = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + " = " + id;

        Cursor c = db.rawQuery(queryStm, null);

        if (c != null) c.moveToFirst();

        Rating rating = new Rating(c.getString(0), c.getString(1), Integer.parseInt(c.getString(2)),
                c.getString(3));

        db.close(); // closing db connection

        // return contact
        return rating;
    }

    // getting all the ratings associated with a drink's name storing them in an ArrayList of ratings
    public ArrayList<Rating> getRatings(String drinkName){
        ArrayList<Rating> ratingList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String queryStm = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_DRINKNAME + " = '" + drinkName + "'";

        Cursor c = db.rawQuery(queryStm, null);

        try{
            if (c != null){
                c.moveToFirst();
                for(int x = 0; x < c.getCount(); x++){
                    ratingList.add(new Rating(c.getString(0), c.getString(1), c.getInt(2), c.getString(3)));
                    c.moveToNext();
                }
            }
        }catch (Error e){
            // nothing
        }

        db.close(); // closing db connection

        // return list of ratings
        return ratingList;
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
