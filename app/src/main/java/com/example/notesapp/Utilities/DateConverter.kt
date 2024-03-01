package com.example.notesapp.Utilities

import androidx.room.TypeConverter
import java.util.Date

// Creating these converters so that ROOM DB will understand the correct type of this feild
class DateConverter {

    @TypeConverter
    fun timeStampFromDate(date: Date):Long{
        return date.time
    }
    @TypeConverter
    fun dateFromTimesStamp(timeStamp:Long):Date{
        return Date(timeStamp)
    }

}