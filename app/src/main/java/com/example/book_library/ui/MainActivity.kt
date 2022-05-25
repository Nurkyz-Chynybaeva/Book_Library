package com.example.book_library.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.book_library.R
import com.example.book_library.databinding.ActivityMainBinding
import com.example.book_library.ui.genres.technics_books.TechnicBooksFragment
import com.example.book_library.ui.login_screen.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MediatorBetweenFragments {
    private lateinit var binding : ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navigationDrawerFeatures()

        if (savedInstanceState == null) {
            openFragment(LoginFragment(), false)
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




    private fun navigationDrawerFeatures(){
        with(binding){
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item1 -> {
//                       openFragment2(MainFragment())
                    }
                    R.id.item2 -> {
                        openFragment(TechnicBooksFragment())
                    }

                }
                true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}