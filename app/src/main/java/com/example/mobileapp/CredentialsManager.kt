package com.example.mobileapp

class CredentialsManager {

    // Store registered users (email as key, password as value)
    private val registeredUsers = mutableMapOf<String, String>()

    // Validate email format
    fun isEmailValid(email: String): Boolean {
        if (email.isBlank()) return false
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return email.matches(emailRegex.toRegex())
    }

    // Validate password (non-empty)
    fun isPasswordValid(password: String): Boolean {
        return password.isNotBlank()
    }

    // Check if the email/password pair is valid (case insensitive check)
    fun isValidUser(email: String, password: String): Boolean {
        return registeredUsers[email.toLowerCase()] == password
    }

    // Register a new user (case insensitive email check)
    fun registerUser(email: String, password: String): String {
        val emailLowercase = email.toLowerCase()

        return if (registeredUsers.containsKey(emailLowercase)) {
            "Email already taken"
        } else {
            registeredUsers[emailLowercase] = password
            "Registration successful"
        }
    }
}
