package com.example.book_library.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.book_library.R
import com.example.book_library.databinding.ActivityMain2Binding
import com.example.book_library.ui.genres.technics_books.TechnicBooksFragment
import com.example.book_library.ui.main_screen.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity(), MediatorBetweenFragments2 {
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMain2Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        navigationDrawerFeatures()
        openFragment2(MainFragment())
    }

    override fun openFragment2(fragment2: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_activityMain2, fragment2)
            .addToBackStack(null)
            .commit()
    }



    private fun navigationDrawerFeatures(){
        with(binding){
            toggle = ActionBarDrawerToggle(this@MainActivity2, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item1 -> {
//                       openFragment2(MainFragment())
                    }
                    R.id.item2 -> {
                        openFragment2(TechnicBooksFragment())
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