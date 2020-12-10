package com.kakapo.squiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kakapo.squiz.adapter.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_quiz_menu.*


lateinit var RV_new_menu: RecyclerView

class QuizMenuFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_quiz_menu, container, false)


    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        RV_new_menu = RVCourse
        val recyclerView = RVCourse as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val Category = ArrayList<Category>()

        Category.add(Category("Kotlin"))
        Category.add(Category("Java"))
        Category.add(Category("Math"))
        Category.add(Category("Math"))
        Category.add(Category("Math"))

        val adapter = CategoryAdapter(Category)
        recyclerView.adapter = adapter
    }



    companion object {
        fun newInstance(): QuizMenuFragment{
                val fragment = QuizMenuFragment()
                val args = Bundle()
                fragment.arguments = args
                return fragment
                }
    }
}