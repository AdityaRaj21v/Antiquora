package com.example.antiquora

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var monuments: List<Monument>
    private lateinit var adapter: MonumentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeBtn = findViewById<ImageButton>(R.id.nav_home)
        val globeBtn = findViewById<ImageButton>(R.id.nav_globe)
        val profileBtn = findViewById<ImageButton>(R.id.nav_profile)

        homeBtn.setOnClickListener { }
        globeBtn.setOnClickListener {
            startActivity(Intent(this, ToposActivity::class.java))
        }
        profileBtn.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        monuments = listOf(
            Monument("Chittorgarh Fort", "Chittorgarh, Rajasthan", R.drawable.chitoor),
            Monument("Gateway of India", "Mumbai, Maharashtra", R.drawable.goi),
            Monument("Khajuraho Temples", "Madhya Pradesh", R.drawable.kha),
            Monument("Jaisalmer Fort", "Jaisalmer, Rajasthan", R.drawable.jaisa),
            Monument("Qutub Minar", "Delhi", R.drawable.q),
            Monument("Charminar", "Hyderabad, Telangana", R.drawable.charminar),
            Monument("Konark Sun Temple", "Puri, Odisha", R.drawable.ko),
            Monument("Meenakshi Temple", "Madurai, Tamil Nadu", R.drawable.mee),
            Monument("Ajanta Caves", "Aurangabad, Maharashtra", R.drawable.aja),
            Monument("Taj Mahal", "Agra, Uttar Pradesh", R.drawable.taj_mahal),
            Monument("Red Fort", "Delhi", R.drawable.rf),
            Monument("Hampi Temples", "Karnataka", R.drawable.hampi),
            Monument("Sanchi Stupa", "Madhya Pradesh", R.drawable.ss)
        )

        val gridView = findViewById<GridView>(R.id.recommendationsGrid)
        adapter = MonumentAdapter(this, monuments)
        gridView.adapter = adapter

        val searchBar = findViewById<EditText>(R.id.searchBar)

        searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })


        searchBar.setOnEditorActionListener { _, _, _ ->
            val query = searchBar.text.toString().trim().lowercase()
            val found = monuments.find { it.name.lowercase().contains(query) }

            if (found != null) {
                val intent = Intent(this, MonumentDetailActivity::class.java)
                intent.putExtra("name", found.name)
                intent.putExtra("place", found.place)
                intent.putExtra("image", found.imageResId)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Monument not found", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}
