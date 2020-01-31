package edu.csumb.spoplack.project1samryanjamesjose.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.csumb.spoplack.project1samryanjamesjose.User;
//import edu.csumb.jofausto.gymlogv2.DB.TypeConverters.DateTypeConverter;
//import edu.csumb.jofausto.gymlogv2.GymLog;

@Database(entities = {User.class}, version=1)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DBNAME = "db-gymlog";
    public static final String GYMLOG_TABLE = "gymlog";
    public abstract GymLogDAO getGymLogDAO();
}
