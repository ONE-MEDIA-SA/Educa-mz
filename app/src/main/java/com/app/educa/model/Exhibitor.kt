package com.app.educa.model

import java.io.Serializable

data class Exhibitor(
    var id: Int,
    var name: String = "",
    var email: String = "",
    var description: String = "",
    var category: String = "",
    var contact: String = "",
    var profile: String = "",
    var cover: String = "",
    var video: String = "",
    var website: String = "",
    var likes: List<String> = arrayListOf(),
    var sector: String = "Privado",
    var location: Location,
    var isActive: Boolean = true

) : Serializable

data class Location(
    var long: Long = 0,
    var lat: Long = 0,
    var address: String = "Maputo"
)

