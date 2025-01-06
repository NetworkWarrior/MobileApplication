package com.example.mobileapp

import CredentialsManager
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapp.databinding.ActivityMainBinding
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

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (!credentialsManager.isEmailValid(email)) {
                etEmail.error = "Invalid email format"
                return@setOnClickListener
            }

            if (!credentialsManager.isPasswordValid(password)) {
                etPassword.error = "Password cannot be empty"
                return@setOnClickListener
            }

            if (!cbAgreeTerms.isChecked) {
                Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = credentialsManager.registerUser(email, password)
            if (result == "Registration successful") {
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvLogIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
