package com.morse.ramadan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DaysAdapter : RecyclerView.Adapter<DaysAdapter.DayViewHolder>() {

    val listOfDays = arrayListOf<String>(
        "اليوم الأول من رمضان",
        "اليوم الثاني من رمضان",
        "اليوم الثالث من رمضان",
        "اليوم الرابع من رمضان",
        "اليوم الخامس من رمضان",
        "اليوم السادس من رمضان",
        "اليوم السابع من رمضان",
        "اليوم الثامن من رمضان",
        "اليوم التاسع من رمضان",
        "اليوم العاشر من رمضان",
        "اليوم الحادي عشر  من رمضان",
        "اليوم الثاني عشر من رمضان",
        "اليوم الثالث عشر من رمضان",
        "اليوم الرابع عشر من رمضان",
        "اليوم الخامس عشر من رمضان",
        "اليوم السادس عشر من رمضان",
        "اليوم السابع عشر من رمضان",
        "اليوم الثامن عشر من رمضان",
        "اليوم التاسع عشر من رمضان",
        "اليوم العشرين من رمضان",
        "اليوم الواحد و العشرون من رمضان",
        "اليوم الثاني و العشرون من رمضان",
        "اليوم الثالث و العشرون من رمضان",
        "اليوم الرابع و العشرون من رمضان",
        "اليوم الخامس و العشرون من رمضان",
        "اليوم السادس و العشرون من رمضان",
        "اليوم السابع و العشرون من رمضان",
        "اليوم الثامن و العشرون من رمضان",
        "اليوم الخامس و العشرون من رمضان",
        "اليوم الثلاثين من رمضان",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.day_item_layout , parent , false)
        )
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.day_tv.setText(listOfDays.get(position))
    }

    override fun getItemCount(): Int {
        return listOfDays.size
    }

    inner class DayViewHolder(private val container: View) : RecyclerView.ViewHolder(container) {
        val day_tv = container.findViewById<TextView>(R.id.day_tv)
    }

}