package com.example.lectoapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lectoapp.R

class HomeFragment : Fragment() {
    private lateinit var composeView: ComposeView

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
            HomeScreen(
                onExercisesClick = {
                   findNavController().navigate(R.id.action_homeFragment_to_testFragment)
                },
                onAdvicesClick = {
                    findNavController().navigate(R.id.action_homeFragment_to_advicesFragment)
                },
                onMemoryGameClick = {
                    findNavController().navigate(R.id.action_homeFragment_to_memoryGameFragment)
                }
            )
        }
    }
}