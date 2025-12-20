package com.example.antiquora

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MonumentAdapter(
    private val context: Context,
    monuments: List<Monument>
) : BaseAdapter() {

    private var originalList: List<Monument> = monuments   // Full list
    private var filteredList: List<Monument> = monuments   // List to display

    override fun getCount(): Int = filteredList.size
    override fun getItem(position: Int): Any = filteredList[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_monument, parent, false)

        val monument = filteredList[position]

        val imageView = view.findViewById<ImageView>(R.id.monumentImage)
        val nameText = view.findViewById<TextView>(R.id.monumentName)
        val placeText = view.findViewById<TextView>(R.id.monumentPlace)

        imageView.setImageResource(monument.imageResId)
        nameText.text = monument.name
        placeText.text = monument.place

        return view
    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            originalList
        } else {
            originalList.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }
}
