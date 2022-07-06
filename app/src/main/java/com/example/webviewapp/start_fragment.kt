package com.example.webviewapp


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button


class start_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.layout_start_fragment, container, false)
        val agreeButton: Button = view.findViewById(R.id.privacy_agree)
        val declineButton: Button = view.findViewById(R.id.privacy_decline)
        val policyView: WebView = view.findViewById(R.id.privacyView)
        policyView.loadUrl("https://www.privacypolicygenerator.info/live.php?token=4JVcA8e5sum2iCQnVJZannlVuKmubgxl")
        agreeButton.setOnClickListener {
            val sharedPreferences = this.getActivity()?.getSharedPreferences("app", Context.MODE_PRIVATE)
            sharedPreferences?.edit()?.putBoolean("Boolean", true)?.apply()
            val fragment = webview_fragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.remove(this)?.replace(R.id.fullcreen_holder, fragment)?.commit()
        }
        declineButton.setOnClickListener {
            requireActivity().finishAndRemoveTask()
        }
        return view
    }

}
