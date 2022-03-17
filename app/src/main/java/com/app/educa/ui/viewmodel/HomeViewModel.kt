package com.app.educa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.educa.model.FilterItem

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private var _filters = MutableLiveData<ArrayList<FilterItem>>().apply {
        value = arrayListOf(
            FilterItem("Matemática"),
            FilterItem("Português"),
            FilterItem("História"),
            FilterItem("Geografia"),
            FilterItem("Química"),
            FilterItem("Física"),
            FilterItem("Biologia"),
            FilterItem("Filosofia"),
            FilterItem("Sociologia"),
            FilterItem("Artes"),
            FilterItem("Educação Física"),
            FilterItem("Inglês"),
            FilterItem("Francês"),
            FilterItem("Sociologia"),
            FilterItem("Artes"),
            FilterItem("Educação Física"),
        )
    }
    val filters: LiveData<ArrayList<FilterItem>> = _filters
}