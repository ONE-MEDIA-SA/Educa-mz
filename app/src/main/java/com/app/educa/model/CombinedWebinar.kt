package com.app.educa.model

data class CombinedWebinar(
    var error: Boolean,
    var status: Int,
    var message: String,
    var data: List<Webinar>
)
