package com.example.notesapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ExtendedFloatingActionButtonComponent(
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        containerColor = Color(0xFFFFFFFF),
        onClick = {
            onClick()
        },
        icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
        text = { Text(text = "New Note") },
    )
}