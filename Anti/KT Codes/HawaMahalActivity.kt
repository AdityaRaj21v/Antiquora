package com.example.antiquora

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HawaMahalActivity : AppCompatActivity() {

    private var is360ViewVisible = false
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hawa)

        val btn360 = findViewById<FloatingActionButton>(R.id.btn_360_view_hawa_mahal)

        val view360 = layoutInflater.inflate(R.layout.activity_360_view, null)
        webView = view360.findViewById(R.id.webView1)

        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.allowFileAccess = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        val url = "https://www.google.com/maps/embed?pb=!4v1701590938939!6m8!1m7!1sCAoSLEFGMVFpcE5pR0Z2bGl3QUd0UUNUcU84V3l4VFdYVEd4RE5DS3pBRnAyVkFh!2m2!1d26.923936!2d75.826744!3f0!4f0!5f0.7820865974627469"
        val html = """
    <html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="margin:0; padding:0; overflow:hidden;">
        <iframe
            src="$url"
            width="100%"
            height="100%"
            style="border:0;"
            allowfullscreen
            loading="lazy">
        </iframe>
    </body>
    </html>
""".trimIndent()

        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)

        btn360.setOnClickListener {
            if (!is360ViewVisible) {
                setContentView(view360)
                is360ViewVisible = true
            } else {
                setContentView(R.layout.activity_hawa)
                is360ViewVisible = false
            }
        }
    }

    override fun onBackPressed() {
        if (is360ViewVisible) {
            setContentView(R.layout.activity_hawa)
            is360ViewVisible = false
        } else {
            super.onBackPressed()
        }
    }
}
