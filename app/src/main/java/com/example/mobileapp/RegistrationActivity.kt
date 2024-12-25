package com.example.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Use your registration layout XML

        // Find the views
        val btnRegister = findViewById<MaterialButton>(R.id.btnRegister)
        val tvLogIn = findViewById<TextView>(R.id.tvLogIn)

        // Handle register button click
        btnRegister.setOnClickListener {
            // Perform registration logic (this is just a placeholder)
            // After registration, you can redirect to the login screen
            val intent = Intent(this, LoginActivity::class.java) // Go back to LoginActivity after registration
            startActivity(intent)
        }

        // Handle log in text click
        tvLogIn.setOnClickListener {
            // Redirect to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
