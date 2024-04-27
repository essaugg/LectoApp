package com.example.lectoapp.ui.initial_test

sealed class TestQuestion {
    data class Sound(
        val resId: Int,
        val text: String,
        val options: List<TestOption>,
        val answer: TestOption? = null
    ): TestQuestion()

    data class Image(
        val resId: Int,
        val text: String,
        val options: List<TestOption>,
        val answer: TestOption? = null
    ): TestQuestion()
}

data class TestOption(
    val id: String,
    val optionText: String,
    val resId: Int
)
