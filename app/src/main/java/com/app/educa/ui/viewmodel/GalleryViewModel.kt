package com.app.educa.ui.viewmodel

import a2ibi.challenge.app.api.MainRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.educa.model.Gallery
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {

    lateinit var id: String
    private val gallery: MutableLiveData<List<Gallery>> by lazy {
        MutableLiveData<List<Gallery>>().also {
            loadGallery()
        }
    }

    fun getGallery(id:String): LiveData<List<Gallery>> {
        this.id = id
        return gallery
    }

    private fun loadGallery() {
        viewModelScope.launch {
            var repository = MainRepository()
            repository.getGallery(id, object : MainRepository.ResponseListener {
                override fun onSuccess(response: List<Any>) {
                    gallery.postValue(response as List<Gallery>)
                }
                override fun onFailure(message: String?) {
                    gallery.postValue(arrayListOf())
                }

            })

        }
    }

}