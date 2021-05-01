package com.morse.ramadan.externsion

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.BounceInterpolator
import android.widget.TextView
import kotlinx.coroutines.*
import java.util.logging.Logger
import kotlin.system.measureTimeMillis

fun View.scaleUpAnimation(animationListner: Animator.AnimatorListener) {
    this?.animate()?.alpha(1f)?.scaleX(1f)?.scaleY(1f)
        ?.setInterpolator(BounceInterpolator())?.setDuration(2500)
        ?.setListener(animationListner)
        ?.start()
}

fun View.translateYwithScaleAnimation(
    zTransition: Float,
    scaleValue: Float,
    listener: Animator.AnimatorListener? = null
) {
    this?.animate()?.translationY(zTransition)?.scaleX(scaleValue)?.scaleY(scaleValue)
        ?.setInterpolator(BounceInterpolator())?.setDuration(2500)
        ?.setListener(listener)
        ?.start()
}

fun TextView.floatValueAnimation(toValue: Float) {
    val valueAnimation = ValueAnimator.ofFloat(0.0f, toValue)
    valueAnimation.addUpdateListener {
        setText(String.format("%.02f", it.getAnimatedValue()))

    }
    valueAnimation.setDuration(2000)
    valueAnimation.start()
}

fun TextView.intValueAnimation(toValue: Int) {
    val valueAnimation = ValueAnimator.ofInt(0, toValue)
    valueAnimation.addUpdateListener {
        setText(it.getAnimatedValue().toString())
    }
    valueAnimation.setDuration(2000)
    valueAnimation.start()
}

