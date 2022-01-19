package com.afrahjadan.elderlycareapp.appoitmentAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.afrahjadan.elderlycareapp.R
import com.afrahjadan.elderlycareapp.data.AppointmentItem
import com.afrahjadan.elderlycareapp.fragment.ViewAppointmentFragmentDirections
import com.google.firebase.firestore.*
import java.text.SimpleDateFormat
import java.util.*

class AppAdapter(private val appList: MutableList<AppointmentItem?>) :
    RecyclerView.Adapter<AppAdapter.AppViewHolder>() {
    private lateinit var id: String
    private val db = FirebaseFirestore.getInstance()

    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val appTime: TextView = itemView.findViewById(R.id.timeAppTv)
        val appDate: TextView = itemView.findViewById(R.id.dateAppTv)
        val appRes: TextView = itemView.findViewById(R.id.appResTv)
        val hosName: TextView = itemView.findViewById(R.id.hosNameTv)
        val appEdit: ImageButton = itemView.findViewById(R.id.editApp)
        val appDelete: ImageButton = itemView.findViewById(R.id.deleteApp)
        val cardMed: CardView = itemView.findViewById(R.id.app_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val appAdapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.app_item_list, parent, false)
        return AppViewHolder(appAdapterLayout)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val appItem = appList[position]
        id = appItem!!.id
        holder.appTime.text = appItem?.appointmentTime
        holder.appDate.text = appItem?.appointmentDate
        holder.appRes.text = appItem?.appointmentReason
        holder.hosName.text = appItem?.hospitalName

//isPassed(appItem?.appointmentDate!!).toString()
        if (isPassed(appItem?.appointmentDate!!)) {

            holder.cardMed.setBackgroundColor(R.color.baby_blue)
        }
//else{
//    holder.cardMed.setBackgroundColor(R.color.purple_200)
//}
        holder.appEdit.setOnClickListener {
            val action =
                ViewAppointmentFragmentDirections.actionViewAppointmentFragmentToEditAppointmentFragment(
                    appItem!!.id
                )
            holder.itemView.findNavController()
                .navigate(action)
        }
        holder.appDelete.setOnClickListener {
            deleteApp()
        }
    }

    override fun getItemCount(): Int {
        return appList.size
    }

    private fun deleteApp() {
        db.collection("Appointment").document(id).delete()

    }

    private fun isPassed(medDate: String): Boolean {
        val dateMedPass = SimpleDateFormat("dd/MM/yyyy", Locale.US).parse(medDate)
        return dateMedPass.before(Date())
    }
}


