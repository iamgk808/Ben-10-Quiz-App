package com.quiz_app

//this is data class file

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val optionone: String,
    val optiontwo: String,
    val optionthree: String,
    val optionfour: String,
    val correctanswer: Int
)
