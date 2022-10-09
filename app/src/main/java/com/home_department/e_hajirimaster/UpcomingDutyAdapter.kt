package com.home_department.e_hajirimaster

import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UpcomingDutyAdapter(val data : List<Duty>) : RecyclerView.Adapter<UpcomingDutyAdapter.MainViewHolder>(){

    inner class MainViewHolder(private val itemView : View): RecyclerView.ViewHolder(itemView){
        fun bindData(duty : Duty){
            val dutyLocation = itemView.findViewById<TextView>(R.id.dutyLocation)
            val dutyDescription = itemView.findViewById<TextView>(R.id.dutyDescription)
            val dutyDate = itemView.findViewById<TextView>(R.id.dutyDate)
            val startTime = itemView.findViewById<TextView>(R.id.startTime)
            val endTime = itemView.findViewById<TextView>(R.id.endTime)

            dutyLocation.text=duty.d_type
            dutyDescription.text=duty.d_info
            dutyDate.text=duty.date
            startTime.text=duty.start_time
            endTime.text=duty.end_time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.upcoming_duties_card,parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


