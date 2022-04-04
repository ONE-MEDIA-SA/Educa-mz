package com.app.educa.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.educa.databinding.ItemWebinarBinding
import com.app.educa.model.Exhibitor
import com.app.educa.ui.activity.ExhibitorPageActivity
import com.app.educa.ui.activity.YoutubePlayerActivity
import com.bumptech.glide.Glide

class WebinarAdapter : ListAdapter<String, WebinarAdapter.GalleryViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    inner class GalleryViewHolder(val binding: ItemWebinarBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder(ItemWebinarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        Glide
            .with(holder.binding.root)
            .load(currentList[position])
            .into(holder.binding.imgCover)

        holder.binding.btnPlay.setOnClickListener {
            val intent = Intent(holder.binding.root.context, YoutubePlayerActivity::class.java)
            intent.putExtra("url", currentList[position])
            holder.binding.root.context.startActivity(intent)
        }
    }
}