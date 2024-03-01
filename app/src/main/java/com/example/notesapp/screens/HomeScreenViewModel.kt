package com.example.notesapp.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.Repository.NoteRepository
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: NoteRepository
): ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

//    private var noteList = mutableStateListOf<Note>()
//    private var deletedNotesList = mutableStateListOf<Note>()

    init {
        //noteList.addAll(NotesDataSource().LoadNotes())
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotesFromDB()
                .distinctUntilChanged()
                .collect{ it ->
                    if(it.isEmpty()){
                        Log.d("Empty","Empty")
                    }else{
                        _noteList.value = it
                    }
            }
        }
    }
   fun addNote(note: Note) = viewModelScope.launch {
        repository.addNoteInDB(note)
    }
    fun updateNote(note: Note) = viewModelScope.launch {
        repository.updateNoteFromDB(note)
    }
    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.deleteNoteFromDB(note)
    }


//    fun addNote(note: Note) {
//        noteList.add(note)
//    }
//
//    fun deleteNote(note: Note) {
//        noteList.remove(note)
//    }
//
//    fun getAllNotes(): List<Note> {
//        return noteList
//    }
//
//    fun addNoteInDeletedNotesList(note: Note) {
//        noteList.add(note)
//    }
//
//    fun deleteNotesFromDeletedNotesList(note: Note) {
//        noteList.remove(note)
//    }
//
//    fun getAllDeletedNotesList(): List<Note> {
//        return noteList
//    }


}