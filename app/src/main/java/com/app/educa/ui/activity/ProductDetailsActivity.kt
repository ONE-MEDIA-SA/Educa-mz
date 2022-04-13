package com.app.educa.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.app.educa.R
import com.app.educa.databinding.ActivityProductDetailsBinding
import com.app.educa.model.Exhibitor
import com.app.educa.model.Product
import com.app.educa.ui.adapter.AdapterSlider
import com.app.educa.ui.adapter.ProductAdapter
import com.app.educa.ui.viewmodel.ProductViewModel

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("product") as? Product

        val productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val adap = ProductAdapter()

        productViewModel.getProduct(product!!.exhibitor_id).observe(this) {
            adap.submitList(it)
            binding.rvProduct.adapter = adap
        }

        binding.pager.adapter = AdapterSlider(product.images,this)
        binding.dotsIndicator.setViewPager(binding.pager)

        updateUI(product)

    }

    private fun updateUI(product: Product) {
        binding.tvProductName.text = product.name
        binding.tvProductQuantity.text = "Quantidade: ${product.quantity}"
        binding.tvProductDescription.text = product.description
        binding.tvProductPrice.text = product.getFormattedPrice()
    }
}