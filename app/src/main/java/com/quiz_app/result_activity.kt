package com.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class result_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvname: TextView = findViewById(R.id.tv_name)
        val tvscore: TextView = findViewById(R.id.tv_score)
        val btnfinish: Button = findViewById(R.id.btn_finish)

        val totalquestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctanswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvname.text = intent.getStringExtra(Constants.USER_NAME)
        tvscore.text = "your score is $correctanswer out of $totalquestion "
        btnfinish.setOnClickListener{
                startActivity(Intent(this,MainActivity::class.java))
        }
    }
}