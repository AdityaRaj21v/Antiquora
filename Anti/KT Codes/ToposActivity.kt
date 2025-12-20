package com.example.antiquora

import android.content.Intent
import android.os.Bundle
import androidx.cardview.widget.CardView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ToposActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topos)

        val homeBtn = findViewById<ImageButton>(R.id.nav_home)
        val globeBtn = findViewById<ImageButton>(R.id.nav_globe)
        val profileBtn = findViewById<ImageButton>(R.id.nav_profile)

        homeBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        globeBtn.setOnClickListener {

        }
        profileBtn.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }


        findViewById<CardView>(R.id.card_taj).setOnClickListener {
            startActivity(Intent(this, TajMahalActivity::class.java))
        }
        findViewById<CardView>(R.id.card_pyramid).setOnClickListener {
            startActivity(Intent(this, PyramidActivity::class.java))
        }
        findViewById<CardView>(R.id.card_colosseum).setOnClickListener {
            startActivity(Intent(this, ColosseumActivity::class.java))
        }
        findViewById<CardView>(R.id.card_greatwall).setOnClickListener {
            startActivity(Intent(this, GreatWallActivity::class.java))
        }
        findViewById<CardView>(R.id.card_acropolis).setOnClickListener {
            startActivity(Intent(this, AcropolisActivity::class.java))
        }
        findViewById<CardView>(R.id.card_eiffel).setOnClickListener {
            startActivity(Intent(this, EiffelTowerActivity::class.java))
        }
        findViewById<CardView>(R.id.card_angkor).setOnClickListener {
            startActivity(Intent(this, AngkorWatActivity::class.java))
        }
        findViewById<CardView>(R.id.card_chichen).setOnClickListener {
            startActivity(Intent(this, ChichenItzaActivity::class.java))
        }
        findViewById<CardView>(R.id.card_hawa).setOnClickListener {
            startActivity(Intent(this, HawaMahalActivity::class.java))
        }
        findViewById<CardView>(R.id.card_stonehenge).setOnClickListener {
            startActivity(Intent(this, StonehengeActivity::class.java))
        }
    }
}
