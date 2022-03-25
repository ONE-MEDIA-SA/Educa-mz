package com.app.educa.ui.viewmodel

import android.util.MutableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private var _score = MutableLiveData<Int>()
    val score: MutableLiveData<Int>
        get() = _score

    private var _correctAnswers = MutableLiveData<Int>()
    val correctAnswers: MutableLiveData<Int>
        get() = _correctAnswers

    private var _wrongAnswers = MutableLiveData<Int>()
    val wrongAnswers: MutableLiveData<Int>
        get() = _wrongAnswers

    private var _currentQuestion = MutableLiveData<Int>()
    val currentQuestion: MutableLiveData<Int>
        get() = _currentQuestion

    fun incrementCorrectAnswers() {
        _correctAnswers.value = _correctAnswers.value?.plus(1)
    }

    fun incrementWrongAnswers() {
        _wrongAnswers.value = _wrongAnswers.value?.plus(1)
    }


    init {
        score.value = 0
        correctAnswers.value = 0
        wrongAnswers.value = 0
        currentQuestion.value = 0
    }




}