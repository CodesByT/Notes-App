package com.example.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.notesapp.Utilities.DateConverter
import com.example.notesapp.Utilities.UUID_Converter
import com.example.notesapp.model.Note

// This is the skeleton of our database
@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUID_Converter::class) // passing our converter class to ROOM DB
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDAO(): NoteDatabaseDAO
}