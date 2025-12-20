package com.example.antiquora

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TypeWriterTextView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    private var textToAnimate: CharSequence = ""
    private var index = 0
    private var delay: Long = 50  // typing speed (milliseconds per character)
    private val handler = Handler()

    private val characterAdder = object : Runnable {
        override fun run() {
            text = textToAnimate.subSequence(0, index++)
            if (index <= textToAnimate.length) {
                handler.postDelayed(this, delay)
            }
        }
    }

    fun animateText(txt: CharSequence) {
        textToAnimate = txt
        index = 0
        text = ""
        handler.removeCallbacks(characterAdder)
        handler.postDelayed(characterAdder, delay)
    }

    fun setCharacterDelay(millis: Long) {
        delay = millis
    }
}
