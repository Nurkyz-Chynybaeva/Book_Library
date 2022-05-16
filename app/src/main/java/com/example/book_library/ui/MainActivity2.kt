package com.example.book_library.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.book_library.R
import com.example.book_library.databinding.ActivityMain2Binding
import com.example.book_library.ui.main_screen.MainFragment

class MainActivity2 : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMain2Binding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        navigationDrawerFeatures()
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
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, MainFragment()).commit()
                    }
                    R.id.item2 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.container, MainFragment()).commit()
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