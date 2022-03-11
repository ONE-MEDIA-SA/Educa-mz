package com.app.educa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _images = MutableLiveData<List<String>>().apply {
        value = listOf(
            "https://www.nvidia.com/content/dam/en-zz/Solutions/geforce/geforce-rtx-turing/store/geforce-gtx-16-series-laptops-462-d.jpg",
            "https://atlantablackstar.com/wp-content/uploads/2015/07/college-students-studying2_0.jpg",
            "https://www.ebony.com/wp-content/uploads/2016/11/Black-Students-Caro-800x500.jpg",
            "https://atlantablackstar.com/wp-content/uploads/2015/07/college-students-studying2_0.jpg",
            "https://www.ebony.com/wp-content/uploads/2016/11/Black-Students-Caro-800x500.jpg",
            "https://www.nvidia.com/content/dam/en-zz/Solutions/geforce/geforce-rtx-turing/store/geforce-gtx-16-series-laptops-462-d.jpg",
            "https://atlantablackstar.com/wp-content/uploads/2015/07/college-students-studying2_0.jpg",
            "https://www.ebony.com/wp-content/uploads/2016/11/Black-Students-Caro-800x500.jpg",
            "https://www.nvidia.com/content/dam/en-zz/Solutions/geforce/geforce-rtx-turing/store/geforce-gtx-16-series-laptops-462-d.jpg",
            "https://atlantablackstar.com/wp-content/uploads/2015/07/college-students-studying2_0.jpg",
            "https://www.ebony.com/wp-content/uploads/2016/11/Black-Students-Caro-800x500.jpg",
            "https://atlantablackstar.com/wp-content/uploads/2015/07/college-students-studying2_0.jpg",
        )
    }

    val images: LiveData<List<String>> = _images

}