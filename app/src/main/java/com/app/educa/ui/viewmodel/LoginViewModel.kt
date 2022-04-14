package com.app.educa.ui.viewmodel

import a2ibi.challenge.app.api.MainRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.educa.model.User
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    lateinit var id: String
    private val userLive: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUser()
        }
    }

    fun getUser(id:String): LiveData<List<User>> {
        this.id = id
        return userLive
    }

    private fun loadUser() {
        viewModelScope.launch {
            var repository = MainRepository()
            repository.getUser(id, object : MainRepository.ResponseListener {
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