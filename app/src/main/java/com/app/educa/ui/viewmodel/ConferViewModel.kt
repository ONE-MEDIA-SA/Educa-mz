package com.app.educa.ui.viewmodel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConferViewModel : ViewModel() {

    private val _exhibitor = MutableLiveData<Int>().apply {
        listOf(
            Color.BLUE,
            Color.RED,
            Color.YELLOW,
            Color.GREEN,
            Color.CYAN,
            Color.MAGENTA,
            Color.DKGRAY
        )
    }
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
    val exhibitor: LiveData<Int> = _exhibitor
}