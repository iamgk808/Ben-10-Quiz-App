package com.quiz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start : Button = findViewById(R.id.btn_start)
        val edit_name : EditText = findViewById(R.id.edit_name)

        btn_start.setOnClickListener{
        if (edit_name.text.isEmpty()){
            Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show()
        }
            else{
                //below code is used to change to next activity
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,edit_name.text.toString())
                startActivity(intent)
                finish()
        }
        }
    }
}