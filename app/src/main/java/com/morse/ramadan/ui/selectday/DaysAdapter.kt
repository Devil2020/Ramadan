package com.morse.ramadan.ui.selectday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.morse.ramadan.R
import com.morse.ramadan.callback.DayListener

class DaysAdapter(val listener: DayListener) : RecyclerView.Adapter<DaysAdapter.DayViewHolder>() {

    val listOfDays = arrayListOf(
        Pair(1, "اليوم الأول من رمضان"),
        Pair(2, "اليوم الثاني من رمضان"),
        Pair(3, "اليوم الثالث من رمضان"),
        Pair(4, "اليوم الرابع من رمضان"),
        Pair(5, "اليوم الخامس من رمضان"),
        Pair(6, "اليوم السادس من رمضان"),
        Pair(7, "اليوم السابع من رمضان"),
        Pair(8, "اليوم الثامن من رمضان"),
        Pair(9, "اليوم التاسع من رمضان"),
        Pair(10, "اليوم العاشر من رمضان"),
        Pair(11, "اليوم الحادي عشر  من رمضان"),
        Pair(12, "اليوم الثاني عشر من رمضان"),
        Pair(13, "اليوم الثالث عشر من رمضان"),
        Pair(14, "اليوم الرابع عشر من رمضان"),
        Pair(15, "اليوم الخامس عشر من رمضان"),
        Pair(16, "اليوم السادس عشر من رمضان"),
        Pair(
            17, "اليوم السابع عشر من رمضان"
        ),
        Pair(
            18, "اليوم الثامن عشر من رمضان"
        ),
        Pair(
            19, "اليوم التاسع عشر من رمضان"
        ),
        Pair(
            20, "اليوم العشرين من رمضان"
        ),
        Pair(
            21, "اليوم الواحد و العشرون من رمضان"
        ),
        Pair(
            22, "اليوم الثاني و العشرون من رمضان"
        ),
        Pair(
            23, "اليوم الثالث و العشرون من رمضان"
        ),
        Pair(
            24, "اليوم الرابع و العشرون من رمضان"
        ),
        Pair(
            25, "اليوم الخامس و العشرون من رمضان"
        ),
        Pair(
            26, "اليوم السادس و العشرون من رمضان"
        ),
        Pair(
            27, "اليوم السابع و العشرون من رمضان"
        ),
        Pair(
            28, "اليوم الثامن و العشرون من رمضان"
        ),
        Pair(
            29,
            "اليوم الخامس و العشرون من رمضان"
        ),
        Pair(
            30, "اليوم الثلاثين من رمضان"
        ),
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DayViewHolder {
        return DayViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.day_item_layout,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(
        holder: DayViewHolder,
        position: Int
    ) {
        holder.day_tv.apply {
            setText(
                listOfDays.get(
                    position
                ).second
            )
            setOnClickListener {
                listener.onDayClciked(listOfDays.get(position).first)
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfDays.size
    }

    inner class DayViewHolder(
        private val container: View
    ) : RecyclerView.ViewHolder(container) {
        val day_tv =
            container.findViewById<TextView>(
                R.id.day_tv
            )
    }

}