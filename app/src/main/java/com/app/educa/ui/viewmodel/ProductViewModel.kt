package com.app.educa.ui.viewmodel

import a2ibi.challenge.app.api.MainRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.educa.model.Product
import kotlinx.coroutines.launch

class ProductViewModel(): ViewModel() {

    lateinit var id: String
    private val product: MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>().also {
            loadProduct()
        }
    }

    fun getProduct(id:String): LiveData<List<Product>> {
        this.id = id
        return product
    }

    private fun loadProduct() {
        viewModelScope.launch {
            var repository = MainRepository()
            repository.getProducts(id, object : MainRepository.ResponseListener {
                override fun onSuccess(response: List<Any>) {
                    product.postValue(response as List<Product>)
                }

                override fun onFailure(message: String?) {
                    product.postValue(arrayListOf())
                }

            })

        }

    }












//
//
//    private val _products = MutableLiveData<List<Product>>()
//    val products: LiveData<List<Product>> = _products
//
//
//    init {
//        getProducts(productId)
//    }
//    private fun getProducts(productId: String) {
//        viewModelScope.launch {
//            var repository = MainRepository()
//            repository.getProducts(productId, object : MainRepository.ResponseListener {
//                override fun onSuccess(response: List<Any>) {
//                   _products.postValue(response as List<Product>)
//                }
//
//                override fun onFailure(message: String?) {
//                    _products.postValue(arrayListOf())
//                }
//
//            })
//
//        }
//    }


}