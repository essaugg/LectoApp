package com.example.lectoapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Test() {

}

@Preview
@Composable
private fun TestPreview() {
    MaterialTheme {
        Surface {
            val colorBoxes = listOf(
                Color.Blue,
                Color.Cyan,
                Color.Gray
            )
            LazyColumn (modifier=Modifier.fillMaxSize())
            {
                item {
                    colorBoxes.forEach{
                        Box(modifier = Modifier
                            .size(400.dp)
                            .background(color = it)){

                        }
                    }
                }
                items(colorBoxes){
                    Box(modifier = Modifier
                        .size(400.dp)
                        .background(color = it)){

                    }
                }

            }
        }
    }
}

/**
@Preview
@Composable
private fun TextPreview(){
    MaterialTheme{
        Surface {
            var text ="valor por defecto"
            var textRemember by remember {
                mutableStateOf("valor por defecto")
            }
            Column {
                TextField(value = text, onValueChange = {
                    text=it
                })
                TextField(value = textRemember, onValueChange = {
                    textRemember=it
                })
            }

        }
    }
}
 **/