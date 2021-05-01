package com.morse.ramadan.ui.home

import android.animation.Animator
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.morse.ramadan.R
import com.morse.ramadan.core.MediaManager
import com.morse.ramadan.databinding.ActivityHomeBinding
import com.morse.ramadan.externsion.floatValueAnimation
import com.morse.ramadan.externsion.getRamadanDaysArrayList
import com.morse.ramadan.externsion.setUpWaveShape
import com.morse.ramadan.externsion.translateYwithScaleAnimation
import com.morse.ramadan.ui.selectday.SelectDayBottomSheetDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import rm.com.audiowave.OnProgressListener

class HomeActivity : AppCompatActivity() {

    var mediaManager = MediaManager(this)
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
        setupListeners()
    }

    fun setupListeners() {
        binding?.playBt?.setOnClickListener {
            if (mediaManager.isPlaying()) {
                mediaManager.pause()
                binding?.playBt?.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                mediaManager?.removeUpdateValueListener()
            } else {
                mediaManager.play()
                binding?.playBt?.setImageResource(R.drawable.ic_group_96)
                mediaManager?.listenToUpdateValueListener().receiveAsFlow().onEach {
                    binding?.wave?.progress =
                        mediaManager.getMediaPlayerObject().currentPosition.toFloat()
                    binding?.startTv?.text =
                        mediaManager.getMediaPlayerObject().currentPosition.toString()
                }
            }
        }
        binding?.nextBt?.setOnClickListener {
            if(ramadanDayPosition < 30) {
                ramadanDayPosition = ramadanDayPosition + 1
                val day = listOfRamadanDays.get(ramadanDayPosition)
                binding?.endTv?.floatValueAnimation(day.dayAudioLength.toFloat())
                binding?.wave?.setRawData(setUpWaveShape(day.dayAudio))
                binding?.prayerQuoteTv?.setText(getString(R.string.quote_lable, day.dayPrayer))
                binding?.currentDayTv?.setText(getString(R.string.current_day, day.dayNumberAr))
                val file = assets.openFd(day.dayAudio)
                mediaManager.setFile(file.fileDescriptor)
            }
        }
        binding?.previousBt?.setOnClickListener {
            if (ramadanDayPosition >= 1) {
                ramadanDayPosition = ramadanDayPosition - 1
                val day = listOfRamadanDays.get(ramadanDayPosition)
                binding?.endTv?.floatValueAnimation(day.dayAudioLength.toFloat())
                binding?.wave?.setRawData(setUpWaveShape(day.dayAudio))
                binding?.prayerQuoteTv?.setText(getString(R.string.quote_lable, day.dayPrayer))
                binding?.currentDayTv?.setText(getString(R.string.current_day, day.dayNumberAr))
                val file = assets.openFd(day.dayAudio)
                mediaManager.setFile(file.fileDescriptor)
            }
        }
        binding?.wave?.progress = mediaManager.getMediaPlayerObject().currentPosition.toFloat()
    }

    fun setupViewModel() {
        homeViewModel.day?.observe(this) {
            ramadanDayPosition = it
            changeDayUi(ramadanDayPosition)
        }
    }

    fun setupWave() {
        //mediaManager.getMediaPlayerObject().
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
        val file = assets.openFd(day.dayAudio)
        mediaManager.setFile(file.fileDescriptor)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}