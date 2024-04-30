package com.example.lectoapp.ui.initial_test

data class TestQuestion(
    val resId: Int,
    val text: String,
    val options: List<TestOption>,
    var answer: TestOption? = null,
    val questionType: QuestionType
)

enum class QuestionType {
    Sound, Image
}

data class TestOption(
    val id: String,
    val optionText: String,
    val resId: Int
)
