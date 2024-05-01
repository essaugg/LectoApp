package com.example.lectoapp.ui.initial_test

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.lectoapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private val dummyQuestions = listOf(
    TestQuestion(
        resId = R.raw.alphabet_e,
        text = "Pregunta sonido",
        options = listOf(
            TestOption(
                id = "e",
                optionText = "e",
                resId = R.drawable.e
            ),
            TestOption(
                id = "a",
                optionText = "a",
                resId = R.drawable.a
            ),
            TestOption(
                id = "i",
                optionText = "i",
                resId = R.drawable.i
            )
        ),
        questionType = QuestionType.Sound
    ),
    TestQuestion(
        resId = R.raw.alphabet_e,
        text = "Pregunta sonido",
        options = listOf(
            TestOption(
                id = "e",
                optionText = "e",
                resId = R.drawable.e
            ),
            TestOption(
                id = "a",
                optionText = "a",
                resId = R.drawable.a
            ),
            TestOption(
                id = "i",
                optionText = "i",
                resId = R.drawable.i
            )
        ),
        questionType = QuestionType.Sound
    ),
    TestQuestion(
        resId = R.raw.alphabet_e,
        text = "Pregunta sonido",
        options = listOf(
            TestOption(
                id = "e",
                optionText = "e",
                resId = R.drawable.e
            ),
            TestOption(
                id = "a",
                optionText = "a",
                resId = R.drawable.a
            ),
            TestOption(
                id = "i",
                optionText = "i",
                resId = R.drawable.i
            )
        ),
        questionType = QuestionType.Sound
    )
)

@HiltViewModel
class TestViewModel @Inject constructor(

) : ViewModel() {

    var questions = mutableStateListOf<TestQuestion>(
        *dummyQuestions.toTypedArray()
    )
    val currentQuestionIndex = mutableIntStateOf(0)

    fun onAnswer(answer: TestOption) {
        questions[currentQuestionIndex.intValue] = questions[currentQuestionIndex.intValue].copy(
            answer = answer
        )
    }

    fun onContinue() {
        if(currentQuestionIndex.intValue<=(questions.size-2)){
            currentQuestionIndex.intValue += 1
        }
    }
}

data class TestUiState (
    val questions: List<TestQuestion>,
    val currentQuestionIndex: Int
)