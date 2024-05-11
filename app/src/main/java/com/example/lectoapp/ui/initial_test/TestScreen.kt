package com.example.lectoapp.ui.initial_test

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun TestScreen(
    questions: List<TestQuestion>,
    currentQuestionIndex: Int,
    onAnswer: (TestOption) -> Unit,
    onContinue:()-> Unit

) {
    val currentQuestion = questions[currentQuestionIndex]
    when(currentQuestion.questionType) {

        QuestionType.Sound -> {
            SoundQuestion(
                question = currentQuestion,
                onAnswer = onAnswer,
                onContinue = onContinue
            )

        }

        QuestionType.Image -> {
            ImageQuestion(
                question = currentQuestion,
                onAnswer = onAnswer,
                onContinue = onContinue
            )

        }

    }
}

@Preview
@Composable
private fun TestScreenPreview() {
    MaterialTheme {
        Surface {
            TestScreen(
                questions = emptyList(),
                currentQuestionIndex = -1,
                onAnswer = {},
                onContinue = {}
            )
        }
    }
}