package com.app.educa.model

import java.io.Serializable

data class Product(
   val id: String,
   val name: String,
   val price: String,
   val quantity: Int,
   val gender: String,
   val description: String,
   val category: String,
   var exhibitor_id: String,
   val images: List<String> = arrayListOf()
) : Serializable {
    fun getFormattedPrice(): String {
        return "${price.toInt()} MZN"
    }
}