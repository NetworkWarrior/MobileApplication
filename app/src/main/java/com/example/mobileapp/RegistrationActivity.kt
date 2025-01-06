package com.example.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapp.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val etFullName = binding.etFullName
        val etEmail = binding.etEmail
        val etPhoneNumber = binding.etPhoneNumber
        val etPassword = binding.etPassword
        val cbAgreeTerms = binding.cbAgreeTerms
        val btnRegister = binding.btnRegister

        // Handle register button click
        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Validate email and password before registering
            if (!credentialsManager.isEmailValid(email)) {
                // Handle invalid email
                etEmail.error = "Invalid email format"
                return@setOnClickListener
            }

            if (!credentialsManager.isPasswordValid(password)) {
                // Handle invalid password
                etPassword.error = "Password cannot be empty"
                return@setOnClickListener
            }

            // Check if terms and conditions are agreed
            if (!cbAgreeTerms.isChecked) {
                Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Register user
            val result = credentialsManager.registerUser(email, password)
            if (result == "Registration successful") {
                // Show success message
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()

                // Navigate to LoginActivity after successful registration
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Show error message if registration failed
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }

        // Handle log in text click
        binding.tvLogIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
