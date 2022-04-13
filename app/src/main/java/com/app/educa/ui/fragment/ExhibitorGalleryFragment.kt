package com.app.educa.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.educa.R
import com.app.educa.databinding.FragmentExhibitorGalleryBinding
import com.app.educa.model.Exhibitor
import com.app.educa.ui.adapter.GalleryAdapter
import com.app.educa.ui.viewmodel.ConferViewModel
import com.app.educa.ui.viewmodel.GalleryViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExhibitorGalleryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExhibitorGalleryFragment : Fragment(R.layout.fragment_exhibitor_gallery) {

    private var _binding: FragmentExhibitorGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExhibitorGalleryBinding
            .inflate(inflater, container, false)
        val root: View = binding.root

        val galleryViewModel =
            ViewModelProvider(this)[GalleryViewModel::class.java]
        val adapter = GalleryAdapter()

        val exhibitor = requireActivity().intent.getSerializableExtra("exhibitor") as? Exhibitor
        if (exhibitor != null) {
            galleryViewModel.getGallery(exhibitor.id).observe(viewLifecycleOwner) {
                adapter.submitList(it)
                binding.rvGallery.layoutManager =
                    StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
                binding.rvGallery.adapter = adapter
            }
        }


        return root
    }
}