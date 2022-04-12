package com.app.educa.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.educa.databinding.ActivityExhibitorPageBinding
import com.app.educa.model.Exhibitor
import com.app.educa.ui.adapter.ViewPagerAdapter
import com.app.educa.utils.ActionBottom
import com.app.educa.utils.ItemClickListener
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator

val menuArray = arrayOf(
    "Produtos",
    "Galeria",
    "Sobre"
)


class ExhibitorPageActivity : AppCompatActivity(),ItemClickListener {
    lateinit var binding: ActivityExhibitorPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExhibitorPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exhibitor = intent.getSerializableExtra("exhibitor") as? Exhibitor

        if (exhibitor != null) {
            updateUi(exhibitor)
        }

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this, YoutubePlayerActivity::class.java)
            startActivity(intent)
        }
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = menuArray[position]
        }.attach()

    }

    private fun updateUi(exhibitor: Exhibitor) {
        binding.tvExhibitorName.text = exhibitor.name
        binding.tvExhibitorCategory.text = exhibitor.sector
        Glide
            .with(this)
            .load(exhibitor.profile)
            .into(binding.ivExhibitorLogo)
    }

    override fun onItemClick(item: String?) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }

}