package com.example.lectoapp.presentation.test

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProgressBar(
    progress: Float,
    max: Float
) {
    // Calcula el progreso como un valor flotante basado en el número total de clics permitidos
    val progressPercentage = (progress.toFloat() / max.toFloat()).coerceIn(0f, 1f)

    // Lógica para animar el progreso
    val size by animateFloatAsState(
        targetValue = progressPercentage,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    // Composición de la ProgressBar
    Column(
        modifier = Modifier
            .padding(
                top = 10.dp,
                start = 30.dp,
                end = 30.dp,
                bottom = 10.dp
            )
    ) {
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
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )
            // Progreso de la ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(MaterialTheme.colorScheme.onPrimaryContainer)
                    .animateContentSize()
            )
        }
    }
}

@Preview
@Composable
fun ProgressBarPreview() {
    MaterialTheme {
        ProgressBar(
            progress = 20f,
            max = 100f
        )
    }
}