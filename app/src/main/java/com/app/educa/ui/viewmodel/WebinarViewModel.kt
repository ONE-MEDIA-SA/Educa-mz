package com.app.educa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WebinarViewModel : ViewModel() {
    private val _webinar = MutableLiveData<List<String>>().apply {
        value = arrayListOf(
            "https://media.istockphoto.com/photos/businessman-picture-id1251246829?k=20&m=1251246829&s=612x612&w=0&h=10TjD684NJ9_ApsOopdhg5O1AFyjcC7D7epAtxKVR6U=",
            "https://media.istockphoto.com/photos/education-picture-id1166847872?k=20&m=1166847872&s=612x612&w=0&h=leRrFrOIjznLzDT37dKRbW8kHsYkxYU5LaqjRxpCBxI=",
            "https://media.istockphoto.com/photos/education-picture-id1166847872?k=20&m=1166847872&s=612x612&w=0&h=leRrFrOIjznLzDT37dKRbW8kHsYkxYU5LaqjRxpCBxI=",
            "https://media.istockphoto.com/photos/education-picture-id1166847872?k=20&m=1166847872&s=612x612&w=0&h=leRrFrOIjznLzDT37dKRbW8kHsYkxYU5LaqjRxpCBxI="
        )
    }

    val webinar: LiveData<List<String>> = _webinar

}