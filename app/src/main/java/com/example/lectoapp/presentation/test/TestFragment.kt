package com.example.lectoapp.presentation.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestFragment : Fragment() {

    private lateinit var composeView: ComposeView
    private val viewModel : TestViewModel by viewModels()



    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        composeView.setContent {
            MaterialTheme {
                Surface {
                    TestScreen(
                        questions = viewModel.questions,
                        currentQuestionIndex = viewModel.currentQuestionIndex.intValue,
                        onAnswer = {
                            viewModel.onAnswer(it)
                        },
                        onContinue = {
                            viewModel.onContinue()
                        }
                    )
                }
            }
        }
    }
}