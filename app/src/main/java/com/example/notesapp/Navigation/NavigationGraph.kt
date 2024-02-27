package com.example.notesapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.data.NotesData
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.screens.HomeScreen
import com.example.notesapp.screens.NewNoteScreen

@Composable
fun NavigationGraph(){
    
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homepage"){
        
        composable(route = "homepage"){
            HomeScreen(notes = NotesDataSource().LoadNotes(), navController = navController)
        }
        composable(route = "NewNoteScreen"){
            NewNoteScreen(navController = navController)
        }
        
    }

}