package com.app.educa.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Exhibitor(
    var id: String,
    var name: String = "",
    var email: String = "",
    var description: String = "",
    var contact: Array<String>,
    @SerializedName("avatar")
    var profile: String = "",
    @SerializedName("profile_background")
    var cover: String = "",
    @SerializedName("apresentation_video")
    var video: String = "",
    var website: String = "",
    var likes: List<String> = arrayListOf(),
    var sector: String = "Privado",
    var location: Location,
    var isActive: Boolean = true

) : Serializable

data class Location(
    var long: String = "",
    var lat: String = "",
    var address: String = "Maputo"
) : Serializable


