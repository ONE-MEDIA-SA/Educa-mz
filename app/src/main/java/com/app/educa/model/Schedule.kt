package com.app.educa.model

data class Schedule(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val start_time: String,
    val end_time: String,
    val status: String
)
