package com.example.antiquora

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RateUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_us)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val feedbackInput = findViewById<EditText>(R.id.feedbackInput)
        val submitBtn = findViewById<Button>(R.id.submitRating)

        submitBtn.setOnClickListener {
            val rating = ratingBar.rating
            val feedback = feedbackInput.text.toString().trim()

            if (rating == 0f) {
                Toast.makeText(this, "Please select a rating.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "Thanks for rating $rating★\nYour feedback: $feedback",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
    }
}
