package com.app.educa.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.educa.R
import com.app.educa.databinding.ActivityGalleryBinding
import com.app.educa.ui.adapter.GalleryAdapter
import com.app.educa.ui.adapter.ProductAdapter
import com.app.educa.ui.adapter.WebinarAdapter
import com.app.educa.ui.viewmodel.GalleryViewModel
import com.app.educa.ui.viewmodel.ProductViewModel
import com.app.educa.ui.viewmodel.WebinarViewModel

class WebinarActivity  : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    lateinit var binding: ActivityGalleryBinding

    private val viewModel: ProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "Webinars"
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val galleryViewModel = ViewModelProvider(this).get(WebinarViewModel::class.java)
        val adapter = WebinarAdapter()

        galleryViewModel.webinar.observe(this) {

            adapter.submitList(it)
            binding.rvGallery.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
            binding.rvGallery.adapter = adapter
        }

    }

}