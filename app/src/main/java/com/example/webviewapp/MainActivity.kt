package com.example.webviewapp

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    var pref: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pref = getSharedPreferences("LAUNCHED", Context.MODE_PRIVATE)
        val firstlauch = pref?.getBoolean("LAUNCHED", true)
        Log.d(TAG, "loadData completed, ${firstlauch}")
        if (firstlauch == true) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fullcreen_holder, start_fragment())
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fullcreen_holder, webview_fragment())
        }
    }
}
