package com.app.educa.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.educa.databinding.ItemScheduleBinding
import com.app.educa.model.Schedule
import com.app.educa.ui.activity.ExhibitorPageActivity
import com.bumptech.glide.Glide

class ScheduleAdapter : ListAdapter<Schedule, ScheduleAdapter.ExhibitorViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Schedule>() {
        override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
            return oldItem == newItem
        }
    }

    inner class ExhibitorViewHolder(val binding: ItemScheduleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitorViewHolder {
        return ExhibitorViewHolder(ItemScheduleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ExhibitorViewHolder, position: Int) {
//        holder.binding.tvExhibitorName.text = currentList[position].name
//        holder.binding.tvExhibitorCategory.text = currentList[position].category
//
//        Glide
//            .with(holder.binding.root)
//            .load(currentList[position].profile)
//            .into(holder.binding.imgExhibitor)
//
//        holder.binding.root.setOnClickListener{
//            val intent = Intent(holder.binding.root.context, ExhibitorPageActivity::class.java)
//            holder.binding.root.context.startActivity(intent)
//        }
    }
}