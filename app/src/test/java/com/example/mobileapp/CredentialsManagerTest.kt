package com.example.mobileapp
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.* // Import only JUnit 5 assertions

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
}