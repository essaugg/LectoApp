package com.example.lectoapp.presentation.memory

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MemoryGameEndingDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    AlertDialog(
        title = { Text(text = "Juego terminado") },
        text = { Text(text = "Se han enviado tus respuestas") },
        confirmButton = {
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = onConfirmation
            ) {
                Text(text = "Continuar")
            }
        },
        onDismissRequest = onDismissRequest
    )
}

@Preview
@Composable
private fun MemoryGameEndingDialogPreview() {
    MaterialTheme {
        Surface {
            MemoryGameEndingDialog(onDismissRequest = {}, onConfirmation = {})
        }
    }
}