package com.app.educa.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.educa.databinding.ItemProductHBinding
import com.app.educa.model.Product
import com.bumptech.glide.Glide

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    inner class ProductViewHolder(val binding: ItemProductHBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(ItemProductHBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Glide
            .with(holder.binding.root)
            .load(currentList[position].image)
            .into(holder.binding.imageProduct)

        holder.binding.tvProductName.text = currentList[position].name
        holder.binding.tvProductPrice.text = currentList[position].getFormattedPrice()
        holder.binding.root.setOnClickListener {
            Toast.makeText(holder.binding.root.context, "Clicked", Toast.LENGTH_SHORT).show()
        }

    }
}