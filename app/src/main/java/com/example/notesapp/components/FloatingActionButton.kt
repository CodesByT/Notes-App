package com.example.notesapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.model.fontFamily1

@Composable
fun ExtendedFloatingActionButtonComponent(
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        containerColor = Color(0xD5FFFFFF),
        onClick = {
            onClick()
        },
        icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
        text = { Text(text = "New Note", fontFamily = fontFamily1, fontSize = 20.sp) },
    )
}