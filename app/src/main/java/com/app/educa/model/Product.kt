package com.app.educa.model

data class Product(
   val id: String,
   val name: String,
   val price: String,
   val quantity: Int,
   val gender: String,
   val description: String,
   val category: String,
   val images: List<String> ){
    fun getFormattedPrice(): String {
        return "${price.toInt()} MZN"
    }
}