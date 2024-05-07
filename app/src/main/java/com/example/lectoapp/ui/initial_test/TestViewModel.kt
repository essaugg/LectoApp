package com.example.lectoapp.ui.initial_test

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.lectoapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private val dummyQuestions = listOf(

    //Vowel questions
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
    //Consonant questions
    TestQuestion(
        resId = R.raw.alphabet_e,
        text = "Pregunta sonido",
        options = listOf(
            TestOption(
                id = "l",
                optionText = "l",
                resId = R.drawable.l
            ),
            TestOption(
                id = "r",
                optionText = "r",
                resId = R.drawable.r
            ),
            TestOption(
                id = "t",
                optionText = "t",
                resId = R.drawable.t
            )
        ),
        questionType = QuestionType.Sound
    ),
    TestQuestion(
        resId = R.raw.alphabet_e,
        text = "Pregunta sonido",
        options = listOf(
            TestOption(
                id = "l",
                optionText = "l",
                resId = R.drawable.l
            ),
            TestOption(
                id = "r",
                optionText = "r",
                resId = R.drawable.r
            ),
            TestOption(
                id = "t",
                optionText = "t",
                resId = R.drawable.t
            )
        ),
        questionType = QuestionType.Sound
    ),

    //Animal question
    TestQuestion(
        resId = R.drawable.gato,
        text = "Pregunta imagen",
        options = listOf(
            TestOption(
                id = "gato",
                optionText = "gato",
                resId = R.drawable.gato
            ),
            TestOption(
                id = "perro",
                optionText = "perro",
                resId = R.drawable.perro
            ),
            TestOption(
                id = "pajaro",
                optionText = "pajaro",
                resId = R.drawable.pajaro
            )
        ),
        questionType = QuestionType.Image
    ),
    TestQuestion(
        resId = R.drawable.gato,
        text = "Pregunta imagen",
        options = listOf(
            TestOption(
                id = "gato",
                optionText = "gato",
                resId = R.drawable.gato
            ),
            TestOption(
                id = "perro",
                optionText = "perro",
                resId = R.drawable.perro
            ),
            TestOption(
                id = "pajaro",
                optionText = "pajaro",
                resId = R.drawable.pajaro
            )
        ),
        questionType = QuestionType.Image
    ),


    //Number questions
    TestQuestion(
        resId = R.drawable.tres,
        text = "Pregunta imagen",
        options = listOf(
            TestOption(
                id = "cuatro",
                optionText = "cuatro",
                resId = R.drawable.cuatro
            ),
            TestOption(
                id = "tres",
                optionText = "tres",
                resId = R.drawable.tres
            ),
            TestOption(
                id = "dos",
                optionText = "dos",
                resId = R.drawable.dos
            )
        ),
        questionType = QuestionType.Image
    ),
    TestQuestion(
        resId = R.drawable.tres,
        text = "Pregunta imagen",
        options = listOf(
            TestOption(
                id = "cuatro",
                optionText = "cuatro",
                resId = R.drawable.cuatro
            ),
            TestOption(
                id = "tres",
                optionText = "tres",
                resId = R.drawable.tres
            ),
            TestOption(
                id = "dos",
                optionText = "dos",
                resId = R.drawable.dos
            )
        ),
        questionType = QuestionType.Image
    ),

    //Word questions
    TestQuestion(
        resId = R.drawable.img_o,
        text = "Pregunta imagen",
        options = listOf(
            TestOption(
                id = "o2",
                optionText = "o",
                resId = R.drawable.img_o
            ),
            TestOption(
                id = "a2",
                optionText = "a",
                resId = R.drawable.img_a
            ),
            TestOption(
                id = "i2",
                optionText = "i",
                resId = R.drawable.img_i
            )
        ),
        questionType = QuestionType.Image
    ),
    TestQuestion(
        resId = R.drawable.img_o,
        text = "Pregunta imagen",
        options = listOf(
            TestOption(
                id = "o2",
                optionText = "o",
                resId = R.drawable.img_i
            ),
            TestOption(
                id = "a2",
                optionText = "a",
                resId = R.drawable.img_a
            ),
            TestOption(
                id = "i2",
                optionText = "i",
                resId = R.drawable.img_o
            )
        ),
        questionType = QuestionType.Image
    ),

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
        if(currentQuestionIndex.intValue<=(questions.size-2)){ //preguntas
            currentQuestionIndex.intValue += 1
        }
    }
}

data class TestUiState (
    val questions: List<TestQuestion>,
    val currentQuestionIndex: Int
)