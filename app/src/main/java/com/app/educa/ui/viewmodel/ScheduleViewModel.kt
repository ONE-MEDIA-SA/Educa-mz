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
    val img = "https://images.squarespace-cdn.com/content/v1/595fbf906a49632afb7ef282/1516087197336-WGZ54CI3B78XZ1MBIR9P/Amanda-Stenberg-Black-Girls-Rock-Acceptance-Speech.jpg?format=1500w"
    var img2 = "https://s2.glbimg.com/asvTipkvCt7Y9rScJclSGgedKok=/0x0:800x524/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2021/4/M/PAfG50SrKf23eFBDAHMQ/elon-musk-foi-um-dos-ultimos-bilionarios-a-investir-em-criptomoeda.jpg"
    var img3 = "https://www.essence.com/wp-content/uploads/2021/06/GettyImages-1208320328-scaled.jpg?width=600"
    val imageId = arrayOf(img, img2, img3)

    init {
        getParentItemList()
    }

    private fun getParentItemList() {
        var parentItemList = ArrayList<Schedule>()
        var childItemList = ArrayList<ScheduleUser>()
        for (i in 0..7) {
        val parentItem = Schedule(i, "As Tecnologias na Educação", "aa","29 de março de 2022",
            "09:00", "16:00" ,"")
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