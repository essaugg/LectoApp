package com.example.lectoapp.presentation.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lectoapp.presentation.test.questions.ImageQuestion
import com.example.lectoapp.presentation.test.questions.QuestionType
import com.example.lectoapp.presentation.test.questions.SoundQuestion
import com.example.lectoapp.presentation.test.questions.TestOption
import com.example.lectoapp.presentation.test.questions.TestQuestion


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestScreen(
    questions: List<TestQuestion>,
    currentQuestionIndex: Int,
    onAnswer: (TestOption) -> Unit,
    onContinue:()-> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                windowInsets = WindowInsets(
                    top = 0.dp,
                    bottom = 0.dp
                ),
                title = {
                    Text(text = "Cuestionario")
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            ProgressBar(progress = currentQuestionIndex.toFloat(), max = questions.size.toFloat())
            val currentQuestion = questions[currentQuestionIndex]
            when (currentQuestion.questionType) {

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
                onContinue = {},
                onBackPressed = {}
            )
        }
    }
}