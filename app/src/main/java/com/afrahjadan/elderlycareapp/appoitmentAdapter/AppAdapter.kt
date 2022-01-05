package com.afrahjadan.elderlycareapp.appoitmentAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afrahjadan.elderlycareapp.R
import com.afrahjadan.elderlycareapp.data.AppointmentItem

class AppAdapter(private val appList:ArrayList<AppointmentItem>):RecyclerView.Adapter<AppAdapter.AppViewHolder>() {


    class AppViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val appTime:TextView = itemView.findViewById(R.id.timeAppTv)
        val appDate:TextView = itemView.findViewById(R.id.dateAppTv)
        val appRes:TextView = itemView.findViewById(R.id.appResTv)
        val hosName:TextView = itemView.findViewById(R.id.hosNameTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val appAdapterLayout =LayoutInflater.from(parent.context).inflate(R.layout.app_item_list, parent, false)
        return AppViewHolder(appAdapterLayout)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val appItem = appList[position]
        holder.appTime.text = appItem.appointmentTime
        holder.appDate.text = appItem.appointmentDate
        holder.appRes.text = appItem.appointmentReason
        holder.hosName.text = appItem.hospitalName
    }

    override fun getItemCount(): Int {
        return appList.size
    }
}