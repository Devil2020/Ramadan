package com.morse.ramadan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.morse.ramadan.databinding.FragmentSelectDayBottomSheetDialogBinding

class SelectDayBottomSheetDialog : BottomSheetDialogFragment() {

    companion object {
        val TAG = SelectDayBottomSheetDialog.javaClass.name
    }

    var binding : FragmentSelectDayBottomSheetDialogBinding ?=null
    val daysAdapter = DaysAdapter ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}