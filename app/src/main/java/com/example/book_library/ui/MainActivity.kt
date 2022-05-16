package com.example.book_library.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.book_library.R
import com.example.book_library.databinding.ActivityMainBinding
import com.example.book_library.ui.login_screen.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MediatorBetweenFragments {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            openFragment(LoginFragment(), false)
        }
        bottomNavBar()

    }


    private fun bottomNavBar(){
        with(binding) {
            bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_home))

            bottomNavigation.setOnClickMenuListener {
                when (it.id){
                    0 -> startActivity(Intent(Intent(this@MainActivity, MainActivity2::class.java)))
                }
            }
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