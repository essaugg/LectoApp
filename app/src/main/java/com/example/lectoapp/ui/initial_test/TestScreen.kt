package com.example.lectoapp.ui.initial_test

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
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