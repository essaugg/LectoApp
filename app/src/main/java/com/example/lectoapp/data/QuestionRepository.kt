package com.example.lectoapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.example.lectoapp.R

object QuestionRepository {
    val initialQuestions = listOf(
        InitialQuestion.Sound(
            expectedAnswer = "e",
            soundRawId = R.raw.alphabet_e,
            options = listOf(
                InitialQuestionOption(
                    optionValue = "a",
                    selectedResId = R.drawable.a,
                    unselectedResId = R.drawable.a_unselected
                ),
                InitialQuestionOption(
                    optionValue = "e",
                    selectedResId = R.drawable.e,
                    unselectedResId = R.drawable.e_unselected
                ),
                InitialQuestionOption(
                    optionValue = "i",
                    selectedResId = R.drawable.i,
                    unselectedResId = R.drawable.i_unselected
                ),
            )
        ),
        InitialQuestion.Sound(
            expectedAnswer = "u",
            soundRawId = R.raw.alphabet_e,
            options = listOf(
                InitialQuestionOption(
                    optionValue = "a",
                    selectedResId = R.drawable.a,
                    unselectedResId = R.drawable.a_unselected
                ),
                InitialQuestionOption(
                    optionValue = "u",
                    selectedResId = R.drawable.u,
                    unselectedResId = R.drawable.u_unselected
                ),
                InitialQuestionOption(
                    optionValue = "u",
                    selectedResId = R.drawable.i,
                    unselectedResId = R.drawable.i_unselected
                ),
            )
        ),
    )
}

data class InitialQuestionOption(
    val optionValue: String,
    @DrawableRes val selectedResId: Int,
    @DrawableRes val unselectedResId: Int
)

sealed class InitialQuestion {
    data class Sound(
        val expectedAnswer: String,
        @RawRes val soundRawId: Int,
        val options: List<InitialQuestionOption>
    ): InitialQuestion()

    data class Number(
        val expectedAnswer: String,
        val options: List<String>
    ): InitialQuestion()

    data class Word(
        val expectedAnswer: String,
        val options: List<InitialQuestionOption>
    ): InitialQuestion()

    data class CompleteWord(
        val expectedAnswer: String,
        val answer: String
    ): InitialQuestion()
}