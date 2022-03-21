package com.app.educa.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.educa.ui.fragment.FavoriteExhibitorFragment
import com.app.educa.ui.fragment.ProductFragment

private const val NUM_TABS = 2

public class FavoriteViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle):
        FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position){
            0 -> return  ProductFragment()
        }
        return FavoriteExhibitorFragment()
    }

}