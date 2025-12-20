package com.example.antiquora

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MonumentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monument_detail)

        val name = intent.getStringExtra("name")
        val place = intent.getStringExtra("place")
        val image = intent.getIntExtra("image", 0)

        findViewById<TextView>(R.id.monumentImage).text = name
        findViewById<TextView>(R.id.monumentPlace).text = place
        findViewById<ImageView>(R.id.monumentImage).setImageResource(image)
    }
}
