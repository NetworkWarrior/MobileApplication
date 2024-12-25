package com.example.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login) // Use your login layout XML

        // Find the views
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val tvRegisterNow = findViewById<TextView>(R.id.tvRegisterNow)

        // Handle login button click
        btnLogin.setOnClickListener {
            // Perform login logic (this is just a placeholder)
            // For now, just simulate the login process and go to the next activity.
            // You would replace this with actual authentication logic (e.g., checking credentials)
            val intent = Intent(this, HomeActivity::class.java) // Redirect to HomeActivity after login
            startActivity(intent)
        }

        // Handle register now text click
        tvRegisterNow.setOnClickListener {
            // Redirect to RegistrationActivity
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
