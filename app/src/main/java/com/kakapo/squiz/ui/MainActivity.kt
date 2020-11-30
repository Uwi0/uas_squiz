package com.kakapo.squiz.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kakapo.quizapp.model.Constants
import com.kakapo.quizapp.ui.QuizQuestionActivity
import com.kakapo.squiz.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setStart()
    }

    private fun setStart(){
        btn_start.setOnClickListener {
            if (et_name.text.toString().isEmpty()){
                Toast.makeText(
                        this,
                        "Please Enter Your Name",
                        Toast.LENGTH_SHORT
                ).show()
            }else{
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}