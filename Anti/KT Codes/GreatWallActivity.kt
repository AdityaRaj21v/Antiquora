package com.example.antiquora

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GreatWallActivity : AppCompatActivity() {

    private var is360ViewVisible = false
    private lateinit var webView: WebView
    private lateinit var btn360: FloatingActionButton

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greatwall)

        btn360 = findViewById(R.id.btn_360_view_greatwall)

        val view360 = layoutInflater.inflate(R.layout.activity_360_view, null)
        webView = view360.findViewById(R.id.webView1)

        with(webView.settings) {
            javaScriptEnabled = true
            domStorageEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            allowFileAccess = true
            javaScriptCanOpenWindowsAutomatically = true
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false
        }

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        val url = """
            https://www.google.com/maps/embed?pb=!4v1701593673412!6m8!1m7!
            1sCAoSLEFGMVFpcE1QZ0RmbnRTNVRxSXdod2FqYndTN1AzbU4tZmpMNW5CZlJ0b0dW!
            2m2!1d40.4319077!2d116.5703749!3f0!4f0!5f0.7820865974627469
        """.trimIndent()

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
                    allowfullscreen=""
                    loading="lazy"
                    referrerpolicy="no-referrer-when-downgrade">
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
                setContentView(R.layout.activity_greatwall)
                is360ViewVisible = false
            }
        }
    }

    override fun onBackPressed() {
        if (is360ViewVisible) {
            setContentView(R.layout.activity_greatwall)
            is360ViewVisible = false
        } else {
            super.onBackPressed()
        }
    }
}
