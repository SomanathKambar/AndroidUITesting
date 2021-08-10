package com.example.androiduitesting

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var greetMesaageView : TextView
    private lateinit var greetButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        greetMesaageView = findViewById(R.id.greetMessageView)
        greetButton = findViewById(R.id.greetButton)
        setTitle(R.string.title)
    }

    fun greet(view: View) {
        greetButton.isEnabled = false
        greetMesaageView.setText(R.string.hello)
    }
}