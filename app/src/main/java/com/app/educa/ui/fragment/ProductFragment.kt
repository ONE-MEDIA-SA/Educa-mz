package com.app.educa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.app.educa.R
import com.app.educa.databinding.FragmentListBinding
import com.app.educa.model.Exhibitor
import com.app.educa.ui.adapter.ProductAdapter
import com.app.educa.ui.viewmodel.ProductViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentListBinding.bind(view)
        val productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val adapter = ProductAdapter()
       // val extra = requireActivity().intent.getStringExtra("exhibitor")
        val exhibitor = requireActivity().intent.getSerializableExtra("exhibitor") as? Exhibitor

        Toast.makeText(requireContext(), exhibitor!!.name, Toast.LENGTH_SHORT).show()

        productViewModel.products.observe(viewLifecycleOwner) {

            adapter.submitList(it)
            binding.rvList.adapter = adapter
        }
        super.onViewCreated(view, savedInstanceState)
    }
}