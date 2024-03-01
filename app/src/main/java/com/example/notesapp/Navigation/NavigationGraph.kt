package com.example.notesapp.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.data.NotesData
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.screens.HomeScreen
import com.example.notesapp.screens.HomeScreenViewModel
import com.example.notesapp.screens.NewNoteScreen
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState

@Composable
fun NavigationGraph() {

    val navController = rememberNavController()
    // IN KOTLIN IT IS DONE LIKE THIS :[ val homeScreenViewModel: HomeScreenViewModel by viewModels()
    val homeScreenViewModel: HomeScreenViewModel = viewModel()

    NavHost(navController = navController, startDestination = "homepage") {

        composable(route = "homepage") {
            HomepageViewModelCompose(homeScreenViewModel, navController)
            //HomeScreen(notes = NotesDataSource().LoadNotes(), navController = navController)
        }
        composable(route = "NewNoteScreen") {
            NewNoteScreenViewModelCompose(homeScreenViewModel, navController)
            //NewNoteScreen(navController = navController)
        }

    }

}

@Composable
fun HomepageViewModelCompose(
    homeScreenViewModel: HomeScreenViewModel,
    navController: NavController
) {
    var notesList = homeScreenViewModel.noteList.collectAsState().value
    HomeScreen(
        notes = notesList,
        navController = navController
    )
}

@Composable
fun NewNoteScreenViewModelCompose(
    homeScreenViewModel: HomeScreenViewModel,
    navController: NavController
) {
    var notesList = homeScreenViewModel.noteList.collectAsState().value

    NewNoteScreen(
        onAddNewNote = {
            homeScreenViewModel.addNote(it)
        },
        navController = navController
    )
}

