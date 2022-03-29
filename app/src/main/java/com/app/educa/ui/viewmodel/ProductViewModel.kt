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

        list.add(Product(1, "Tênis Adidas Runfalcon 2.0 ", "Categoria ", 1700.00, "https://artwalk.vteximg.com.br/arquivos/ids/235415-600-600/Tenis-adidas-ZX-2K-Boost-Pure-Masculino-Azul.jpg?v=637617134494730000", "Sapatos"))
        list.add(Product(1, "Tênis nike air force 1'07 le", "Categoria ", 900.00, "https://artwalk.vteximg.com.br/arquivos/ids/229172-600-600/Tenis-Nike-Air-Force-1-07-Le-Masculino-Branco.jpg?v=637438982802100000", "Sapatos"))
        list.add(Product(1, "Tênis Adidas Runfalcon 2.0 Masculino", "Categoria ", 1700.00, "https://images.unsplash.com/photo-1508609349937-5ec4ae374ebf?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb", "Category"))
        list.add(Product(1, "Tênis adidas zx 5k boost ", "Categoria ", 1700.00, "https://artwalk.vteximg.com.br/arquivos/ids/242368-600-600/Tenis-adidas-ZX-5K-Boost-Masculino-Verde.jpg?v=637799205331300000", "Sapatos"))
        list.add(Product(1, "Tênis Adidas Runfalcon 2.0 Masculino", "Categoria ", 1700.00, "https://images.unsplash.com/photo-1508609349937-5ec4ae374ebf?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb", "Category"))
        list.add(Product(1, "Tênis Adidas Runfalcon 2.0 Masculino", "Categoria ", 1700.00, "https://images.unsplash.com/photo-1508609349937-5ec4ae374ebf?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb", "Category"))


        return list
    }
}