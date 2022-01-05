package com.afrahjadan.elderlycareapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afrahjadan.elderlycareapp.appoitmentAdapter.AppAdapter
import com.afrahjadan.elderlycareapp.data.AppointmentItem
import com.afrahjadan.elderlycareapp.databinding.FragmentViewAndAddAppointmentBinding
import com.afrahjadan.elderlycareapp.medicineAdapter.MedAdapter

class ViewAndAddAppointmentFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<AppAdapter.AppViewHolder>? = null

    private lateinit var binding: FragmentViewAndAddAppointmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentViewAndAddAppointmentBinding.inflate(inflater, container, false)
        binding.appAdd.setOnClickListener {
            val action =
                ViewAndAddAppointmentFragmentDirections.actionViewAndAddAppointmentFragmentToAddAppointmentInfoFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appItem = arrayListOf(
            AppointmentItem("02/01/2021", "06:00am", "For BP", "Dallah Hospital"),
            AppointmentItem("02/01/2021", "06:00am", "For BP", "Dallah Hospital"),
            AppointmentItem("02/01/2021", "06:00am", "For BP", "Dallah Hospital"),
            AppointmentItem("02/01/2021", "06:00am", "For BP", "Dallah Hospital")
        )
        binding.recycleApp.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = AppAdapter(appItem)
        }
    }


}