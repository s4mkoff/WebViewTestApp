package com.example.webviewapp

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback


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
                    Log.d(TAG, "Fragment back pressed invoked")
                    // Do custom work here
                    if (mWebView.canGoBack()){
                        mWebView.goBack()
                    } else {
                        requireActivity().finishAndRemoveTask()
                        /*if (isEnabled) {
                            isEnabled = false
                            requireActivity().onBackPressed()
                        }*/
                    }
                    // if you want onBackPressed() to be called as normal afterwards

                }
            }
            )
        return view
    }


}