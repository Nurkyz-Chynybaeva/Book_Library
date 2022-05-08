package com.example.book_library.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.book_library.R
import com.example.book_library.databinding.ActivityMainBinding
import com.example.book_library.ui.welcome_screen.WelcomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MediatorBetweenFragments {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            openFragment(WelcomeFragment(), false)
        }
    }

    override fun openFragment(fragment: Fragment, addToBackStack: Boolean?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view, fragment).apply {
                if (addToBackStack == true) {
                    addToBackStack(null)
                }
            }
            .commit()
    }
}