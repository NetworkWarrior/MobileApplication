package com.example.mobileapp

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun givenEmptyEmail_whenValidated_thenReturnFalse() {
        val result = credentialsManager.isEmailValid("")
        assertEquals(false, result)
    }

    @Test
    fun givenWrongFormatEmail_whenValidated_thenReturnFalse() {
        val result = credentialsManager.isEmailValid("invalid-email")
        assertEquals(false, result)
    }

    @Test
    fun givenWellFormattedEmail_whenValidated_thenReturnTrue() {
        val result = credentialsManager.isEmailValid("example@test.com")
        assertEquals(true, result)
    }

    @Test
    fun givenEmptyPassword_whenValidated_thenReturnFalse() {
        val result = credentialsManager.isPasswordValid("")
        assertEquals(false, result)
    }

    @Test
    fun givenFilledPassword_whenValidated_thenReturnTrue() {
        val result = credentialsManager.isPasswordValid("securePassword123")
        assertEquals(true, result)
    }

    @Test
    fun givenValidUser_whenValidated_thenReturnTrue() {
        credentialsManager.registerUser("test@te.st", "1234")
        val result = credentialsManager.isValidUser("test@te.st", "1234")
        assertEquals(true, result)
    }

    @Test
    fun givenInvalidUser_whenValidated_thenReturnFalse() {
        val result = credentialsManager.isValidUser("invalid@test.com", "wrongPassword")
        assertEquals(false, result)
    }

    // Test for registering a new user
    @Test
    fun givenNewEmail_whenRegistered_thenReturnSuccessMessage() {
        val result = credentialsManager.registerUser("newuser@example.com", "password123")
        assertEquals("Registration successful", result)
    }

    // Test for duplicate email registration
    @Test
    fun givenDuplicateEmail_whenRegistered_thenReturnErrorMessage() {
        credentialsManager.registerUser("test@te.st", "1234")
        val result = credentialsManager.registerUser("TEST@te.st", "newpassword")
        assertEquals("Email already taken", result)
    }

    // Ensure registration works for new email
    @Test
    fun givenNewUser_whenRegistered_thenLoginShouldWork() {
        credentialsManager.registerUser("newuser@example.com", "password123")
        val result = credentialsManager.isValidUser("newuser@example.com", "password123")
        assertEquals(true, result)
    }
}
