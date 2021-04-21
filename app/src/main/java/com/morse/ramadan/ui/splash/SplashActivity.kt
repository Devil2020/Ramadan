package com.morse.ramadan.ui.splash

import android.animation.Animator
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.morse.ramadan.databinding.ActivitySplashBinding
import com.morse.ramadan.externsion.scaleUpAnimation
import com.morse.ramadan.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    var binding: ActivitySplashBinding? = null
    var animationListner = object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator?) {

        }

        override fun onAnimationEnd(animation: Animator?) {
            navigateToHome()
        }

        override fun onAnimationCancel(animation: Animator?) {

        }

        override fun onAnimationRepeat(animation: Animator?) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@SplashActivity
        }
        setContentView(binding?.root)
        binding?.ramadanSplashIv?.scaleUpAnimation(animationListner)
    }

    fun navigateToHome() {
        val options = ActivityOptions
            .makeSceneTransitionAnimation(this, binding?.ramadanSplashIv, "logo")
        startActivity(
            Intent(this, HomeActivity::class.java)
        ,options.toBundle()
        )
        this.finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}