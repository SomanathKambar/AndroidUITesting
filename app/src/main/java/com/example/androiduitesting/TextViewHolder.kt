package com.example.androiduitesting

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  var textView: TextView = itemView as TextView
}