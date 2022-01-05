package com.afrahjadan.elderlycareapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.afrahjadan.elderlycareapp.databinding.FragmentAddMedicineInfoBinding


class AddMedicineInfoFragment : Fragment() {

   private lateinit var binding: FragmentAddMedicineInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_add_medicine_info, container, false)
       binding =FragmentAddMedicineInfoBinding.inflate(layoutInflater)
        binding.SaveToAddBtn.setOnClickListener {
            val action =AddMedicineInfoFragmentDirections.actionAddMedicineInfoFragmentToViewAndAddMedicineFragment()
            findNavController().navigate(action)
        }
        return binding.root


    }

}