package com.app.educa.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.educa.databinding.ItemExhibitorHorizontalBinding

class MyAdapter : ListAdapter<Int, MyAdapter.ExhibitorViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }

    inner class ExhibitorViewHolder(val binding: ItemExhibitorHorizontalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitorViewHolder {
        return ExhibitorViewHolder(ItemExhibitorHorizontalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ExhibitorViewHolder, position: Int) {
       // holder.binding.root.setBackgroundColor(currentList[position])
    }
}