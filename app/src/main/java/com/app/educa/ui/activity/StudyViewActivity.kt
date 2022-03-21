package com.app.educa.ui.activity

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.app.educa.databinding.ActivityStudyViewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.w3c.dom.Document
import java.io.IOException
import java.lang.Math.random
import kotlin.random.Random

class StudyViewActivity : AppCompatActivity() {

    var query = "Botanica"
    var BASE_URL = ""
    lateinit var binding: ActivityStudyViewBinding
    private lateinit var webView: WebView
    private lateinit var toolbar: Toolbar
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudyViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        query = intent.getStringExtra("query").toString()

        BASE_URL = "https://www.google.com/search?q=$query"
        webView = binding.webview
        progressBar = binding.progressBar

        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = query

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true)
        WebScratch().execute()
    }

    private fun startWebView(url: String) {
        webView.settings.setJavaScriptEnabled(true)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                url?.let { view?.loadUrl(it) }
                return true
            }
        }
        webView.loadUrl(url)
        progressBar.visibility = View.GONE
    }

    suspend fun getHtml(url: String) {
        withContext(Dispatchers.IO) {
            val html = Jsoup.connect(url).get()
            html.toString()
        }
    }

    inner class WebScratch : AsyncTask<Void, Void, Void>() {
        private lateinit var searchStr: String
        override fun doInBackground(vararg params: Void): Void? {
            try {

                val doc: org.jsoup.nodes.Document? = Jsoup.connect(BASE_URL)
                    .userAgent("Mozilla/5.0 Gecko/20100101 Firefox/21.0")
                    .get()

                var linkList: MutableList<String> = mutableListOf()

                doc?.select("a")?.forEach {
                    if (it.attr("href").contains("&url")) {
                        var link = it.attr("href");
                        linkList.add("https://www.google.com/$link")
                    }
                }

                if (linkList.size > 0) {
                    searchStr = linkList[Random.nextInt(1, linkList.size - 1)]
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }
        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            if(searchStr != null) {
                startWebView(searchStr)
            } else {
                Toast.makeText(this@StudyViewActivity, "No results found", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}