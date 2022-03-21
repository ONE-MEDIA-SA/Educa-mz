package com.app.educa.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import com.app.educa.R
import com.app.educa.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding
    lateinit var tv_question: TextView
    lateinit var tv_score: TextView
    lateinit var tv_win_count: TextView
    lateinit var tv_lost_count: TextView
    lateinit var tv_option_1: TextView
    lateinit var tv_option_2: TextView
    lateinit var tv_option_3: TextView
    lateinit var tv_option_4: TextView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        initViews()
        handleClick()

    }

    private fun handleClick() {
        tv_option_1.setOnClickListener { this }
        tv_option_2.setOnClickListener { this }
        tv_option_3.setOnClickListener { this }
        tv_option_4.setOnClickListener { this }
    }

    private fun initViews() {
        tv_question = binding.tvQuestion
        tv_score = binding.tvScore
        tv_win_count = binding.tvWinCount
        tv_lost_count = binding.tvLostCount
        tv_option_1 = binding.tvOption1
        tv_option_2 = binding.tvOption2
        tv_option_3 = binding.tvOption3
        tv_option_4 = binding.tvOption4
        progressBar = binding.pbScore
    }
}