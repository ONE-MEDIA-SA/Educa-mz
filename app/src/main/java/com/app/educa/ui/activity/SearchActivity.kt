package com.app.educa.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.app.educa.R
import com.app.educa.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.purple_500)

        binding.edSearch.requestFocus()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)

        binding.btnSearch.setOnClickListener {

            var query:String = binding.edSearch.text.toString()
            println("Query = " +query)

            if (query.isNotEmpty()) {
                var intent = Intent(this, StudyViewActivity::class.java).apply {
                    putExtra("query", query )
                }
                startActivity(intent)
            } else {

            }

        }

    }
}