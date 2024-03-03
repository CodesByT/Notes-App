package com.example.notesapp.screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notesapp.R
import com.example.notesapp.components.OurTextField
import com.example.notesapp.model.Note
import com.example.notesapp.model.font1
import com.example.notesapp.model.fontFamily1
import com.example.notesapp.model.fontFamily2
import com.example.notesapp.model.fontFamily3
import com.example.notesapp.ui.theme.Color1
import com.example.notesapp.ui.theme.Color2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewNoteScreen(
    onAddNewNote: (Note) -> Unit,
    navController: NavController
) {
    var title by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }

    var title2 by remember { mutableStateOf("") }
    var note2 by remember { mutableStateOf("") }


    val context: Context = LocalContext.current
    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.background(color = Color1),
                title = {
                    Text(text = "New Note", fontFamily = fontFamily1, fontSize = 30.sp)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate("homepage") {
                                popUpTo("homepage") {
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp),
                        content = {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBackIos,
                                contentDescription = " BackIcon"
                            )
                        },
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color1),
                actions = {
                    IconButton(
                        onClick = {
                            // ADD NOTE TO LIST
                            if (note2 != note || title2 != title) {
                                if (title.isNotEmpty() && note.isNotEmpty()) {

                                    title2 = title
                                    note2 = note

                                    onAddNewNote(Note(title = title, description = note))
                                    Toast.makeText(context, "Note Saved", Toast.LENGTH_SHORT).show()

                                } else if (title.isNotEmpty() && note.isEmpty()) {
                                    Toast.makeText(context, "fill the note!!", Toast.LENGTH_SHORT)
                                        .show()
                                } else if (title.isEmpty() && note.isNotEmpty()) {
                                    Toast.makeText(context, "fill the title!!", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }

                        },
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp),
                        content = {
                            Icon(
                                modifier = Modifier
                                    .size(36.dp),
                                imageVector = Icons.Rounded.Save,
                                contentDescription = " Save Note Icon",
                                tint = Color.Black
                            )
                        },
                    )
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 20.dp, end = 10.dp),
                onClick = {
                    if (note2 != note || title2 != title) {

                        if (title.isNotEmpty() && note.isNotEmpty()) {

                            // ADD NOTE TO LIST
                            onAddNewNote(Note(title = title, description = note))
                            Toast.makeText(context, "Note Saved", Toast.LENGTH_SHORT).show()

                            navController.navigate("homepage") {
                                popUpTo("homepage") {
                                    inclusive = true
                                }
                            }
                        } else if (title.isNotEmpty() && note.isEmpty()) {
                            Toast.makeText(context, "fill the note!!", Toast.LENGTH_SHORT).show()
                        } else if (title.isEmpty() && note.isNotEmpty()) {
                            Toast.makeText(context, "fill the title!!", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Save,
                    contentDescription = " Save Note Icon",
                    tint = Color.Black
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(top = it.calculateTopPadding())
                .background(color = Color2)
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                OurTextField(
                    text = title,
                    onValueChange = {
                        if (it.length < 100)
                            title = it
                        else {
                            Toast.makeText(context, "Max limit 100 characters", Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                    modifier = Modifier
                        .padding(horizontal = 25.dp)
                        .padding(top = 45.dp, bottom = 25.dp)
                        .background(color = Color2),
                    hintText = "           Title",
                    hintTextStyle = LocalTextStyle.current.copy(
                        color = Color(0x9EFFFFFF),
                        fontSize = 27.sp,
                        fontFamily = fontFamily2,
                        textAlign = TextAlign.Center
                    ),
                    textStyle = LocalTextStyle.current.copy(
                        color = Color.White,
                        fontSize = 27.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = fontFamily2
                    ),
                    maxlines = 10,
                    flag = true
                )
            }
            Divider(color = Color(0x9EFFFFFF), modifier = Modifier.padding(horizontal = 30.dp))
            OurTextField(
                text = note,
                onValueChange = { note = it },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(15.dp)
                    .fillMaxWidth()
                    .background(color = Color2),
                hintText = "Write your note...",
                hintTextStyle = TextStyle(
                    color = Color(0x9EFFFFFF), fontSize = 19.sp, fontWeight = FontWeight.Medium,
                    fontFamily = fontFamily3
                ),
                textStyle = TextStyle(
                    color = Color(0xEBFFFFFF), fontSize = 19.sp, fontWeight = FontWeight.Medium,
                    fontFamily = fontFamily3
                ),
                maxlines = 500
            )

        }
    }
}