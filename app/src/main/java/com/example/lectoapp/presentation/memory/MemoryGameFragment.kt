package com.example.lectoapp.presentation.memory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lectoapp.presentation.util.ObserveAsEvents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemoryGameFragment : Fragment() {

    private lateinit var composeView: ComposeView
    private val viewModel: MemoryGameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        composeView.setContent {
            val gameCards = viewModel.gameCards
            val pendingPairs by viewModel.pendingPairs

            var openEndingDialog by remember {
                mutableStateOf(false)
            }
            
            ObserveAsEvents(flow = viewModel.gameEventChannelFlow) { memoryGameEvent ->
                when(memoryGameEvent) {
                    is MemoryGameEvent.GameFinished -> {
                        openEndingDialog = true
                    }
                }
            }

            if (openEndingDialog) {
                MemoryGameEndingDialog(
                    onDismissRequest = {
                        openEndingDialog = false
                    },
                    onConfirmation = {
                        openEndingDialog = false
                    }
                )
            }

            MemoryGameScreen(
                pendingPairs = pendingPairs,
                gameCards = gameCards,
                onMemoryCardTap = {
                    viewModel.updateGameByFlip(it)
                },
                onBackPressed = {
                    findNavController().popBackStack()
                }
            )
        }
    }
}