package com.example.antiquora

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class  ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val homeBtn = findViewById<ImageButton>(R.id.nav_home)
        val globeBtn = findViewById<ImageButton>(R.id.nav_globe)
        val profileBtn = findViewById<ImageButton>(R.id.nav_profile)

        val rateUsLayout = findViewById<LinearLayout>(R.id.rate_us)
        val termsLayout = findViewById<LinearLayout>(R.id.terms)
        val logoutLayout = findViewById<LinearLayout>(R.id.logout)
        val feedbackLayout = findViewById<LinearLayout>(R.id.feedback)

        homeBtn.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        globeBtn.setOnClickListener {
            startActivity(Intent(this, ToposActivity::class.java))
        }

        rateUsLayout.setOnClickListener {
            val intent = Intent(this, RateUsActivity::class.java)
            startActivity(intent)
        }

        termsLayout.setOnClickListener {
            val intent = Intent(this, TermsActivity::class.java)
            startActivity(intent)
        }

        feedbackLayout.setOnClickListener {
            val intent = Intent(this, FeedbackActivity::class.java)
            startActivity(intent)
        }

        logoutLayout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            // Clears previous activities to prevent back navigation
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
