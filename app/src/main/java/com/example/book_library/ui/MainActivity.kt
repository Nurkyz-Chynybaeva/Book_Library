package com.example.book_library.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.book_library.R
import com.example.book_library.databinding.ActivityMainBinding
import com.example.book_library.ui.main_screen.MainFragment
import com.example.book_library.ui.search_screen.SearchFragment
import com.example.book_library.ui.user_screen.UserFragment
import com.example.book_library.ui.welcome_screen.WelcomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MediatorBetweenFragments {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            openFragment(WelcomeFragment(), false)
        }
        bottomNavBar()
    }


    private fun bottomNavBar(){
        with(binding) {
            bottomNavigation.add(MeowBottomNavigation.Model(0, R.drawable.ic_home))
            bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_search))
            bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_person))

            bottomNavigation.setOnClickMenuListener {
                when (it.id){
                    0 -> openFragment(MainFragment.newInstance())
                    1 -> openFragment(SearchFragment.newInstance())
                    2 -> openFragment(UserFragment.newInstance())
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