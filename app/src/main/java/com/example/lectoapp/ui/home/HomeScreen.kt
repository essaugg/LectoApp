package com.example.lectoapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lectoapp.R

@Composable
fun HomeScreen(
    onExercisesClick: () -> Unit,
    onAdvicesClick: () -> Unit,
    onMemoryGameClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Bienvenido")

        Spacer(modifier = Modifier.height(16.dp))

        MenuItemCard(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            text = "Ejercicios",
            resId = R.drawable.menu_image_exercises,
            onClick = {

            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuItemCard(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            text = "Consejos",
            resId = R.drawable.menu_image_advices,
            onClick = {

            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuItemCard(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            text = "Memorama",
            resId = R.drawable.menu_image_memory,
            onClick = {

            }
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme {
        Surface {
            HomeScreen(
                onAdvicesClick = {},
                onExercisesClick = {},
                onMemoryGameClick = {}
            )
        }
    }
}