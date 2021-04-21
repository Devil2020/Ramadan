package com.morse.ramadan.externsion

import android.animation.Animator
import android.view.View
import android.view.animation.BounceInterpolator

fun View.scaleUpAnimation(animationListner : Animator.AnimatorListener) {
   this?.animate()?.alpha(1f)?.scaleX(1f)?.scaleY(1f)
        ?.setInterpolator(BounceInterpolator())?.setDuration(2500)
        ?.setListener(animationListner)
        ?.start()
}

fun View.translateYwithScaleAnimation(zTransition: Float , scaleValue : Float , listener: Animator.AnimatorListener? = null) {
    this?.animate()?.translationY(zTransition)?.scaleX(scaleValue)?.scaleY(scaleValue)
        ?.setInterpolator(BounceInterpolator())?.setDuration(2500)
        ?.setListener(listener)
        ?.start()
}