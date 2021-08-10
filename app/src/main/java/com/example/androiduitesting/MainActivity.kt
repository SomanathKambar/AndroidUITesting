package com.example.androiduitesting

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var greetMesaageView : TextView
    private lateinit var greetButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        greetMesaageView = findViewById(R.id.greetMessageView)
        greetButton = findViewById(R.id.greetButton)
        setTitle(R.string.title)


        val recyclerView : RecyclerView = findViewById(R.id.recycler_view)
        val footer = findViewById<AppCompatTextView>(R.id.footer)
        footer.setBackgroundColor(Color.LTGRAY)
        footer.visibility = View.GONE

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NumberedAdapter(30, object : NumberedAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                footer.text = position.toString()
                footer.visibility = View.VISIBLE
            }
        })
    }

    fun greet(view: View) {
        greetButton.isEnabled = false
        greetMesaageView.setText(R.string.hello)
    }
}