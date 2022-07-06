package com.example.webviewapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (getSharedPreferences("app", Context.MODE_PRIVATE).getBoolean("Boolean", false) == false) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fullcreen_holder, start_fragment())
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fullcreen_holder, webview_fragment())
                .commit()
        }
    }
}
