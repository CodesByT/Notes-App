package com.example.notesapp.Repository

import com.example.notesapp.data.NoteDatabaseDAO
import com.example.notesapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


// Repository is a single source of truth for all app data, clean
// API for UI to communicate with
class NoteRepository @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDAO
) {

    suspend fun addNoteInDB(note: Note) = noteDatabaseDao.insertNote(note = note)
    suspend fun updateNoteFromDB(note: Note) = noteDatabaseDao.update(note = note)
    suspend fun deleteNoteFromDB(note: Note) = noteDatabaseDao.deleteNote(note = note)
    suspend fun deleteAllnotesFromDB() = noteDatabaseDao.deleteAll()
    fun getAllNotesFromDB():
            Flow<List<Note>> = noteDatabaseDao.getNotes()
                .flowOn(Dispatchers.IO)
                .conflate()
}