package com.quiz_app

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

   //Declaring constant variable
    private var mcurrentposition : Int = 1
    private var mquestionlist:ArrayList<Question>? = null
    private var mselectedoptionpositon: Int = 0
    private var musername:String? = null
    private var mcorrectanswer: Int = 0

    //Declaring the activity_quiz_question xml
    private var tv_Question: TextView? = null
    private var tv_image : ImageView? = null
    private var tv_progressbar: ProgressBar? = null
    private var tv_progress_count: TextView? = null
    private var tvoptionone:TextView? = null
    private var tvoptiontwo:TextView? = null
    private var tvoptionthree:TextView? = null
    private var tvoptionfour:TextView? = null
    private var sumit_button:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        //setting constent variable
        musername = intent.getStringExtra(Constants.USER_NAME)
        tv_Question = findViewById(R.id.tv_question)
        tv_image = findViewById(R.id.tv_imageView)
        tv_progressbar = findViewById(R.id.tv_progressBar)
        tv_progress_count = findViewById(R.id.tv_progress_count)

        //setting the findviewby id
        tvoptionone = findViewById(R.id.tv_option_one)
        tvoptiontwo = findViewById(R.id.tv_option_two)
        tvoptionthree = findViewById(R.id.tv_option_three)
        tvoptionfour = findViewById(R.id.tv_option_four)
        mquestionlist = Constants.getQuestions()
        sumit_button = findViewById(R.id.sumit_buttonn)

        //setting onclick listiner for all three buttons
        tvoptionone?.setOnClickListener(this)
        tvoptiontwo?.setOnClickListener(this)
        tvoptionthree?.setOnClickListener(this)
        tvoptionfour?.setOnClickListener(this)
        sumit_button?.setOnClickListener(this)

        setquestion()
        defaultoptionview()
    }

    //setup the question by changeing the UI
    private fun setquestion() {
        defaultoptionview()
        val question: Question = mquestionlist!![mcurrentposition - 1]
        tv_Question?.text = question.question
        tv_image?.setImageResource(question.image)
        tv_progressbar?.progress = mcurrentposition
        tv_progress_count?.text = "$mcurrentposition/${tv_progressbar?.max}"
        tvoptionone?.text = question.optionone
        tvoptiontwo?.text = question.optiontwo
        tvoptionthree?.text = question.optionthree
        tvoptionfour?.text = question.optionfour

        if(mcurrentposition == mquestionlist!!.size){
            sumit_button?.text = "FINISH"
        }
        else{
        sumit_button?.text="SUBMIT"
        }
    }

    //change the four options to default UI like white
    private fun defaultoptionview(){
        val options = ArrayList<TextView>()
        tvoptionone?.let{
            options.add(0,it)
        }
        tvoptiontwo?.let{
            options.add(1,it)
        }
        tvoptionthree?.let{
            options.add(2,it)
        }
        tvoptionfour?.let{
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_border_bg
            )
        }
    }

    // function for selected any one option
    private fun selectedoptionview(tv:TextView,selected_option_num:Int){
        defaultoptionview()
        mselectedoptionpositon = selected_option_num

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background  = ContextCompat.getDrawable(
                this,
        R.drawable.selected_option_border_bg
        )
    }

    // this is the click function for the four butons & calls selectedoptionview()
    // created function submit_button to what to do
    override fun onClick(vieew: View?) {
        when(vieew?.id){
            R.id.tv_option_one -> {
                tvoptionone?.let {
                    selectedoptionview(it, 1)
                }
            }
            R.id.tv_option_two -> {
                tvoptiontwo?.let {
                    selectedoptionview(it, 2)
                }
            }
            R.id.tv_option_three -> {
                tvoptionthree?.let {
                    selectedoptionview(it, 3)
                }
            }
            R.id.tv_option_four -> {
                tvoptionfour?.let {
                    selectedoptionview(it, 4)
                }
            }
            R.id.sumit_buttonn ->{
                if(mselectedoptionpositon==0){
                    Toast.makeText(this, "select any one option", Toast.LENGTH_SHORT).show()

                }

                else{
                    val question = mquestionlist?.get(mcurrentposition-1)
                    if(question!!.correctanswer!=mselectedoptionpositon){
                        answerview(mselectedoptionpositon,R.drawable.wrong_option_border_bg)
                    }else{
                        mcorrectanswer++
                    }

                    answerview(question.correctanswer,R.drawable.correct_option_border_bg)

                    if(mcurrentposition == mquestionlist!!.size){
                        sumit_button?.text="FINISHING"

                            val intent = Intent(this, result_activity::class.java)
                            intent.putExtra(Constants.USER_NAME, musername)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mcorrectanswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mquestionlist?.size)
                            startActivity(intent)
                            finish()

                    }else{
                        sumit_button?.text="GOING TO NEXT QUESTION"
                        Handler().postDelayed({
                            next_question()
                        }, 1000)

                    }

                }
            }
        }

    }
//created a function to solve the fix -- once answer submitted it can be change & submitted
    private fun next_question() {
        mcurrentposition++
        when {
            mcurrentposition <= mquestionlist!!.size -> {
                setquestion()
                mselectedoptionpositon = 0
            }

        }
    }

    //for showing the correct answer
    private fun answerview(answer:Int, drawableView: Int){
        when(answer){
            1 ->{
                tvoptionone?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvoptiontwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 ->{
                tvoptionthree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 ->{
                tvoptionfour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

        }
    }

}