package com.example.lectoapp.ui.initial_test

import androidx.compose.material.Text
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun ProgressBar() {
    val viewModel: TestViewModel.ProgressBarViewModel = viewModel()
    val progressCount = viewModel.progressCount.value
    val maxProgress = viewModel.maxProgress

    // Calcula el progreso como un valor flotante basado en el número total de clics permitidos
    var progress = (progressCount.toFloat() / maxProgress.toFloat()).coerceIn(0f, 1f)

    // Lógica para animar el progreso
    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    // Composición de la ProgressBar
    Column(
        modifier = Modifier
            .padding(top = 10.dp, start = 30.dp, end = 30.dp, bottom = 10.dp)
    ) {
        // Texto sobre la ProgressBar
        Row(
            modifier = Modifier
                .widthIn(min = 30.dp)
                .fillMaxWidth(size),
            horizontalArrangement = Arrangement.End
        ) {
            //Progress
        }

        // ProgressBar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(17.dp)
        ) {
            // Fondo de la ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(9.dp))
                    .background(Color.LightGray)
            )
            // Progreso de la ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(Color.DarkGray)
                    .animateContentSize()
            )
        }
    }

    // Lógica para incrementar el progreso cuando se elimina la ProgressBar
    DisposableEffect(Unit) {
        onDispose {
            viewModel.incrementProgress()
        }
    }
}