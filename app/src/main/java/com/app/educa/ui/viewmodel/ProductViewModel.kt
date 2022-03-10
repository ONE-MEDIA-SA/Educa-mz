package com.app.educa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.educa.model.Product

class ProductViewModel: ViewModel() {
    private val _products = MutableLiveData<List<Product>>().apply {
        value = getData()
    }
    val products: LiveData<List<Product>> = _products

    private fun getData(): List<Product> {
        var list: MutableList<Product> = mutableListOf()

        for (i in 0..10) {
            list.add(Product(i, "Tênis Adidas Runfalcon 2.0 Masculino", "Categoria $i", 1700.00, "https://images.unsplash.com/photo-1508609349937-5ec4ae374ebf?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb", "Category"))
        }
        return list
    }
}