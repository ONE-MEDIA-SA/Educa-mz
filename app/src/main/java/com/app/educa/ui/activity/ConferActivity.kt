package com.app.educa.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.educa.databinding.*
import com.app.educa.ui.adapter.ExhibitorAdapter
import com.app.educa.ui.viewmodel.ConferViewModel

class ConferActivity : AppCompatActivity() {

    lateinit var binding: FragmentConferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentConferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val conferViewModel =
            ViewModelProvider(this).get(ConferViewModel::class.java)

        conferViewModel.exhibitor.observe(this) {
            val adapter = ExhibitorAdapter()
            adapter.submitList(it)
            binding.rvExhibitor.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}
