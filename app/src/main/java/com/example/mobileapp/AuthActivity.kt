package com.example.mobileapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobileapp.fragments.LoginFragment
import com.example.mobileapp.fragments.RegisterFragment

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if (savedInstanceState == null) {
            loadFragment(LoginFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun showRegisterFragment() {
        loadFragment(RegisterFragment())
    }

    fun showLoginFragment() {
        loadFragment(LoginFragment())
    }
}
