package com.app.educa.ui.fragment

import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.educa.R
import com.app.educa.databinding.FragmentHomeBinding
import com.app.educa.ui.activity.SearchActivity
import com.app.educa.ui.activity.StudyViewActivity
import com.app.educa.ui.activity.YoutubePlayerActivity
import com.app.educa.ui.viewmodel.HomeViewModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var btnPlay: FloatingActionButton
    private lateinit var llSearchButton: LinearLayout
    private lateinit var chips: ChipGroup

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initViews(root)

        btnPlay.setOnClickListener { startActivity(Intent(activity, YoutubePlayerActivity::class.java)) }
        llSearchButton.setOnClickListener { startActivity(Intent(activity, SearchActivity::class.java)) }
        chips.setOnCheckedChangeListener { group, checkedId ->
            var chip: Chip = group.findViewById(checkedId);
            Intent(activity, SearchActivity::class.java).apply {
                putExtra("category", chip.text)
                startActivity(this)
            }
        }
        homeViewModel.filters.observe(viewLifecycleOwner) {
            chips.removeAllViews()
            it.forEach {
                val chip = Chip(ContextThemeWrapper(
                    context,
                    androidx.navigation.ui.R.style.Widget_MaterialComponents_Chip_Choice))
                chip.text = it.text
                chip.isClickable = true
                chip.isCheckable = true
                chip.isChecked = false
                chips.addView(chip)
            }
        }
        return root
    }

    private fun initViews(root: View) {
        chips = root.findViewById(R.id.group)
        btnPlay  = root.findViewById(R.id.btn_play)
        llSearchButton = root.findViewById(R.id.ll_search_button)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}