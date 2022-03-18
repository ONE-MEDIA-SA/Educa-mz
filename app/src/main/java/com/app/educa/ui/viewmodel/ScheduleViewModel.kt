package com.app.educa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.educa.model.CombinedResult
import com.app.educa.model.Schedule
import com.app.educa.model.ScheduleUser

class ScheduleViewModel : ViewModel() {

    private var _parentItemArrayList: MutableLiveData<ArrayList<Schedule>> = MutableLiveData()
    private var _childItemArrayList: MutableLiveData<ArrayList<ScheduleUser>> = MutableLiveData()
    var parentItemArrayList: LiveData<ArrayList<Schedule>> = _parentItemArrayList
    var childItemArrayList: LiveData<ArrayList<ScheduleUser>> = _childItemArrayList

    val itemName = arrayOf("Burger", "Manchurian", "Sandwich")
    val img = "https://www.ebony.com/wp-content/uploads/2016/11/Black-Students-Caro-800x500.jpg"
    val imageId = arrayOf(img, img, img, img)

    init {
        getParentItemList()
    }

    private fun getParentItemList() {
        var parentItemList = ArrayList<Schedule>()
        var childItemList = ArrayList<ScheduleUser>()
        for (i in 0..7) {
        val parentItem = Schedule(i, "aaa", "aa","",
            "", "" ,"", "")
            parentItemList.add(parentItem)

        //Child Item Object
        if (i < itemName.size) {
            val childItem = ScheduleUser(
                i,
                imageId[i]
            )
            childItemList.add(childItem)
        }
            _parentItemArrayList.value = parentItemList
            _childItemArrayList.value = childItemList
    }

    }
}