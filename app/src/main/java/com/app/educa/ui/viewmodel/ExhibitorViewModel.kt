package com.app.educa.ui.viewmodel

import a2ibi.challenge.app.api.MainRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.educa.data.ExhibitorApi
import com.app.educa.model.Exhibitor
import kotlinx.coroutines.launch


class ExhibitorViewModel : ViewModel() {
    private val _exhibitors = MutableLiveData<List<Exhibitor>>()
    val exhibitor: LiveData<List<Exhibitor>> = _exhibitors

    init {
        getExhibitors()
    }

    private fun getExhibitors() {
        viewModelScope.launch {

            try {
                var repository = MainRepository()
                repository.getAllExhibitors(object : MainRepository.ResponseListener {
                    override fun onSuccess(response: List<Exhibitor>) {
                        _exhibitors.postValue(response)
                    }

                    override fun onFailure(message: String?) {
                        _exhibitors.postValue(arrayListOf())
                    }

                })
            } catch (e: Exception) {
                println("ERROR: $e")
                _exhibitors.value = listOf()
            }
        }
    }

}