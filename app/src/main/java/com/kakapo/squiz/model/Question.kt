package com.kakapo.squiz.model

data class Question(
        val optionOne: String,
        val optionTwo: String,
        val optionThree: String,
        val optionFour: String,
        val categoryId : String,
        val correctAnswer: Int,
        val question: String

)