package com.app.educa.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.educa.databinding.ItemGalleryBinding
import com.app.educa.model.Exhibitor
import com.bumptech.glide.Glide

class GalleryAdapter : ListAdapter<String, GalleryAdapter.GalleryViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    inner class GalleryViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(ItemGalleryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        Glide
            .with(holder.binding.root)
            .load(currentList[position])
            .into(holder.binding.imgGallery)
    }
}