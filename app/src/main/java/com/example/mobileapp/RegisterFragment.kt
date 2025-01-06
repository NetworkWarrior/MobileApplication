package com.example.mobileapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileapp.AuthActivity
import com.example.mobileapp.R
import com.example.mobileapp.databinding.FragmentRegisterBinding
import com.google.android.material.textfield.TextInputEditText
import CredentialsManager

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val credentialsManager = CredentialsManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvLogIn.setOnClickListener {
            (activity as AuthActivity).showLoginFragment()
        }

        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val phoneNumber = binding.etPhoneNumber.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (fullName.isEmpty()) {
                showError(binding.etFullName, "Full name is required")
            } else if (email.isEmpty()) {
                showError(binding.etEmail, "Email is required")
            } else if (!credentialsManager.isEmailValid(email)) {
                showError(binding.etEmail, "Please enter a valid email address")
            } else if (phoneNumber.isEmpty()) {
                showError(binding.etPhoneNumber, "Phone number is required")
            } else if (password.isEmpty()) {
                showError(binding.etPassword, "Password is required")
            } else if (password.length < 6) {
                showError(binding.etPassword, "Password must be at least 6 characters")
            } else {
                val registrationResult = credentialsManager.registerUser(email, password)

                if (registrationResult == "Email already registered") {
                    showError(binding.etEmail, "Email is already registered")
                } else {
                    Toast.makeText(requireContext(), registrationResult, Toast.LENGTH_LONG).show()
                    (activity as AuthActivity).showLoginFragment()
                }
            }
        }
    }

    private fun showError(editText: TextInputEditText, message: String) {
        editText.error = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
