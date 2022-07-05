package com.example.webviewapp

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class start_fragment : Fragment() {
    var pref: SharedPreferences? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.layout_start_fragment, container, false)
        val agreeButton: Button = view.findViewById(R.id.privacy_agree)
        val declineButton: Button = view.findViewById(R.id.privacy_decline)
        agreeButton.setOnClickListener {
            saveData(false)
            val fragment = webview_fragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.remove(this)?.replace(R.id.fullcreen_holder, fragment)?.commit()
        }
        declineButton.setOnClickListener {
            requireActivity().finishAndRemoveTask()
        }
        return view
    }
    fun saveData(bool: Boolean) {
        pref = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = pref?.edit()
        editor?.putBoolean("LAUNCHED", bool)
        editor?.apply()
        Log.d(TAG, "saveData complete")
    }
}
