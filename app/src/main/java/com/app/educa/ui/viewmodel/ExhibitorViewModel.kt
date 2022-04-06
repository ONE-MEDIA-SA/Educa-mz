package com.app.educa.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.educa.data.ExhibitorApi
import com.app.educa.model.Exhibitor
import kotlinx.coroutines.launch


enum class ExhibitorApiStatus { LOADING, ERROR, DONE }

class ExhibitorViewModel : ViewModel() {
    private val _status = MutableLiveData<ExhibitorApiStatus>()

    val status: LiveData<ExhibitorApiStatus> = _status

    private val _exhibitors = MutableLiveData<List<Exhibitor>>()

    val exhibitor: LiveData<List<Exhibitor>> = _exhibitors

    init {
        getExhibitors()
    }

    private fun getExhibitors() {
        viewModelScope.launch {
            _status.value = ExhibitorApiStatus.LOADING
            try {
                _exhibitors.value = ExhibitorApi.retrofitService.getExhibitors()
                _status.value = ExhibitorApiStatus.DONE
            } catch (e: Exception) {
                println("ERROR: $e")
                _status.value = ExhibitorApiStatus.ERROR
                _exhibitors.value = listOf()
            }
        }
    }

}