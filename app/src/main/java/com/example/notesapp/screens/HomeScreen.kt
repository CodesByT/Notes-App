package com.example.notesapp.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notesapp.R
import com.example.notesapp.components.ExtendedFloatingActionButtonComponent
import com.example.notesapp.components.NoteCard
import com.example.notesapp.data.NotesData
import com.example.notesapp.model.Note
import com.example.notesapp.model.fontFamily1
import com.example.notesapp.ui.theme.Color1

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    notes: List<Note>,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    // Show the Username here, the person logged in
                    Text(
                        "Notes",
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .padding(horizontal = 8.dp),
                        fontFamily = fontFamily1,
                        color = Color.Black,
                        fontSize = 35.sp
                    )

                },
                actions = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp),
                        content = {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                imageVector = Icons.Rounded.Favorite,
                                contentDescription = "Favourite Icons",
                                tint = Color.Black
                            )
                        },
                    )
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 15.dp),
                        content = {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                imageVector = Icons.Rounded.Delete,
                                contentDescription = "Favourite Icons",
                                tint = Color(
                                    0xFF830505
                                )
                            )
                        },
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color1
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButtonComponent(onClick = {
                navController.navigate("NewNoteScreen")
            })
        }
    ) {

        Box(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .fillMaxSize()
                .background(Color1)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .padding(top = 3.dp)
            ) {
                // Text("Notes",modifier = Modifier.padding(15.dp).padding(start = 10.dp), fontFamily = fontFamily1,color = Color.Black, fontSize = 35.sp)
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    verticalItemSpacing = 4.dp,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    content = {
                        items(notes) { note ->
                            NoteCard(note)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    //HomeScreen()
}