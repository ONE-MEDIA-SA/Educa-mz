package com.app.educa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.app.educa.R
import com.app.educa.databinding.FragmentGalleryBinding
import com.app.educa.databinding.FragmentProductBinding
import com.app.educa.ui.adapter.GalleryAdapter
import com.app.educa.ui.adapter.ProductAdapter
import com.app.educa.ui.viewmodel.GalleryViewModel
import com.app.educa.ui.viewmodel.ProductViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment(R.layout.fragment_product) {
    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentProductBinding.bind(view)
        val productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val adapter = ProductAdapter()

        productViewModel.products.observe(viewLifecycleOwner) {

            adapter.submitList(it)
            binding.rvProducts.adapter = adapter
        }
        super.onViewCreated(view, savedInstanceState)
    }
}