package com.kakapo.squiz.database

data class Soal(
        val optionOne: String,
        val optionTwo: String,
        val optionThree: String,
        val optionFour: String,
        val categoryId : String,
        val correctAnswer: Int,
        val question: String
)
