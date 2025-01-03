package com.example.mobileapp

class CredentialsManager {

    fun isEmailValid(email: String): Boolean {
        // Check if email is empty
        if (email.isBlank()) return false

        // Basic regex for email validation
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return email.matches(emailRegex.toRegex())
    }

    fun isPasswordValid(password: String): Boolean {
        // Check if password is empty
        return password.isNotBlank()
    }
}
