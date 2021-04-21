package com.morse.ramadan.ui.home

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.morse.ramadan.R
import com.morse.ramadan.databinding.ActivityHomeBinding
import com.morse.ramadan.externsion.floatValueAnimation
import com.morse.ramadan.externsion.getRamadanDaysArrayList
import com.morse.ramadan.externsion.setUpWaveShape
import com.morse.ramadan.externsion.translateYwithScaleAnimation
import com.morse.ramadan.ui.selectday.SelectDayBottomSheetDialog
import rm.com.audiowave.OnProgressListener

class HomeActivity : AppCompatActivity() {

    var binding: ActivityHomeBinding? = null
    var listener = object : Animator.AnimatorListener {

        override fun onAnimationStart(animation: Animator?) {

        }

        override fun onAnimationEnd(animation: Animator?) {
            binding?.prayerIv?.translateYwithScaleAnimation(20f, 1f)
        }

        override fun onAnimationCancel(animation: Animator?) {

        }

        override fun onAnimationRepeat(animation: Animator?) {

        }
    }
    val listOfRamadanDays by lazy {
        getRamadanDaysArrayList()
    }
    var ramadanDayPosition = 1
    val homeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@HomeActivity
        }
        binding?.prayerIv?.translateYwithScaleAnimation(-20f, 0.9f, listener)
        setContentView(binding?.root)
        binding?.currentDayTv?.setOnClickListener {
            SelectDayBottomSheetDialog().show(
                supportFragmentManager,
                SelectDayBottomSheetDialog.TAG
            )
        }
        setupViewModel()
        setupWave()
        changeDayUi(ramadanDayPosition)
    }

    fun setupViewModel() {
        homeViewModel.day?.observe(this) {
            ramadanDayPosition = it
            changeDayUi(ramadanDayPosition)
        }
    }

    fun setupWave() {
        binding?.wave?.onProgressListener = object : OnProgressListener {
            override fun onProgressChanged(progress: Float, byUser: Boolean) {
                // invokes every time the progress's been changed
            }

            override fun onStartTracking(progress: Float) {
                // invokes when user touches the view
            }

            override fun onStopTracking(progress: Float) {
                // invokes when user releases the touch

            }
        }
    }

    fun changeDayUi(position: Int) {
        val day = listOfRamadanDays.get(position - 1)
        binding?.endTv?.floatValueAnimation(day.dayAudioLength.toFloat())
        binding?.wave?.setRawData(setUpWaveShape(day.dayAudio))
        binding?.prayerQuoteTv?.setText(getString(R.string.quote_lable, day.dayPrayer))
        binding?.currentDayTv?.setText(getString(R.string.current_day, day.dayNumberAr))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}