package edu.csumb.spoplack.project1samryanjamesjose.Database.User;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase instance;

    public abstract UserDao noteDao();

    public static synchronized UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
