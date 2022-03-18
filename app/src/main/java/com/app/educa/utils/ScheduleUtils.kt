package com.app.educa.utils

import android.graphics.Color
import com.app.educa.R

class ScheduleUtils {
    @kotlin.jvm.JvmField
    val hsvColors = arrayOf(
        floatArrayOf(11f, 97f, 58f),
        floatArrayOf(145f, 100f, 55f),
        floatArrayOf(41f, 100f, 70f),
        floatArrayOf(247f, 100f, 64f),
        floatArrayOf(30f, 89f, 53f)
    )

    fun lessBrightColor(color: FloatArray): Int {
        return Color.HSVToColor(floatArrayOf(color[0], 0.1f, color[2]))
    }
}