package com.app.educa.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.educa.R
import com.app.educa.databinding.FragmentScheduleBinding
import com.app.educa.model.CombinedResult
import com.app.educa.model.Schedule
import com.app.educa.model.ScheduleUser
import com.app.educa.ui.adapter.schedule.ScheduleAdapter
import com.app.educa.ui.viewmodel.ScheduleViewModel


class ScheduleFragment : Fragment() {

    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    lateinit var scheduleAdapter: ScheduleAdapter
    lateinit var parentItemArrayList: ArrayList<Schedule>
    lateinit var childItemArrayList: ArrayList<ScheduleUser>
    lateinit var rvSchedule: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       var scheduleViewModel =
            ViewModelProvider(this).get(ScheduleViewModel::class.java)

        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        rvSchedule = binding.rvSchedule

        scheduleViewModel!!.childItemArrayList.observe(viewLifecycleOwner) {
            childItemArrayList = it
        }

        scheduleViewModel!!.parentItemArrayList.observe(viewLifecycleOwner) {
            parentItemArrayList = it
            setRvSchedule()
        }

        return root
    }

    private fun setRvSchedule(){
        scheduleAdapter = ScheduleAdapter(
            requireActivity(),
            parentItemArrayList,
            childItemArrayList
        )
        val layoutManager = LinearLayoutManager(context)
        rvSchedule.layoutManager = layoutManager
        rvSchedule.adapter = scheduleAdapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}