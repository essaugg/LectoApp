package com.example.lectoapp.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lectoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onExercisesClick: () -> Unit,
    onAdvicesClick: () -> Unit,
    onMemoryGameClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                windowInsets = WindowInsets(
                    top = 0.dp,
                    bottom = 0.dp
                ),
                title = {
                    Text(text = "Bienvenido")
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(it)
        ) {
            MenuItemCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                text = "Ejercicios",
                resId = R.drawable.menu_image_exercises,
                onClick = {
                    onExercisesClick()

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
                    onAdvicesClick()
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
                    onMemoryGameClick()
                }
            )
        }
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