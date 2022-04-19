package com.app.educa.ui.viewmodel

import a2ibi.challenge.app.api.MainRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.educa.model.Webinar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class WebinarViewModel : ViewModel() {
    private val _webinar = MutableLiveData<List<Webinar>>()

    val webinar: LiveData<List<Webinar>> = _webinar
    init {
        getWebinar()
    }

    private fun getWebinar() {
        viewModelScope.launch {
            var mainRepository = MainRepository()

            mainRepository.getWebinars(object : MainRepository.ResponseListener {
                override fun onSuccess(response: List<Any>) {
                    _webinar.value = response as List<Webinar>
                }

                override fun onFailure(message: String?) {
                    _webinar.value = arrayListOf()
                }

            })
        }
    }

}