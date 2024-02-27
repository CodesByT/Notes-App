package com.example.notesapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import com.example.notesapp.model.Note
import com.example.notesapp.model.fontFamily2
import com.example.notesapp.model.fontFamily3
import com.example.notesapp.ui.theme.Color2
import com.example.notesapp.ui.theme.Color3
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(note: Note){
    Card(
        modifier = Modifier.padding(3.dp),
        onClick = { /*TODO*/ },
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
                text= note.title,
                color = Color.White,
                fontFamily = fontFamily2,
                fontSize = 18.sp
            )
            Text(
                modifier = Modifier.padding(top=5.dp),
                text= note.entryData.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                color = Color(0xFF80DEEA),
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic
            )
            Text(
                modifier = Modifier.padding(top=5.dp),
                text = note.description,
                color = Color(0xEBFFFFFF),
                fontSize = 11.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
}