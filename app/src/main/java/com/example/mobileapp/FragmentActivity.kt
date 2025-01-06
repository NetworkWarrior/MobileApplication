package com.example.mobileapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobileapp.fragments.FragmentA
import com.example.mobileapp.fragments.FragmentB

class FragmentActivity : AppCompatActivity() {

    private var isFragmentAVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        replaceFragment(FragmentA())

        findViewById<Button>(R.id.btnToggleFragment).setOnClickListener {
            if (isFragmentAVisible) {
                replaceFragment(FragmentB())
            } else {
                replaceFragment(FragmentA())
            }
            isFragmentAVisible = !isFragmentAVisible
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
