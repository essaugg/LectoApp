package com.example.lectoapp.presentation.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lectoapp.R
import com.example.lectoapp.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {

    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding: FragmentForgotPasswordBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_logInFragment)
        }

        binding.txtSignup2.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_signUpFragment)
        }

        return binding.root



    }
}