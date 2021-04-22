package com.morse.ramadan.core

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import java.io.FileDescriptor

class MediaManager(private val context: Context) {

    private var mediaPlayer: MediaPlayer = MediaPlayer()

    fun getMediaPlayerObject () = mediaPlayer

    fun start (file: FileDescriptor){
        mediaPlayer.setDataSource(file)
        mediaPlayer.prepare()
        mediaPlayer.start()
    }

    fun seekTo(sec: Int) {
        mediaPlayer.seekTo(sec)
    }

    fun play () {
        mediaPlayer.start()
    }

    fun pause () {
        mediaPlayer.pause()
    }

    fun release() {
        mediaPlayer.release()
    }

}