package com.example.notesapp.model

import android.annotation.SuppressLint
import android.os.Build
import android.security.keystore.StrongBoxUnavailableException
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description:String,
    val entryData: LocalDateTime = LocalDateTime.now()
)