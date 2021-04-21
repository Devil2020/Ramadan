package com.morse.ramadan.ui.selectday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.morse.ramadan.callback.DayListener
import com.morse.ramadan.databinding.FragmentSelectDayBottomSheetDialogBinding
import com.morse.ramadan.ui.home.HomeActivity

class SelectDayBottomSheetDialog : BottomSheetDialogFragment() , DayListener{

    companion object {
        val TAG = SelectDayBottomSheetDialog.javaClass.name
    }

    var binding : FragmentSelectDayBottomSheetDialogBinding ?=null
    val daysAdapter = DaysAdapter (this)
    val sharedViewModel by  lazy {
        (activity  as HomeActivity).homeViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectDayBottomSheetDialogBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@SelectDayBottomSheetDialog
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.daysRecyclerview?.adapter = daysAdapter
    }

    override fun onDayClciked(day: Int) {
        sharedViewModel.day.postValue(day)
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}