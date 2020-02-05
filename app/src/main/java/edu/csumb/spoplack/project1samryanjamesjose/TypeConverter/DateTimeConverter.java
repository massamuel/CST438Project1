package edu.csumb.spoplack.project1samryanjamesjose.TypeConverter;

import java.util.Date;
import androidx.room.TypeConverter;

public class DateTimeConverter {
    @TypeConverter
    public long convertDateToLong(Date date) {
        return date.getTime();
    }
    @TypeConverter
    public Date convertLongToDate(long time) {
        return new Date(time);
    }

}
