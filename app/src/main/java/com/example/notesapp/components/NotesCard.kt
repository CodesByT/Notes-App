package com.example.notesapp.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notesapp.model.Note
import com.example.notesapp.model.fontFamily2
import com.example.notesapp.ui.theme.Color2
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(note: Note, navController: NavController) {

    val formatter1 = DateTimeFormatter.ofPattern("dd MMM yyyy")
    val formatter2 = DateTimeFormatter.ofPattern("HH:mm")
    val formattedDate = LocalDateTime.ofInstant(note.entryData.toInstant(), ZoneId.systemDefault())
        .format(formatter1)
    val formattedTime = LocalDateTime.ofInstant(note.entryData.toInstant(), ZoneId.systemDefault())
        .format(formatter2)

    Log.d("", formattedDate)
    Card(
        modifier = Modifier.padding(3.dp),
        onClick = {
            Log.d("","Working till here MR.T")
            navController.navigate("NoteScreen/${note.id.toString()}")
            Log.d("","Working till here2 MR.T")

        },
        colors = CardDefaults.cardColors(
            containerColor = Color2
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),

    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                modifier = Modifier,
                text = note.title,
                color = Color.White,
                fontFamily = fontFamily2,
                fontSize = 18.sp
            )
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                    text = formattedDate,
                    color = Color(0xFF80DEEA),
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    modifier = Modifier.padding(top = 5.dp),
                text = formattedTime,
                color = Color(0xFF80DEEA),
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic
                )
            }

            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = note.description,
                color = Color(0xEBFFFFFF),
                fontSize = 11.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
}