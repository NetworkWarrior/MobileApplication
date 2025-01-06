package com.example.mobileapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobileapp.AuthActivity
import com.example.mobileapp.HomeActivity
import com.example.mobileapp.R
import com.example.mobileapp.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRegisterNow.setOnClickListener {
            (activity as AuthActivity).showRegisterFragment()
        }

        binding.btnLogin.setOnClickListener {
            handleLogin()
        }
    }

    private fun handleLogin() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        // Validate inputs
        if (email.isEmpty()) {
            showError(binding.etEmail, "Email cannot be empty")
            return
        }

        if (password.isEmpty()) {
            showError(binding.etPassword, "Password cannot be empty")
            return
        }

        if (email == "test@te.st" && password == "1234") {
            // Proceed to HomeActivity
            val intent = Intent(requireActivity(), HomeActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
            Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showError(editText: TextInputEditText, errorMessage: String) {
        editText.error = errorMessage
        editText.requestFocus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
