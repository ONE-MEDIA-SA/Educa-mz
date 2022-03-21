package com.app.educa.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.app.educa.R
import com.app.educa.databinding.ActivityGameBinding
import com.app.educa.model.Question
import com.app.educa.utils.Constants

class GameActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityGameBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        binding.tvOption1.setOnClickListener { this }
        binding.tvOption2.setOnClickListener { this }
        binding.tvOption3.setOnClickListener { this }
        binding.tvOption4.setOnClickListener { this }

        binding.pbScore.setOnClickListener{
            Toast.makeText(this, "Score", Toast.LENGTH_SHORT).show()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val question = mQuestionList!!.get(mCurrentPosition - 1)

        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size) {
            //TODO btn_submit.text = "Finish"
        } else {
           //TODO btn_submit.text = "Submit"
        }

        binding.pbScore.progress = mCurrentPosition / binding.pbScore.max

        binding.tvQuestion.text = question.question
        binding.tvOption1.text = question.optionOne
        binding.tvOption2.text = question.optionTwo
        binding.tvOption3.text = question.optionThree
        binding.tvOption4.text = question.optionFour
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, binding.tvOption1)
        options.add(1, binding.tvOption2)
        options.add(2, binding.tvOption3)
        options.add(3, binding.tvOption4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.bg_question
            )
        }

    }

    override fun onClick(v: View?) {
        println("hiii")
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        when (v?.id) {
            R.id.tv_option_1 -> {
                selectedOptionView(binding.tvOption1, 1)
            }
            R.id.tv_option_2 -> {
                selectedOptionView(binding.tvOption2, 2)
            }
            R.id.tv_option_3 -> {
                selectedOptionView(binding.tvOption3, 3)
            }
            R.id.tv_option_4 -> {
                selectedOptionView(binding.tvOption4, 4)
            }

        }
        checkAnswer()
    }

    private fun checkAnswer() {

            if (mSelectedOptionPosition == 0) {
                mCurrentPosition++

                when {
                    mCurrentPosition <= mQuestionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        Toast.makeText(
                            this,
                            "You have successfully completed the Quiz", Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this,GameActivity::class.java)
                        startActivity(intent)
                    }
                }
            } else {
                val question = mQuestionList?.get(mCurrentPosition - 1)
                if (question!!.correctOption != mSelectedOptionPosition) {
                    answerView(mSelectedOptionPosition, R.drawable.bg_question_error)
                }
                answerView(question.correctOption, R.drawable.bg_outline)
                if (mCurrentPosition == mQuestionList!!.size) {
                    //TODO btn_submit.text = "Finish"
                } else {
                    //TODO btn_submit.text = "Go to next question"
                }
                mSelectedOptionPosition = 0
            }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.bg_question_selected
        )
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.tvOption1.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                binding.tvOption2.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                binding.tvOption3.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                binding.tvOption4.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}