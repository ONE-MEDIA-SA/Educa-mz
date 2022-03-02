package com.app.educa.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.educa.databinding.FragmentGalleryBinding
import com.app.educa.databinding.FragmentHomeBinding
import com.app.educa.ui.adapter.ExhibitorAdapter
import com.app.educa.ui.adapter.GalleryAdapter
import com.app.educa.ui.viewmodel.GalleryViewModel
import com.app.educa.ui.viewmodel.HomeViewModel

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        galleryViewModel.images.observe(viewLifecycleOwner) {
            val adapter = GalleryAdapter()
            adapter.submitList(it)
            binding.rvGallery.apply {
                this.adapter = adapter
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}