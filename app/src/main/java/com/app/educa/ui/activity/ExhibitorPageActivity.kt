package com.app.educa.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.educa.databinding.ActivityExhibitorPageBinding
import com.app.educa.ui.adapter.ViewPagerAdapter
import com.app.educa.utils.ActionBottom
import com.app.educa.utils.ItemClickListener
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

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = menuArray[position]
        }.attach()

        binding.rounded.setOnClickListener {
            openBottomSheet()
        }

    }

    fun openBottomSheet(){
        val addPhotoBottomDialogFragment = ActionBottom.newInstance()
        addPhotoBottomDialogFragment.show(
            supportFragmentManager,ActionBottom.TAG
        )
    }

    override fun onItemClick(item: String?) {
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show()
    }

}