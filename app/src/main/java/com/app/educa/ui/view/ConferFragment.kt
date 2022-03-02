package com.app.educa.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.educa.databinding.*
import com.app.educa.ui.adapter.ExhibitorAdapter
import com.app.educa.ui.viewmodel.ConferViewModel

class ConferFragment : Fragment() {

    private var _binding: FragmentConferBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val conferViewModel =
            ViewModelProvider(this).get(ConferViewModel::class.java)

        _binding = FragmentConferBinding.inflate(inflater, container, false)
        val root: View = binding.root


        conferViewModel.exhibitor.observe(viewLifecycleOwner) {
            val adapter = ExhibitorAdapter()
            adapter.submitList(it)
            binding.rvExhibitor.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(context)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}