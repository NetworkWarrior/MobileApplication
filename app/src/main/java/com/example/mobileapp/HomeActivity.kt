package com.example.mobileapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobileapp.fragments.FragmentA
import com.example.mobileapp.fragments.FragmentB

class HomeActivity : AppCompatActivity() {

    private var isFragmentA: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnSwitchFragment: Button = findViewById(R.id.btnSwitchFragment)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentA())
                .commit()
        }
        btnSwitchFragment.setOnClickListener {
            val fragment: Fragment = if (isFragmentA) {
                FragmentB()
            } else {
                FragmentA()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
            isFragmentA = !isFragmentA
        }
    }
}
