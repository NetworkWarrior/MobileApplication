package com.example.mobileapp
import CredentialsManager
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileapp.databinding.LoginBinding
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginBinding
    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { handleLogin() }
        binding.tvRegisterNow.setOnClickListener { navigateToRegister() }
    }

    private fun handleLogin() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (!credentialsManager.isEmailValid(email)) {
            showError(binding.etEmail, "Invalid email format")
            return
        }

        if (!credentialsManager.isPasswordValid(password)) {
            showError(binding.etPassword, "Password cannot be empty")
            return
        }
        if (email == "test@te.st" && password == "1234") {
            navigateToHome() // Navigate to HomeActivity
        } else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showError(editText: TextInputEditText, errorMessage: String) {
        editText.error = errorMessage
        editText.requestFocus()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToRegister() {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }
}