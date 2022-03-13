package com.example.app_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app_project.databinding.ActivityMainBinding
import com.example.app_project.fragment.HistoryFragment
import com.example.app_project.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bottomnav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomnav.setOnNavigationItemSelectedListener(bottomNav)
        supportFragmentManager.beginTransaction().add(R.id.fl_fragment, HomeFragment()).commit()
    }

    private val bottomNav = BottomNavigationView.OnNavigationItemSelectedListener {
        var selectFrag: Fragment = HomeFragment()

        when (it.itemId) {
            R.id.item_home -> selectFrag = HomeFragment()
            R.id.item_history -> selectFrag = HistoryFragment()
        }

        supportFragmentManager.beginTransaction().replace(R.id.fl_fragment, selectFrag).commit()

        true
    }
}