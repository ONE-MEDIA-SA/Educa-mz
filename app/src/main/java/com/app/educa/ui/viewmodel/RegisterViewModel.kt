package com.app.educa.ui.viewmodel

import a2ibi.challenge.app.api.MainRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.educa.model.User
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    lateinit var user: User
    private val userLive: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadProduct()
        }
    }

    fun createUser(user: User): LiveData<List<User>> {
        this.user = user
        return userLive
    }

    private fun loadProduct() {
        viewModelScope.launch {
            var repository = MainRepository()
            repository.setUser(user, object : MainRepository.ResponseListener {
                override fun onSuccess(response: List<Any>) {
                    userLive.postValue(response as List<User>)
                }

                override fun onFailure(message: String?) {
                    userLive.postValue(arrayListOf())
                }

            })

        }


    }
}