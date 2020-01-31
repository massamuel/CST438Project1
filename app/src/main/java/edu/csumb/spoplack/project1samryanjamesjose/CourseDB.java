package edu.csumb.spoplack.project1samryanjamesjose;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/*
private String Instructor;
    private String Title;
    private String Description;
    private String StartDate;
    private String EndDate;
    private long courseID;

 */

public class CourseDB {
    public static final String COURSE_TABLE = "User";

    // user table constants

    public static final String Course_ID = "courseID";
    public static final int    Course_ID_COL = 0;

    public static final String INSTRUCTOR = "Instructor";
    public static final int    INSTRUCTOR_COL = 1;

    public static final String TITLE = "Title";
    public static final int    TITLE_COL = 1;

    public static final String DESCRIPTION = "Description";
    public static final int    DESCRIPTION_COL = 3;

    public static final String STARTDATE = "StartDate";
    public static final int    STARTDATE_COL = 4;

    public static final String ENDDATE = "EndDate";
    public static final int    ENDDATE_COL = 5;


    public static final String CREATE_Course_TABLE =
            "CREATE TABLE " + COURSE_TABLE + " (" +
                    Course_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    INSTRUCTOR       + " TEXT    NOT NULL, " +
                    TITLE   + " TEXT, " +
                    DESCRIPTION   + " TEXT, "  +
                    STARTDATE + " TEXT " +  "," +
                    ENDDATE + " TEXT  " + ");";



    public static final String DROP_COURSE_TABLE =
            "DROP TABLE IF EXISTS " + COURSE_TABLE;


}
