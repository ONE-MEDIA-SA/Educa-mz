package com.app.educa.model

import java.io.Serializable

data class Exhibitor(
    var id: Int,
    var name: String,
    var category: String,
    var profile: String) : Serializable