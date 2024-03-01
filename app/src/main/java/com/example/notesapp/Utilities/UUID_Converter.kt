package com.example.notesapp.Utilities

import androidx.room.TypeConverter
import java.util.UUID

// Creating these converters so that ROOM DB will understand the correct type of this feild
class UUID_Converter {
    @TypeConverter
    fun fromUUID(uuid: UUID):String{
        return uuid.toString()
    }
    @TypeConverter
    fun uuidfromString(string: String):UUID{
        return UUID.fromString(string)
    }

}