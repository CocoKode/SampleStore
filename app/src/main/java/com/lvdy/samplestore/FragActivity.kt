package com.lvdy.samplestore

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FragActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.text = "我是fragactivity"
        setContentView(textView)
    }
}
