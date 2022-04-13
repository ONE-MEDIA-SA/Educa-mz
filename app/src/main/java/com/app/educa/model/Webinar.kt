package com.app.educa.model

data class Webinar (
    var uid: String,
    var title: String,
    var description: String,
    var date: String,
    val video_url: String,
    var time: Time
)

data class Time (
    var end: String,
    var start: String,
)
