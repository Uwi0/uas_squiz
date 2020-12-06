package com.kakapo.squiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {


    private val content : FrameLayout?= null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.nav_quiz -> {
                    val fragment = QuizMenuFragment.newInstance()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_learn -> {
                    val fragment = LearnFragment()
                    addFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
                false

    }

        private fun addFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .commit()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = QuizMenuFragment.newInstance()
        addFragment(fragment)
    }


}