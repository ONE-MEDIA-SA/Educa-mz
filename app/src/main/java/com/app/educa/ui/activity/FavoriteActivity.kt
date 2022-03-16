package com.app.educa.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.educa.R

import com.app.educa.databinding.*
import com.app.educa.ui.adapter.FavoriteViewPager
import com.app.educa.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

val menu = arrayOf(
    "Produtos",
    "Expositores"
)

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = FavoriteViewPager(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = menu[position]
        }.attach()

    }
}