package com.app.educa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.educa.model.Product

class ProductViewModel: ViewModel() {
    private val _products = MutableLiveData<List<Product>>().apply {
        for (i in 0..10) {
            value = listOf(
                Product(
                    1,
                    "Product 1",
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F624790873524098983%2F&psig=AOvVaw2X_Z-_X-_q-_X-_Q-_X-_&ust=1589788240870000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLjq-x-_e-kCFQAAAAAdAAAAABAD",
                    2600.0,
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F624790873524098983%2F&psig=AOvVaw2X_Z-_X-_q-_X-_Q-_X-_&ust=1589788240870000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLjq-x-_e-kCFQAAAAAdAAAAABAD",
                    "Sapatos"
                )
            )
        }
    }
    val products: LiveData<List<Product>> = _products
}