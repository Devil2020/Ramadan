package com.morse.ramadan.core

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import java.io.FileDescriptor
import kotlin.coroutines.CoroutineContext

class MediaManager(private val context: Context) {

    private var mediaPlayer: MediaPlayer = MediaPlayer()

    private var ticker : ReceiveChannel<Unit> ?= null

    fun getMediaPlayerObject() = mediaPlayer

    fun setFile(file: FileDescriptor) {
        mediaPlayer.reset()
        mediaPlayer.setDataSource(file)
    }

    fun seekTo(sec: Int) {
        mediaPlayer.seekTo(sec)
    }

    fun isPlaying() = mediaPlayer.isPlaying

    fun play() {
        mediaPlayer.prepare()
        mediaPlayer.start()
    }

    fun pause() {
        mediaPlayer.pause()
    }

    fun listenToUpdateValueListener() : ReceiveChannel<Unit>{
      return ticker ?: ticker (100 , 0).apply {
          ticker = this
      }
    }

    fun removeUpdateValueListener() {
        ticker?.cancel()
        ticker = null
    }

    fun release() {
        mediaPlayer.release()
    }

}