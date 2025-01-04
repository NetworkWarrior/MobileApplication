package com.example.mobileapp

class CredentialsManager {

    fun isEmailValid(email: String): Boolean {
        if (email.isBlank()) return false
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
        return email.matches(emailRegex.toRegex())
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotBlank()
    }

    fun isValidUser(email: String, password: String): Boolean {
        return email == "test@te.st" && password == "1234"
    }
}
