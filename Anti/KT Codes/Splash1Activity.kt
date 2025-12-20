package com.example.antiquora

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Splash1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash1)

        val logo = findViewById<ImageView>(R.id.logoImage)
        val quoteText = findViewById<TypeWriterTextView>(R.id.quoteText)

        val popAnimation = AnimationUtils.loadAnimation(this, R.anim.pop_out)
        logo.startAnimation(popAnimation)

        quoteText.setCharacterDelay(60)
        quoteText.animateText("Antiquora - Explore History, Anywhere, Anytime  ")


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 4500)
    }
}
