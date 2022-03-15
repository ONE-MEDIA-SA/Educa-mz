package com.app.educa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.educa.R
import com.app.educa.databinding.FragmentListBinding
import com.app.educa.ui.adapter.ExhibitorAdapter
import com.app.educa.ui.adapter.ProductAdapter
import com.app.educa.ui.viewmodel.ConferViewModel
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
class FavoriteExhibitorFragment : Fragment(R.layout.fragment_list) {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentListBinding.bind(view)
        val productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val adapter = ProductAdapter()

        val conferViewModel =
            ViewModelProvider(this).get(ConferViewModel::class.java)

        conferViewModel.exhibitor.observe(viewLifecycleOwner) {
            val adapter = ExhibitorAdapter()
            adapter.submitList(it)
            binding.rvList.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(context)
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }
}