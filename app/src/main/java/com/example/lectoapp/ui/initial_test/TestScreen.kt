package com.example.lectoapp.ui.initial_test

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestScreen() {
    Column {
        
    }
}

@Preview
@Composable
private fun TestScreenPreview() {
    MaterialTheme {
        Surface {
            TestScreen()
        }
    }
}