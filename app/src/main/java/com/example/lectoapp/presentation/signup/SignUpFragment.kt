package com.example.lectoapp.presentation.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lectoapp.R
import com.example.lectoapp.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding: FragmentSignUpBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.txtSignup3.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
        }

        binding.btnBack2.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment)
        }

        binding.btnLogIn2.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
        }

        return binding.root
    }
}