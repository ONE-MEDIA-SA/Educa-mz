package com.app.educa.utils

import com.app.educa.R

class ScheduleUtils {
    fun randomColor(){
        val colors = arrayOf(R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorAccent)
        val random = (0..2).random()
        return colors[random]
    }
}