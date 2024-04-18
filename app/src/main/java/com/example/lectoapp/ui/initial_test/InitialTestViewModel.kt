package com.example.lectoapp.ui.initial_test

import androidx.lifecycle.ViewModel
import com.example.lectoapp.data.InitialQuestion
import com.example.lectoapp.data.InitialQuestionOption
import com.example.lectoapp.data.QuestionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class InitialTestViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState : MutableStateFlow<InitialTestUiState> = MutableStateFlow(InitialTestUiState())
    val uiState : StateFlow<InitialTestUiState> = _uiState.asStateFlow()

    fun loadTest() {
        val questions = QuestionRepository.initialQuestions.shuffled()
        _uiState.update {
            it.copy(
                questions =  questions,
                currentSelection = null,
                currentQuestionIndex = 0
            )
        }
    }

    fun onSoundOptionSelected(option: InitialQuestionOption) {
        _uiState.update {
            it.copy(
                currentSelection = option
            )
        }
    }

    fun onNextClick(selection: InitialQuestionOption) {
        val answers = _uiState.value.answers
        answers.add(selection.optionValue)
        _uiState.update {
            it.copy(
                answers = answers,
                currentQuestionIndex = it.currentQuestionIndex + 1,
                currentSelection = null
            )
        }
    }

    data class InitialTestUiState(
        val questions: List<InitialQuestion> = emptyList(),
        val currentSelection: InitialQuestionOption? = null,
        val answers: MutableList<String> = mutableListOf(), // Remove this, add to InitialQuestion
        val currentQuestionIndex: Int = 0
    )
}