package com.app.educa.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.educa.databinding.FragmentScheduleBinding
import com.app.educa.ui.viewmodel.ScheduleViewModel

class ScheduleFragment : Fragment() {

    private var _binding: FragmentScheduleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(ScheduleViewModel::class.java)

        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
           // textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}