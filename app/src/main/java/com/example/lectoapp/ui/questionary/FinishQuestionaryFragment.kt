package com.example.lectoapp.ui.questionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lectoapp.databinding.FragmentFinishQuestionaryBinding

class FinishQuestionaryFragment: Fragment() {

    private var _binding: FragmentFinishQuestionaryBinding? = null
    private val binding: FragmentFinishQuestionaryBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFinishQuestionaryBinding.inflate(inflater, container, false)


        return binding.root



    }

}