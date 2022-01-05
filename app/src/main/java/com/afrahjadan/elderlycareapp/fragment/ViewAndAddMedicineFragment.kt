package com.afrahjadan.elderlycareapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afrahjadan.elderlycareapp.R
import com.afrahjadan.elderlycareapp.data.MedicineItem
import com.afrahjadan.elderlycareapp.databinding.FragmentViewAndAddMedicineBinding
import com.afrahjadan.elderlycareapp.medicineAdapter.MedAdapter

class ViewAndAddMedicineFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MedAdapter.MedViewHolder>? = null


    private lateinit var binding: FragmentViewAndAddMedicineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//    return inflater.inflate(R.layout.med_item_list, container, false)
        binding = FragmentViewAndAddMedicineBinding.inflate(inflater, container, false)
        binding.medAdd.setOnClickListener {
            val action =
                ViewAndAddMedicineFragmentDirections.actionViewAndAddMedicineFragmentToAddMedicineInfoFragment()
            findNavController().navigate(action)
        }
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycleMed.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MedAdapter(mutableListOf())
        }

    }

}