package com.example.notesapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun OurTextField(
    text: String,
    onValueChange: (String)->Unit,
    modifier: Modifier = Modifier,
    hintText: String = "",
    hintTextStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.bodySmall,
    textStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.bodySmall,
    maxlines: Int = 1,
    onImeAction: () ->Unit = {},
    flag: Boolean = false
){
    val keyboardController = LocalSoftwareKeyboardController.current
    BasicTextField(
        value = text,

        onValueChange= onValueChange,
        modifier = modifier,
        textStyle= textStyle,
        maxLines = maxlines,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = if(flag) ImeAction.Done else ImeAction.None

        ),
        keyboardActions = KeyboardActions(
            onDone = {
            onImeAction()
            keyboardController?.hide()
            },

        ),
        decorationBox = { innerTextField ->
            Box(){
                if(text.isEmpty()){
                    Text(text = hintText,style = hintTextStyle)
                }
                innerTextField()
            }

        }
    )
}
