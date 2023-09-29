package com.example.travelwithmee.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.travelwithmee.Fragment.FavouriteFragment
import com.example.travelwithmee.Fragment.HomeFragment
import com.example.travelwithmee.Fragment.MapFragment
import com.example.travelwithmee.Fragment.ProfileFragment
import com.example.travelwithmee.R
import com.example.travelwithmee.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        loadfragement(HomeFragment())
        binding.bottamNavigation.setOnItemSelectedListener {


            if (it.itemId == R.id.bottomhome) {
                loadfragement(HomeFragment())
            } else if (it.itemId == R.id.bottomFavorite) {
                loadfragement(FavouriteFragment())
            } else if (it.itemId == R.id.bottomMap) {
                loadfragement(MapFragment())
            } else if (it.itemId == R.id.bottomProfile) {
                loadfragement(ProfileFragment())
            }
            return@setOnItemSelectedListener true
        }

    }

    fun loadfragement(ff: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contener, ff)
        fragmentTransaction.commit()

    }
}