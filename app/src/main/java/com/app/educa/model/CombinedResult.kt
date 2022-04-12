package com.app.educa.model

data class CombinedResult(
    var error: Boolean,
    var status: Int,
    var message: String,
    var data: List<Exhibitor>
)
