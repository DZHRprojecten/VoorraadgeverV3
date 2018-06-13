package com.exampledemo.parsaniahardik.sqlitemultitabledemonuts;

/**
 * Created by Parsania Hardik on 15/01/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Parsania Hardik on 11/01/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "users";
    private static final String TABLE_USER_HOBBY = "users_hobby";
    private static final String TABLE_USER_CITY = "users_city";
    private static final String TABLE_USER_ISINVOORRAAD = "users_isinvoorraad";
    private static final String TABLE_USER_ISINBOODSCHAPPEN = "users_isinboodschappenlijst";
    private static final String TABLE_USER_TIME_START = "users_time";
    private static final String KEY_ID = "id";
    private static final String KEY_USER_TIME_START = "users_time_start";
    private static final String KEY_FIRSTNAME = "name";
    private static final String KEY_HOBBY = "hobby";
    private static final String KEY_CITY = "city";
    private static final String KEY_ISINVOORRAAD = "isinvoorraad";
    private static final String KEY_ISINBOODSCHAPPEN = "isinboodschappen";


    /*CREATE TABLE students ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_number TEXT......);*/

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRSTNAME + " TEXT );";

    private static final String CREATE_TABLE_USER_HOBBY = "CREATE TABLE "
            + TABLE_USER_HOBBY + "(" + KEY_ID + " INTEGER,"+ KEY_HOBBY + " TEXT );";

    private static final String CREATE_TABLE_USER_CITY = "CREATE TABLE "
            + TABLE_USER_CITY + "(" + KEY_ID + " INTEGER,"+ KEY_CITY + " TEXT );";

    private static final String CREATE_TABLE_USER_ISINVOORRAAD = "CREATE TABLE "
            + TABLE_USER_ISINVOORRAAD + "(" + KEY_ID + " INTEGER,"+ KEY_ISINVOORRAAD + "TEXT );";

    private static final String CREATE_TABLE_USER_ISINBOODSCHAPPEN = "CREATE TABLE "
            + TABLE_USER_ISINBOODSCHAPPEN + "(" + KEY_ID + " INTEGER,"+ KEY_ISINBOODSCHAPPEN + "TEXT );";

    private static final String CREATE_TABLE_USER_TIME_START = "CREATE TABLE "
            + TABLE_USER_TIME_START + "(" + KEY_ID + " INTEGER,"+ KEY_USER_TIME_START + "TEXT );";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
        db.execSQL(CREATE_TABLE_USER_HOBBY);
        db.execSQL(CREATE_TABLE_USER_CITY);
        db.execSQL(CREATE_TABLE_USER_ISINVOORRAAD);
        db.execSQL(CREATE_TABLE_USER_ISINBOODSCHAPPEN);
        db.execSQL(CREATE_TABLE_USER_TIME_START);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_HOBBY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_CITY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_ISINVOORRAAD + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_ISINBOODSCHAPPEN + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_TIME_START + "'");
        onCreate(db);
    }

    public void addUser(String name, String hobby, String city, boolean voorraadlijst, boolean boodschappenlijst, String users_time_start){
        SQLiteDatabase db = this.getWritableDatabase();
        //adding user name in users table
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
       // db.insert(TABLE_USER, null, values);
        long id = db.insertWithOnConflict(TABLE_USER, null, values, SQLiteDatabase.CONFLICT_IGNORE);

        //adding user hobby in users_hobby table
        ContentValues valuesHobby = new ContentValues();
        valuesHobby.put(KEY_ID, id);
        valuesHobby.put(KEY_HOBBY, hobby);
        db.insert(TABLE_USER_HOBBY, null, valuesHobby);

        //adding user city in users_city table
        ContentValues valuesCity = new ContentValues();
        valuesCity.put(KEY_ID, id);
        valuesCity.put(KEY_CITY, city);
        db.insert(TABLE_USER_CITY, null, valuesCity);

        ContentValues valuesIsInVoorraad = new ContentValues();
        valuesIsInVoorraad.put(KEY_ID, id);
        if(voorraadlijst){
            valuesIsInVoorraad.put(KEY_ISINVOORRAAD, 1);}
        else if(!voorraadlijst){
            valuesIsInVoorraad.put(KEY_ISINVOORRAAD, 0);}
        db.insert(TABLE_USER_ISINVOORRAAD, null, valuesIsInVoorraad);

        ContentValues valuesIsInBoodschappen = new ContentValues();
        valuesIsInBoodschappen.put(KEY_ID, id);
        if(boodschappenlijst){
            valuesIsInBoodschappen.put(KEY_ISINBOODSCHAPPEN, 1);}
        else if(!boodschappenlijst){
            valuesIsInBoodschappen.put(KEY_ISINBOODSCHAPPEN, 0);}
        db.insert(TABLE_USER_ISINBOODSCHAPPEN, null, valuesIsInBoodschappen);

        ContentValues valuestimestart = new ContentValues();
        valuestimestart.put(KEY_ID, id);
        valuestimestart.put(KEY_USER_TIME_START, users_time_start );
        db.insert(TABLE_USER_TIME_START, null, valuestimestart);

    }

    public ArrayList<UserModel> getAllUsers(boolean voorraadlijst, boolean boodschappenlijst) {
        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();

        String selectQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                UserModel userModel = new UserModel();
                userModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                userModel.setProduct(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));


                            //getting user hobby where id = id from user_hobby table
                            String selectHobbyQuery = "SELECT  * FROM " + TABLE_USER_HOBBY +" WHERE "+KEY_ID+" = "+ userModel.getId();
                            Log.d("oppp",selectHobbyQuery);
                            //SQLiteDatabase dbhobby = this.getReadableDatabase();
                            Cursor cHobby = db.rawQuery(selectHobbyQuery, null);

                                        if (cHobby.moveToFirst()) {
                                            do {
                                                userModel.setAantal_dagen(cHobby.getString(cHobby.getColumnIndex(KEY_HOBBY)));
                                            } while (cHobby.moveToNext());
                                        }

                            //getting user city where id = id from user_city table
                            String selectCityQuery = "SELECT  * FROM " + TABLE_USER_CITY+" WHERE "+KEY_ID+" = "+ userModel.getId();;
                            //SQLiteDatabase dbCity = this.getReadableDatabase();
                            Cursor cCity = db.rawQuery(selectCityQuery, null);

                            if (cCity.moveToFirst()) {
                                do {
                                    userModel.setAantal_producten(cCity.getString(cCity.getColumnIndex(KEY_CITY)));
                                } while (cCity.moveToNext());
                            }

                            //getting user city where id = id from user_city table
                            if(voorraadlijst) {
                                String selectisinvoorraadQuery = "SELECT  * FROM " + TABLE_USER_ISINVOORRAAD + " WHERE " + KEY_ID + " = " + userModel.getId() + " AND " + KEY_ISINVOORRAAD + " = " + " 1";
                                ;
                                //SQLiteDatabase dbisinvoorraad = this.getReadableDatabase();
                                Cursor cinsinvooraad = db.rawQuery(selectisinvoorraadQuery, null);

                                if (cinsinvooraad.moveToFirst()) {
                                    do {
                                        userModel.setIsinvoorraad(cinsinvooraad.getString(cinsinvooraad.getColumnIndex(KEY_ISINVOORRAAD)));
                                    } while (cinsinvooraad.moveToNext());
                                }
                            }
                            if(!voorraadlijst) {
                                String selectisinvoorraadQuery = "SELECT  * FROM " + TABLE_USER_ISINVOORRAAD + " WHERE " + KEY_ID + " = " + userModel.getId() + " AND " + KEY_ISINVOORRAAD + " = " + " 0";
                                ;
                                //SQLiteDatabase dbisinvoorraad = this.getReadableDatabase();
                                Cursor cinsinvooraad = db.rawQuery(selectisinvoorraadQuery, null);

                                if (cinsinvooraad.moveToFirst()) {
                                    do {
                                        userModel.setIsinvoorraad(cinsinvooraad.getString(cinsinvooraad.getColumnIndex(KEY_ISINVOORRAAD)));
                                    } while (cinsinvooraad.moveToNext());
                                }
                            }
                            //getting user city where id = id from user_city table
                            if(boodschappenlijst) {
                                String selectisinboodschappenQuery = "SELECT  * FROM " + TABLE_USER_ISINBOODSCHAPPEN + " WHERE " + KEY_ID + " = " + userModel.getId() + " AND " + KEY_ISINBOODSCHAPPEN + " = " + " 1";
                                ;
                                //SQLiteDatabase dbCity = this.getReadableDatabase();
                                Cursor cisinboodschappen = db.rawQuery(selectisinboodschappenQuery, null);

                                if (cisinboodschappen.moveToFirst()) {
                                    do {
                                        userModel.setIsinboodschappen(cisinboodschappen.getString(cisinboodschappen.getColumnIndex(KEY_ISINBOODSCHAPPEN)));
                                    } while (cisinboodschappen.moveToNext());
                                }
                            }
                            else if(!boodschappenlijst) {
                                String selectisinboodschappenQuery = "SELECT  * FROM " + TABLE_USER_ISINBOODSCHAPPEN + " WHERE " + KEY_ID + " = " + userModel.getId() + " AND " + KEY_ISINBOODSCHAPPEN + " = " + " 0";
                                ;
                                //SQLiteDatabase dbCity = this.getReadableDatabase();
                                Cursor cisinboodschappen = db.rawQuery(selectisinboodschappenQuery, null);

                                if (cisinboodschappen.moveToFirst()) {
                                    do {
                                        userModel.setIsinboodschappen(cisinboodschappen.getString(cisinboodschappen.getColumnIndex(KEY_ISINBOODSCHAPPEN)));
                                    } while (cisinboodschappen.moveToNext());
                                }
                            }
                            //getting user city where id = id from user_city table
                            String selectTimeQuery = "SELECT  * FROM " + TABLE_USER_TIME_START+" WHERE "+KEY_ID+" = "+ userModel.getId();;
                            //SQLiteDatabase dbCity = this.getReadableDatabase();
                            Cursor cTime = db.rawQuery(selectTimeQuery, null);

                            if (cTime.moveToFirst()) {
                                do {
                                    userModel.setTime_Start(cTime.getString(cTime.getColumnIndex(KEY_USER_TIME_START)));
                                } while (cTime.moveToNext());
                            }




                // adding to Students list
                    userModelArrayList.add(userModel);
                } while (c.moveToNext());
         }
        return userModelArrayList;
    }

    public void updateUser(int id, String name, String hobby, String city, String isinvoorraad, String isinboodschappen, String users_time_start) {
        SQLiteDatabase db = this.getWritableDatabase();

        // updating name in users table
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        db.update(TABLE_USER, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        // updating hobby in users_hobby table
        ContentValues valuesHobby = new ContentValues();
        valuesHobby.put(KEY_HOBBY, hobby);
        db.update(TABLE_USER_HOBBY, valuesHobby, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        // updating city in users_city table
        ContentValues valuesCity = new ContentValues();
        valuesCity.put(KEY_CITY, city);
        db.update(TABLE_USER_CITY, valuesCity, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        ContentValues valuesIsinvoorraad = new ContentValues();
        valuesCity.put(KEY_ISINVOORRAAD, isinvoorraad);
        db.update(TABLE_USER_ISINVOORRAAD, valuesIsinvoorraad, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        ContentValues valuesIsinboodschappen = new ContentValues();
        valuesCity.put(KEY_ISINBOODSCHAPPEN, isinboodschappen);
        db.update(TABLE_USER_ISINBOODSCHAPPEN, valuesIsinboodschappen, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        ContentValues valuesTime = new ContentValues();
        valuesCity.put(KEY_USER_TIME_START,users_time_start);
        db.update(TABLE_USER_TIME_START, valuesTime, KEY_ID + " = ?", new String[]{String.valueOf(id)});

    }

    public void deleteUSer(int id) {

        // delete row in students table based on id
        SQLiteDatabase db = this.getWritableDatabase();

        //deleting from users table
        db.delete(TABLE_USER, KEY_ID + " = ?",new String[]{String.valueOf(id)});

        //deleting from users_hobby table
        db.delete(TABLE_USER_HOBBY, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        //deleting from users_city table
        db.delete(TABLE_USER_CITY, KEY_ID + " = ?",new String[]{String.valueOf(id)});

        db.delete(TABLE_USER_ISINVOORRAAD, KEY_ID + " = ?",new String[]{String.valueOf(id)});

        db.delete(TABLE_USER_ISINBOODSCHAPPEN, KEY_ID + " = ?",new String[]{String.valueOf(id)});

        db.delete(TABLE_USER_TIME_START, KEY_ID + " = ?",new String[]{String.valueOf(id)});

    }

}

