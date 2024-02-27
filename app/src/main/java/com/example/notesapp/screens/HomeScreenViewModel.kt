package com.example.notesapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.model.Note

class HomeScreenViewModel : ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().LoadNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun deleteNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes(): List<Note> {
        return noteList
    }



}