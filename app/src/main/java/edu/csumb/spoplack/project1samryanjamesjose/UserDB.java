package edu.csumb.spoplack.project1samryanjamesjose;



import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/*
private String username;
private String password;
private String FirstName;
private String LastName;
private int UserID;
*/
public class UserDB {

    public static final String DB_NAME = "users.db";
    public static final int    DB_VERSION = 1;

    public static final String USER_TABLE = "User";

    // user table constants
    public static final String USER_ID = "User_ID";
    public static final int    USER_ID_COL = 0;



    public static final String USERNAME = "username";
    public static final int    USERNAME_COL = 1;

    public static final String PASSWORD = "password";
    public static final int    PASSWORD_COL = 2;

    public static final String FirstName = "FirstName";
    public static final int    FirstName_COL = 3;

    public static final String LastName = "LastName";
    public static final int    LastName_COL = 4;





    // CREATE and DROP TABLE statements

    public static final String CREATE_USER_TABLE =
            "CREATE TABLE " + USER_TABLE + " (" +
                    USER_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    USERNAME       + " TEXT    NOT NULL, " +
                    PASSWORD   + " TEXT, " +
                    FirstName   + " TEXT, "  +
                    LastName + " TEXT " +  ");";



    public static final String DROP_USER_TABLE =
            "DROP TABLE IF EXISTS " + USER_TABLE;


    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name,
                        CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // create tables
            db.execSQL(CREATE_USER_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db,
                              int oldVersion, int newVersion) {



            db.execSQL(UserDB.DROP_USER_TABLE);
            onCreate(db);
        }
    }

    // database and database helper objects
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    // constructor
    public UserDB(Context context) {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }


    public ArrayList<User> getUserInfo(String username,String password) {
        String where = USERNAME + "= ?" + "AND " + PASSWORD + "=?";
        String[] whereArgs = { username,password };

        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(USER_TABLE, null,
                where, whereArgs,
                null, null, null);
        ArrayList<User> users = new ArrayList<User>();
        while (cursor.moveToNext()) {
            users.add(getUserFromCursor(cursor));
        }
        if (cursor != null)
            cursor.close();

        // close db
        if (db != null)
            db.close();

        return users;
    }

    public ArrayList<User> getUserName(String username) {
        String where = USERNAME + "= ?";
        String[] whereArgs = { username };

        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(USER_TABLE, null,
                where, whereArgs,
                null, null, null);
        ArrayList<User> users = new ArrayList<User>();
        while (cursor.moveToNext()) {
            users.add(getUserFromCursor(cursor));
        }
        if (cursor != null)
            cursor.close();

        // close db
        if (db != null)
            db.close();

        return users;
    }


    public ArrayList<User> validateUserInfo(String username) {
        String where = USERNAME + "= ?";
        String[] whereArgs = { username};

        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(USER_TABLE, null,
                where, whereArgs,
                null, null, null);
        ArrayList<User> users = new ArrayList<User>();
        while (cursor.moveToNext()) {
            users.add(getUserFromCursor(cursor));
        }
        if (cursor != null)
            cursor.close();

        // close db
        if (db != null)
            db.close();

        return users;
    }

    public ArrayList<User> getAllUsers() {

        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(USER_TABLE, null,
                null, null,
                null, null, null);
        ArrayList<User> users = new ArrayList<User>();
        while (cursor.moveToNext()) {
            users.add(getUserFromCursor(cursor));
        }
        if (cursor != null)
            cursor.close();

        // close db
        if (db != null)
            db.close();

        return users;
    }


    private static User getUserFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                User user = new User(

                        cursor.getString(USERNAME_COL),
                        cursor.getString(PASSWORD_COL),
                        cursor.getString(FirstName_COL),
                        cursor.getString(LastName_COL),
                        cursor.getInt(USER_ID_COL));

                return user;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

    public long insertUser(User user) {
        ContentValues cv = new ContentValues();
        cv.put(USERNAME, user.getUsername());
        cv.put(PASSWORD, user.getPassword());
        cv.put(FirstName, user.getFirstName());
        cv.put(LastName, user.getLastName());



        db = dbHelper.getWritableDatabase();
        long rowID = db.insert(USER_TABLE, null, cv);

        // close db
        if (db != null)
            db.close();

        return rowID;
    }


    public int updateUser(User user) {
        ContentValues cv = new ContentValues();
        cv.put(USERNAME, user.getUsername());
        cv.put(PASSWORD, user.getPassword());
        cv.put(FirstName, user.getFirstName());
        cv.put(LastName, user.getLastName());

        String where = USER_ID + "= ?";
        String[] whereArgs = { String.valueOf(user.getUserID()) };

        db = dbHelper.getWritableDatabase();
        int rowCount = db.update(USER_TABLE, cv, where, whereArgs);
        if (db != null)
            db.close();

        return rowCount;
    }

    public int deleteUser(long id) {
        String where = USER_ID + "= ?";
        String[] whereArgs = { String.valueOf(id) };

        db = dbHelper.getWritableDatabase();
        int rowCount = db.delete(USER_TABLE, where, whereArgs);
        if (db != null)
            db.close();

        return rowCount;
    }
}


