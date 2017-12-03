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

        // initial list of drinks
        String INIT_DRINK_LIST = "INSERT INTO " + TABLE_NAME + " (" +
                KEY_DRINKTYPE + ", " + KEY_DRINKNAME + ", " + KEY_ABV + ") VALUES " +
                "('Irish Whiskey', 'Jameson Original', .40)" +
                "('Irish Whiskey', 'Jameson Gold Reserve Irish Whiskey', .40)" +
                "('Irish Whiskey', 'Redbreast 12 Year Old Cask Strength Irish Whiskey', .586)" +
                "('Bourbon Whiskey', 'Hillrock Solera Aged Bourbon Whiskey', .463)" +
                "('Scotch Whiskey', 'Glenfiddich 12 YEAR OLD', .40)" +
                "('Scotch Whiskey', 'Glenfiddich 50 Year Old', .461)" +
                "('Scotch Whiskey', 'The Macallan Fine Oak 10 Years Old', .40)" +
                "('Anejo Tequila', 'Padre Azul Tequila Añejo', .40)" +
                "('Anejo Tequila', 'Patron Anejo Tequila', .40)" +
                "('Silver Tequila', 'Sauza Blue Tequila Silver', .40)" +
                "('Gold Tequila', 'Mexican Sunrise Gold Tequila', .40)" +
                "('Vodka', 'Pinnacle Vodka', .40)" +
                "('Vodka', 'Crystal Head Vodka', .40)" +
                "('Vodka', 'Svedka Vodka', .40)" +
                "('Gin', 'Bombay Gin', .43)" +
                "('Gin', 'Seagram's Gin', .40)" +
                "('Gin', 'Tanqueray Gin', .473)" +
                "('Aguardiente Rum', 'Aguardiente Cristal Rum', .30)" +
                "('Light Rum', 'Black Coral White Rum', .40)" +
                "('Flavored Rum', 'Bacardi Grapefruit Rum', .35)" +
                "('Brandy', 'Black Watch Vsop Brandy', .40)" +
                "('Cognac', 'Hennessy Vs Cognac', .40)" +
                "('Cognac', 'Remy Martin 1738 Accord Royal Cognac', .40)" +
                "('Imperial Stout', 'Goose Island Beer Co. Bourbon County Brand Coffee Stout', .129)" +
                "('American IPA', 'Tree House Brewing Company Julius', .068)" +
                "('Russian Imperial Stout', 'Firestone Walker Brewing Co. Parabola', .14)" +
                "('American Pale Ale', 'Trillium Brewing Company Double Dry Hopped Fort Point Pale Ale', .066)" +
                "('Cabernet Sauvignon', 'Belguardo Maremma Toscana 2013', .146)" +
                "('Pinot Noir', 'Greywacke Pinot Noir 2014', .14)" +
                "('Zinfandel', 'High Valley Vineyards Zinfandel 2015', .151)" +
                "('Chardonnay', 'Rombauer Chardonnay 2016', .145)";

        db.execSQL(INIT_DRINK_LIST);

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

        String insertStm = "INSERT INTO " + TABLE_NAME + " (" + KEY_DRINKTYPE + ", " + KEY_DRINKNAME + ", " + KEY_ABV + ") VALUES('" +
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
