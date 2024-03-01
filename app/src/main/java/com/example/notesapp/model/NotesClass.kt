package com.example.notesapp.model

import android.annotation.SuppressLint
import android.os.Build
import android.security.keystore.StrongBoxUnavailableException
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.Date
import java.util.UUID

@Entity(tableName = "NOTES")
data class Note(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_description")
    val description: String,

    @ColumnInfo(name = "note_updation_time")
    val entryData: Date = Date.from(Instant.now())
    //val entryData: LocalDateTime = LocalDateTime.now()

)