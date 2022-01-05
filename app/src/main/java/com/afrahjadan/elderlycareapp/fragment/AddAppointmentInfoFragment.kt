package com.afrahjadan.elderlycareapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.afrahjadan.elderlycareapp.databinding.FragmentAddAppointmentInfoBinding

class AddAppointmentInfoFragment : Fragment() {

    private lateinit var binding: FragmentAddAppointmentInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddAppointmentInfoBinding.inflate(inflater, container, false)
        binding.SaveToAddBtnApp.setOnClickListener {
            val action =
                AddAppointmentInfoFragmentDirections.actionAddAppointmentInfoFragmentToViewAndAddAppointmentFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

}