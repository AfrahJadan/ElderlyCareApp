package com.afrahjadan.elderlycareapp.medicineAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.afrahjadan.elderlycareapp.R
import com.afrahjadan.elderlycareapp.data.MedicineItem

class MedAdapter(private val medList:List<MedicineItem>):RecyclerView.Adapter<MedAdapter.MedViewHolder>() {

    class MedViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
       val medShow:TextView =itemView.findViewById(R.id.medShow)
        val dosMed:TextView =itemView.findViewById(R.id.dozMed)
        val medTime:TextView =itemView.findViewById(R.id.timeMed)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedViewHolder {
       val medAdapterLayout =LayoutInflater.from(parent.context).inflate(R.layout.med_item_list,
           parent , false)
        return MedViewHolder(medAdapterLayout)
    }

    override fun onBindViewHolder(holder: MedViewHolder, position: Int) {
       val medItem =medList[position]
        holder.medShow.text=medItem.medType
        holder.dosMed.text =medItem.Dose.toString()
        holder.medTime.text = medItem.medTime

    }

    override fun getItemCount(): Int {
        return medList.size
    }
}