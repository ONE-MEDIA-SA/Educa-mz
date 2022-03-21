package com.app.educa.model

data class Schedule(
    val id: Int,
    val name: String,
    val description: String,
    val start_date: String,
    val end_date: String,
    val start_time: String,
    val end_time: String,
    val status: String
)
