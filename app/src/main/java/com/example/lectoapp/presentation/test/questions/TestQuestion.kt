package com.example.lectoapp.presentation.test.questions

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
