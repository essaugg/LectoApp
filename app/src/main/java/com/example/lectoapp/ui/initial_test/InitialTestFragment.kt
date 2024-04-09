package com.example.lectoapp.ui.initial_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lectoapp.databinding.FragmentInitialTestBinding

class InitialTestFragment: Fragment() {

    private var _binding: FragmentInitialTestBinding? = null
    private val binding: FragmentInitialTestBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInitialTestBinding.inflate(inflater, container, false)
        return binding.root
    }
}