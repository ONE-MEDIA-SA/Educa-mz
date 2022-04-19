package com.app.educa.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.educa.databinding.*
import com.app.educa.ui.adapter.ExhibitorAdapter
import com.app.educa.ui.viewmodel.ConferViewModel
import com.app.educa.ui.viewmodel.ExhibitorViewModel

class ConferActivity : AppCompatActivity() {

    lateinit var binding: ActivityConferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "Feira"
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val conferViewModel =
            ViewModelProvider(this).get(ConferViewModel::class.java)

        conferViewModel.exhibitor.observe(this) {

        }


        val exhibitorViewModel =
            ViewModelProvider(this).get(ExhibitorViewModel::class.java)

        exhibitorViewModel.exhibitor.observe(this) {
            val adapter = ExhibitorAdapter()
            adapter.submitList(it)
            binding.rvExhibitor.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(context)
            }
        }

    }
}
