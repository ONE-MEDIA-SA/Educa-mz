package com.app.educa.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String){
    fun getFormattedPrice(): String {
        return "${price.toInt()} MZN"
    }
}