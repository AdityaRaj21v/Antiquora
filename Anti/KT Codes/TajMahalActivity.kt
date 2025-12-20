package com.example.antiquora

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TajMahalActivity : AppCompatActivity() {

    private var is360ViewVisible = false  // track toggle state

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taj_mahal)

        val btn360 = findViewById<FloatingActionButton>(R.id.btn_360_view)

        val view360 = layoutInflater.inflate(R.layout.activity_360_view, null)
        val webView = view360.findViewById<WebView>(R.id.webView1)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        val url = "https://www.google.com/maps/embed?pb=!4v1696437728009!6m8!1m7!1sCAoSLEFGMVFpcE5rZk1ka2VrV3p3YVhMVXBxQVl1Tjd3V2pYR0ZtWEpubzMza3hG!2m2!1d27.175015!2d78.042155!3f0!4f0!5f0.7820865974627469"

        val html = """
    <html>
    <body style="margin:0; padding:0;">
        <iframe src="$url" width="100%" height="100%" style="border:0;" allowfullscreen></iframe>
    </body>
    </html>
""".trimIndent()

        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)


        btn360.setOnClickListener {
            if (!is360ViewVisible) {
                setContentView(view360)
                is360ViewVisible = true
            } else {
                setContentView(R.layout.activity_taj_mahal)
                is360ViewVisible = false
            }
        }
    }
}
