package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_spain, true),
        Question(R.string.question_mexico, false),
        Question(R.string.question_iceland, false),
        Question(R.string.question_africa, true),
        Question(R.string.question_madagascar, true),
        Question(R.string.question_china, false))

    var currentIndex = 0
    var isCheater = false

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        if (currentIndex != 0) {
            currentIndex = (currentIndex - 1) % questionBank.size
        }
        else currentIndex = questionBank.size - 1
    }
}