package com.example.notesapp.Navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesapp.screens.HomeScreen
import com.example.notesapp.screens.HomeScreenViewModel
import com.example.notesapp.screens.NewNoteScreen
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.notesapp.model.Note
import com.example.notesapp.screens.NoteScreen
import java.util.UUID

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
        composable(
            route = "NoteScreen/{id}",
            arguments = listOf(
                navArgument(name = "id"){
                    type = NavType.StringType
                }
            )
        ) {backstackEntry->
            Log.d("","Working1.1 till here MR.T")
            // Need to get a note ID from previous screen

            NoteScreenViewModelCompose(
                homeScreenViewModel,
                navController,
                id = backstackEntry.arguments?.getString("id")
            )
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
    NewNoteScreen(
        onAddNewNote = {
            homeScreenViewModel.addNote(it)
        },
        navController = navController
    )
}

@Composable
fun NoteScreenViewModelCompose(
    homeScreenViewModel: HomeScreenViewModel,
    navController: NavController,
    id: String?
) {
    Log.d("","Working1.2 till here MR.T")

    var notesList = homeScreenViewModel.noteList.collectAsState().value
    Log.d("","Working1.3 till here MR.T")

    //Will Search note with the note ID, and load that note and send it to the NoteScreen
    val uuid:UUID = UUID.fromString(id)
    Log.d("","Working1.4 till here MR.T")

    val note: Note? = notesList.find{
        it.id == uuid
    }
    Log.d("","Working1.5 till here MR.T")
    Log.d("","this is note \n $note MR.T")

    if (note != null) {
        NoteScreen(
            onUpdateNote = {
                homeScreenViewModel.updateNote(it)
            },
            NOTE = note,
            navController = navController
        )
    }
}



