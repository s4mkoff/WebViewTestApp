package com.example.webviewapp

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


class webview_fragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view : View = inflater.inflate(R.layout.layout_webview_fragment, container, false)
        val  mWebView : WebView = view.findViewById(R.id.webViewMain)
        mWebView.loadUrl("https://google.com")
        val webSettings = mWebView.getSettings()
        webSettings.setJavaScriptEnabled(true)
        mWebView.setWebViewClient(WebViewClient())
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Log.d(TAG, "Back button pressed")
                    if (mWebView.canGoBack()){
                        mWebView.goBack()
                    } else {
                        requireActivity().finishAndRemoveTask()
                    }
                }
            }
            )
        return view
    }
}