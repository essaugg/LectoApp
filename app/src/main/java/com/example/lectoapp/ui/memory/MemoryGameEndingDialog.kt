package com.example.lectoapp.ui.memory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
        buttons = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = onConfirmation
                ) {
                    Text(text = "Continuar")
                }
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