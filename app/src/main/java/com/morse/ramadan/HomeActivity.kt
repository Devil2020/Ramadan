package com.morse.ramadan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.morse.ramadan.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    var binding : ActivityHomeBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@HomeActivity
        }
        setContentView(binding?.root)
        binding?.currentDayTv?.setOnClickListener {
            SelectDayBottomSheetDialog().show(supportFragmentManager , SelectDayBottomSheetDialog.TAG )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}