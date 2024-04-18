package com.example.lectoapp.ui.initial_test

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.lectoapp.R
import com.example.lectoapp.data.InitialQuestion
import com.example.lectoapp.data.InitialQuestionOption
import com.example.lectoapp.databinding.FragmentInitialTestBinding
import com.example.lectoapp.util.toUri
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InitialTestFragment: Fragment() {

    private var _binding: FragmentInitialTestBinding? = null
    private val binding: FragmentInitialTestBinding
        get() = _binding!!

    private val viewModel : InitialTestViewModel by viewModels()

    private val mediaPlayer by lazy { MediaPlayer() }

    private var currentOptions: List<InitialQuestionOption> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInitialTestBinding.inflate(inflater, container, false)
        initObservers()
        return binding.root
    }

    private fun initQuestionText(question: InitialQuestion, questionNumber: Int) {
        val questionText = when(question) {
            is InitialQuestion.Sound -> "$questionNumber. " + getString(R.string.question_sound_text)
            is InitialQuestion.Number -> "$questionNumber. " + getString(R.string.question_number_text)
            is InitialQuestion.Word -> "$questionNumber. " + getString(R.string.question_word_text)
            is InitialQuestion.CompleteWord -> "$questionNumber. " + getString(R.string.question_complete_word_text)
        }
        binding.soundQuestionLayout.questionText.text = questionText
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadTest()
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    renderUiState(it)
                }
            }
        }
    }

    private fun renderUiState(state: InitialTestViewModel.InitialTestUiState) {
        val currentQuestion = state.questions[state.currentQuestionIndex]

        initQuestionText(
            question = currentQuestion,
            questionNumber = state.currentQuestionIndex + 1
        )

        when(currentQuestion) {
            is InitialQuestion.Sound -> {
                mediaPlayer.reset()
                mediaPlayer.setDataSource(requireContext(), currentQuestion.soundRawId.toUri(requireContext()))
                mediaPlayer.prepare()
                renderSoundLayout()
                renderSoundOptions(currentQuestion.options)
                renderSoundSelection(state.currentSelection, currentOptions)
                renderNextButton(state.currentSelection)
                setupSoundQuestionClickListeners(state.currentSelection)
            }

            is InitialQuestion.Number -> {
                // render number question
            }

            else -> TODO()
        }
    }

    private fun renderSoundLayout() {
        binding.soundQuestionLayout.root.visibility = View.VISIBLE
    }

    private fun renderNextButton(selection: InitialQuestionOption?) {
        binding.soundQuestionLayout.nextButton.visibility = if (selection != null) View.VISIBLE
        else View.GONE
    }

    private fun renderSoundSelection(selection: InitialQuestionOption?, options: List<InitialQuestionOption>) {
        selection?.let {
            val optionIndexSelected = options.indexOf(selection)
            when(optionIndexSelected) {
                0 -> {
                    binding.soundQuestionLayout.firstOption.setImageResource(options[0].selectedResId)
                    binding.soundQuestionLayout.secondOption.setImageResource(options[1].unselectedResId)
                    binding.soundQuestionLayout.thirdOption.setImageResource(options[2].unselectedResId)
                }
                1 -> {
                    binding.soundQuestionLayout.firstOption.setImageResource(options[0].unselectedResId)
                    binding.soundQuestionLayout.secondOption.setImageResource(options[1].selectedResId)
                    binding.soundQuestionLayout.thirdOption.setImageResource(options[2].unselectedResId)
                }
                2 -> {
                    binding.soundQuestionLayout.firstOption.setImageResource(options[0].unselectedResId)
                    binding.soundQuestionLayout.secondOption.setImageResource(options[1].unselectedResId)
                    binding.soundQuestionLayout.thirdOption.setImageResource(options[2].selectedResId)
                }
            }
        }
    }

    private fun renderSoundOptions(options: List<InitialQuestionOption>) {
        currentOptions = options
        binding.soundQuestionLayout.firstOption.setImageResource(options[0].unselectedResId)
        binding.soundQuestionLayout.secondOption.setImageResource(options[1].unselectedResId)
        binding.soundQuestionLayout.thirdOption.setImageResource(options[2].unselectedResId)
    }

    private fun setupSoundQuestionClickListeners(selection: InitialQuestionOption?) {
        binding.soundQuestionLayout.playSoundButton.setOnClickListener {
            mediaPlayer.start()
        }

        binding.soundQuestionLayout.firstOption.setOnClickListener {
            viewModel.onSoundOptionSelected(currentOptions[0])
        }

        binding.soundQuestionLayout.secondOption.setOnClickListener {
            viewModel.onSoundOptionSelected(currentOptions[1])
        }

        binding.soundQuestionLayout.thirdOption.setOnClickListener {
            viewModel.onSoundOptionSelected(currentOptions[2])
        }
        binding.soundQuestionLayout.nextButton.setOnClickListener {
            selection?.let {
                viewModel.onNextClick(it)
            }
        }
    }
}