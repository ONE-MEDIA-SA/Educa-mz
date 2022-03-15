package com.app.educa.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.app.educa.databinding.*
import com.app.educa.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

val menu = arrayOf(
    "Produtos",
    "Expositores",
    "Expositores",
)

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = menu[position]
        }.attach()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}