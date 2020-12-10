package com.kakapo.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.kakapo.quizapp.model.Constants
import com.kakapo.squiz.R
import com.kakapo.squiz.model.Question
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUsername: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestion()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = ("FINISH")
                    }else{
                        btn_submit.text = ("GO TO NEXT QUESTION")
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun setQuestion(){

        

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = ("FINISH")
        }else{
            btn_submit.text = ("SUBMIT")
        }
        progress_bar.progress = mCurrentPosition
        tv_progress.text = ("$mCurrentPosition / ${progress_bar.max}")

        tv_question.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        options.forEach {
            it.setTextColor(Color.parseColor("#7A8089"))
            it.typeface = Typeface.DEFAULT
            it.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border_bg
            )
        }
    }

  private fun selectedOptionView(tv: TextView, selectionOptionNumber: Int){
      defaultOptionView()
      mSelectedOptionPosition = selectionOptionNumber
      tv.setTextColor(Color.parseColor("#363A43"))
      tv.setTypeface(tv.typeface, Typeface.BOLD)
      tv.background = ContextCompat.getDrawable(
              this,
              R.drawable.selected_option_border_bg
      )
  }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            2 ->{
                tv_option_two.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            4 ->{
                tv_option_four.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
        }
    }
}