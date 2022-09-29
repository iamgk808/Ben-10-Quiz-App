package com.quiz_app

//this is object file
//declare all the question in this object file
object Constants {

    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS:String = "correct_answers"

    val set_question:String = "what is the name of this alien ?"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        //1
        val que1= Question(
            1,
            set_question,
        R.drawable.xlr8,
        "Spider Monkey","Xlr8","Big chill","Eye Guy",
            2
        )
        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, set_question,
            R.drawable.upgrade,
            "Diamondhead", "Heat blast",
            "Upgrade", "Four Arms", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, set_question,
            R.drawable.diamond_head,
            "Grey Matter", "XLR8",
            "Four Arms", "Diamond head", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, set_question,
            R.drawable.heatblast,
            "Ripjaws", "heat blast",
            "Wild mutt", "Ghost freak ", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, set_question,
            R.drawable.stinkfly,
            "Stink fly", "Upgrade",
            "Ghost freak", "Ripjaws", 1
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, set_question,
            R.drawable.four_arms,
            "Cannon bolt", "Four arms",
            "Ditto", "Humungousar", 2
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, set_question,
            R.drawable.grey_matter,
            "Goop", "Chromastone",
            "Rath", "Grey matter", 4
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, set_question,
            R.drawable.ghost_freak,
            "Ghost freak", "Jetray",
            "Nanomech", "Brain strom", 1
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, set_question,
            R.drawable.wild_mutt,
            "Terra spin", "Feed back",
            "Wild mutt", "Alien X", 3
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, set_question,
            R.drawable.rip_jaws,
            "Cannon bolt", "Rip jaws",
            "Echo Echo", "Way big", 2
        )

        questionsList.add(que10)

        return questionsList
    }
}