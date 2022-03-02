package com.app.educa.ui.viewmodel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.educa.model.Exhibitor

class ConferViewModel : ViewModel() {

    private val _exhibitor = MutableLiveData<List<Exhibitor>>().apply {
        value = listOf(
            Exhibitor("Twitch LLC", "Tecnologia" ,"https://purepng.com/public/uploads/large/twitch-prime-logo-high-resolution-hpc.png"),
            Exhibitor("Instituto de Tecnologia de Massachusetts", "Educação" ,"https://logoeps.com/wp-content/uploads/2012/12/bank-of-hawaii-logo-vector-200x200.png"),
            Exhibitor("Google LLC", "Tecnologia" ,"https://logoeps.com/wp-content/uploads/2012/12/apple-classic-logo-vector-200x200.png"),
            Exhibitor("Microsoft Corporation", "Tecnologia" ,"https://logoeps.com/wp-content/uploads/2012/12/bank-of-hawaii-logo-vector-200x200.png"),
            Exhibitor("Instituto de Tecnologia de Massachusetts", "Educação" ,"https://logoeps.com/wp-content/uploads/2012/12/bank-of-hawaii-logo-vector-200x200.png"),
        )
    }
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
    val exhibitor: LiveData<List<Exhibitor>> = _exhibitor
}