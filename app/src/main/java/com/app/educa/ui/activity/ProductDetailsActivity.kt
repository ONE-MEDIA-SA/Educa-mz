package com.app.educa.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.app.educa.R
import com.app.educa.databinding.ActivityProductDetailsBinding
import com.app.educa.ui.adapter.AdapterSlider
import com.app.educa.ui.adapter.ProductAdapter
import com.app.educa.ui.viewmodel.ProductViewModel

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val adap = ProductAdapter()

        productViewModel.getProduct("").observe(this) {
            adap.submitList(it)
            binding.rvProduct.adapter = adap
        }

        //todo update
//
//        binding.pager.adapter = AdapterSlider(it.,this)
//        binding.dotsIndicator.setViewPager(binding.pager)

    }
}