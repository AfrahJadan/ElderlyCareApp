package com.afrahjadan.elderlycareapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.afrahjadan.elderlycareapp.R
import com.afrahjadan.elderlycareapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.btnMed.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToViewAndAddMedicineFragment()
            findNavController().navigate(action)
        }
        binding.btnApp.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragment2ToViewAndAddAppointmentFragment()
            findNavController().navigate(action)
        }
        return binding.root


    }


}