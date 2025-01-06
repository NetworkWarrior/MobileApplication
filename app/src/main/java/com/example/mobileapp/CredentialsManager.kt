class CredentialsManager {

    private val users = mutableMapOf<String, String>()

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(password: String): Boolean {
        return password.isNotBlank()
    }

    fun isValidUser(email: String, password: String): Boolean {
        return users[email] == password
    }

    fun registerUser(email: String, password: String): String {
        return if (users.containsKey(email)) {
            "Email already registered"
        } else {
            users[email] = password
            "Registration successful"
        }
    }
}
