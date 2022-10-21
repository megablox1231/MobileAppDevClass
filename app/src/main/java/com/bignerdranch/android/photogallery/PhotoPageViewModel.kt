package com.bignerdranch.android.photogallery

import android.webkit.WebView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PhotoPageViewModel : ViewModel() {
    private val mutableWebView = MutableLiveData<WebView>()
    val webView: WebView?
        get() = mutableWebView.value

    fun setWebView(web: WebView) {
        mutableWebView.value = web
    }
}