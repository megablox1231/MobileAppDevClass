package com.bignerdranch.android.photogallery

import android.os.HandlerThread
import android.util.Log
import androidx.lifecycle.*

private const val TAG = "ThumbnailDownloader"

class ThumbnailDownloader<in T> : HandlerThread(TAG), DefaultLifecycleObserver {

    private var hasQuit = false

    override fun quit(): Boolean {
        hasQuit = true
        return super.quit()
    }

    override fun onCreate(owner: LifecycleOwner) {
        Log.i (TAG, "Starting background thread")
        start()
        looper
    }

    override fun onDestroy (owner: LifecycleOwner) {
        Log.i (TAG, "Destroying background thread")
        quit()
    }

    fun queueThumbnail(target: T, url: String) {
        Log.i(TAG, "Got a URL: $url")
    }
}